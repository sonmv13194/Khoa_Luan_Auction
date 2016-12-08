package vn.smartdev.controller;

import org.hibernate.annotations.GenerationTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import vn.smartdev.category.dao.entity.Category;
import vn.smartdev.category.manager.CategoryServices;
import vn.smartdev.product.dao.entity.Product;
import vn.smartdev.product.dao.entity.ProductDetail;
import vn.smartdev.product.dao.entity.ProductImage;
import vn.smartdev.product.dao.model.ProductDetailModel;
import vn.smartdev.product.dao.model.ProductModel;
import vn.smartdev.product.manager.ProductDetailServices;
import vn.smartdev.product.manager.ProductImageServices;
import vn.smartdev.product.manager.ProductServices;

import javax.servlet.http.HttpServletRequest;
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
    @RequestMapping(value = "/createProduct",method = RequestMethod.GET)
    public ModelAndView createProduct(ModelMap modelMap)
    {
        List<Category> listCategory = categoryServices.getListCategory();

        modelMap.put("listCategory", listCategory);
        modelMap.put("productId","1");

        return new ModelAndView("createProduct","command",new ProductModel());
    }
    @RequestMapping(value="/createProductPost",method = RequestMethod.POST)
    public String createProductPost(@ModelAttribute("product") ProductModel productModel,HttpSession session)
    {
        //upload file
        boolean checkExistNameImage = productImageServices.checkNameImage(productModel);
        if(checkExistNameImage == true)
        {
            session.setAttribute("message", "Name image is exist in system ,please rename image ...");
            return "redirect:/admin/createProduct";
        }
        else
        {
            String urlImage = session.getServletContext().getRealPath("images");
            boolean upload = productImageServices.uploadFile(productModel, urlImage);
            boolean createProduct = productServices.createProduct(productModel);
            return "redirect:/admin/viewProduct";
        }
    }
    @RequestMapping(value="/createProductDetail",method = RequestMethod.GET)
    public ModelAndView createProductDetail(@ModelAttribute("product") ProductModel productModel,ModelMap modelMap,@RequestParam("productId") String productId)
    {
        List<Category> listCategory = categoryServices.getListCategory();
        Product product = productServices.getProduct(productId);

        modelMap.put("listCategory",listCategory);
        modelMap.put("product",product);

        return new ModelAndView("createProduct","command",new ProductModel());
    }
    @RequestMapping(value="/createProductDetailPost",method = RequestMethod.POST)
    public String createProductDetailPost(@ModelAttribute("product") ProductModel productModel,HttpSession session)
    {
        //upload file
        boolean checkExistNameImage = productImageServices.checkNameImage(productModel);
        if(checkExistNameImage == true)
        {
            session.setAttribute("message", "Name image is exist in system ,please rename image ...");
            return "redirect:/admin/createProduct";
        }
        else
        {
            String urlImage = session.getServletContext().getRealPath("images");
            boolean upload = productImageServices.uploadFile(productModel, urlImage);
            boolean createProductDetail = productDetailServices.createProductDetail(productModel);
            return "redirect:/admin/viewProduct";
        }
    }
    @RequestMapping(value = "/viewProductDetail",method = RequestMethod.GET)
    public String viewProductDetail(@RequestParam("productId") String productId,ModelMap modelMap)
    {
        List<ProductDetail> listProductDetails = productServices.getProduct(productId).getProductDetails();
        modelMap.put("listProductDetails",listProductDetails);
        return "viewProductDetail";
    }
    @RequestMapping(value="/updateProduct",method = RequestMethod.GET)
    public ModelAndView updateProduct(@RequestParam("productDetailId") String productDetailId,ModelMap modelMap)
    {
        ProductDetail productDetail = productDetailServices.getProductDetail(productDetailId);
        modelMap.put("productDetail", productDetail);

        return new ModelAndView("updateProduct","command",new ProductDetailModel());
    }
    @RequestMapping(value="/updateProductPost",method = RequestMethod.POST)
    public String updateProductPost(@ModelAttribute("updateModel") ProductDetailModel productDetailModel)
    {
        boolean updateProductDetail = productDetailServices.updateProductDetail(productDetailModel);
        return "redirect:/admin/viewProduct";
    }

}