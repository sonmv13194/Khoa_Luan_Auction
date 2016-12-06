package vn.smartdev.controller;

import net.shibboleth.utilities.java.support.net.HttpServletRequestResponseContext;
import org.apache.regexp.RE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import vn.smartdev.category.dao.entity.Category;
import vn.smartdev.category.manager.CategoryServices;
import vn.smartdev.product.dao.entity.Product;
import vn.smartdev.product.dao.entity.ProductDetail;
import vn.smartdev.product.dao.entity.ProductImage;
import vn.smartdev.product.dao.model.ProductDetailModel;
import vn.smartdev.product.dao.model.ProductImageModel;
import vn.smartdev.product.dao.model.ProductModel;
import vn.smartdev.product.manager.ProductDetailServices;
import vn.smartdev.product.manager.ProductImageServices;
import vn.smartdev.product.manager.ProductServices;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by Nhat on 01/12/2016.
 */
@Controller
@RequestMapping(value = "/admin")
@Transactional
public class ProductController {

    @Autowired
    private ProductServices productServices;

    @Autowired
    private ProductDetailServices productDetailServices;

    @Autowired
    private CategoryServices categoryServices;

    @Autowired
    private ProductImageServices productImageServices;


    @RequestMapping(value="/viewProduct",method = RequestMethod.GET)
    public String viewProduct(ModelMap modelMap,HttpSession session)
    {
        List<Product> listProducts = productServices.getListProduct();
        List<ProductDetail> listProductDetails = productDetailServices.getListProductDetail();
        String message = (String) session.getAttribute("message");
        modelMap.put("message",message);
        modelMap.put("listProducts", listProducts);
        modelMap.put("listProductDetails",listProductDetails);
        return "viewProduct";
    }

    @RequestMapping(value="/deleteProduct",method = RequestMethod.GET)
    public String deleteProduct(@RequestParam("productId") String productId,ModelMap modelMap)
    {

        //delete Product
        productServices.deleteProduct(productId);
        modelMap.put("message", "Delete complete Product Name : " + productId);

        return "redirect:viewProduct";
    }

    @RequestMapping(value="/updateProduct",method = RequestMethod.GET)
    public String updateProduct(@RequestParam("productId") String productId,ModelMap modelMap)
    {
        Product product = productServices.getProduct(productId);
        List<Category> listCategory = categoryServices.getListCategory();
        modelMap.put("product", product);
        modelMap.put("listCategory",listCategory);

        return "updateProduct";
    }
    @RequestMapping(value="/updateProductPost",method = RequestMethod.POST)
    public String updateProductPost(HttpServletRequest request)
    {
        //data Product
        String productId = request.getParameter("productId");
        String productName = request.getParameter("productName");
        String description = request.getParameter("description");
        String categoryId = request.getParameter("categoryId");
//      String nameImage = file.getOriginalFilename();

        //data ProductDetail
        float priceProduct = Float.parseFloat(request.getParameter("priceProduct"));
        int quantityProduct = Integer.parseInt(request.getParameter("quantityProduct"));
        String supplyerProduct = request.getParameter("supplyerProduct");

        //Product
        Product product = new Product();
        product.setProductName(productName);
        product.setDescription(description);

        productServices.saveProduct(product);

        //ProductDetail
//        ProductDetail productDetail = new ProductDetail(description,"123",priceProduct,quantityProduct,1,supplyerProduct);
//        productDetail.setId("3");

        return "redirect:viewProduct";
    }
    @RequestMapping(value = "/createProduct",method = RequestMethod.GET)
    public String createProduct(ModelMap modelMap,@RequestParam("checkCreate") String checkCreate,@RequestParam("productId") String productId,@RequestParam("productName") String productName)
    {
        List<Category> listCategory = categoryServices.getListCategory();

        modelMap.put("listCategory",listCategory);
        modelMap.put("checkCreate",checkCreate);
        modelMap.put("productId",productId);
        modelMap.put("productName",productName);
        return "createProduct";
    }

    @RequestMapping(value="/createProductPost",method = RequestMethod.POST)
    public String createProductPost(HttpServletRequest request,@RequestParam("uploadImage") CommonsMultipartFile file,HttpSession session)
    {
        //data Product
        String productName = request.getParameter("productName");
        String description = request.getParameter("description");
        String categoryId = request.getParameter("categoryId");
        String checkProductId = request.getParameter("productId");
        //redirect create Product and ProductDetail

        //data ProductDetail
        int productStatus = Integer.parseInt(request.getParameter("productStatus"));
        float priceProduct = Float.parseFloat(request.getParameter("priceProduct"));
        int quantityProduct = Integer.parseInt(request.getParameter("quantityProduct"));
        String supplyerProduct = request.getParameter("supplyerProduct");

        //model
        ProductModel productModel = new ProductModel(productName,description);
        ProductDetailModel productDetailModel = new ProductDetailModel(description,productStatus,priceProduct,quantityProduct,supplyerProduct);
        ProductImageModel productImageModel = new ProductImageModel(file.getOriginalFilename());

        //upload file
        String filename = file.getOriginalFilename();
        List<ProductImage> listProductImages = productImageServices.getListProductImage();
        boolean checkExistNameImage = productImageServices.checkNameImage(listProductImages,filename);
        if(checkExistNameImage == true)
        {
            session.setAttribute("message", "Name image is exist in system ,please rename image ...");
            return "redirect:createProduct";
        }
        else
        {
            String urlImage = session.getServletContext().getRealPath("/images")+filename;
            boolean upload = productImageServices.uploadFile(file, urlImage);

            if(checkProductId.equals(""))
            {
                Product product = productServices.createProduct(categoryId, productModel);
                productServices.saveProduct(product);
                ProductDetail productDetail = productDetailServices.createProductDetail(productDetailModel,product);
                productDetailServices.saveProductDetail(productDetail);

                ProductImage productImage = productImageServices.createProductImage(productImageModel, productDetail);
                productImageServices.savePorductImage(productImage);
            }
            else
            {
                Product product = productServices.getProduct(checkProductId);
                ProductDetail productDetail = productDetailServices.createProductDetail(productDetailModel,product);
                productDetailServices.saveProductDetail(productDetail);

                ProductImage productImage = productImageServices.createProductImage(productImageModel, productDetail);
                productImageServices.savePorductImage(productImage);
            }

            return "redirect:viewProduct";
        }
    }

}