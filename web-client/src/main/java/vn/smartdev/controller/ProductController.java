package vn.smartdev.controller;

import org.apache.regexp.RE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import vn.smartdev.category.dao.entity.Category;
import vn.smartdev.category.manager.CategoryServices;
import vn.smartdev.product.dao.entity.Product;
import vn.smartdev.product.dao.entity.ProductDetail;
import vn.smartdev.product.manager.ProductDetailServices;
import vn.smartdev.product.manager.ProductServices;

import javax.servlet.http.HttpServletRequest;
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


    @RequestMapping(value="/viewProduct",method = RequestMethod.GET)
    public String viewProduct(ModelMap modelMap)
    {
        List<Product> listProducts = productServices.getListProduct();
        List<ProductDetail> listProductDetails = productDetailServices.getListProductDetail();
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
        ProductDetail productDetail = productDetailServices.getProductDetail(productId);
        modelMap.put("product", product);
        modelMap.put("productDetail", productDetail);
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
//        String nameImage = file.getOriginalFilename();

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

        return "redirect:/admin/viewProduct";
    }
    @RequestMapping(value = "/createProduct",method = RequestMethod.GET)
    public String createProduct(ModelMap modelMap)
    {
        List<Category> listCategory = categoryServices.getListCategory();

        modelMap.put("listCategory",listCategory);
        return "createProduct";
    }
    @RequestMapping(value="/createProductPost",method = RequestMethod.POST)
    public String createProductPost(HttpServletRequest request)
    {
        //data Product
        String productName = request.getParameter("productName");
        String description = request.getParameter("description");
        String categoryId = request.getParameter("categoryId");

        //data ProductDetail
        int productStatus = Integer.parseInt(request.getParameter("productStatus"));
        float priceProduct = Float.parseFloat(request.getParameter("priceProduct"));
        int quantityProduct = Integer.parseInt(request.getParameter("quantityProduct"));
        String supplyerProduct = request.getParameter("supplyerProduct");

        Product product = productServices.createProduct(productName, description, categoryId);
        ProductDetail productDetail = productDetailServices.createProductDetail(productStatus,priceProduct,quantityProduct,supplyerProduct);

        productServices.saveProduct(product);
        productDetailServices.saveProductDetail(productDetail);
        return "redirect:/admin/viewProduct";
    }

}