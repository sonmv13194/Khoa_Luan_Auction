package vn.smartdev.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import vn.smartdev.category.dao.entity.Category;
import vn.smartdev.category.services.CategoryServices;
import vn.smartdev.product.dao.entity.Product;
import vn.smartdev.product.dao.entity.ProductDetail;
import vn.smartdev.product.dao.model.ProductDetailModel;
import vn.smartdev.product.dao.model.ProductModel;
import vn.smartdev.product.services.ProductDetailServices;
import vn.smartdev.product.services.ProductImageServices;
import vn.smartdev.product.services.ProductServices;

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


    @RequestMapping(value = "/viewProduct", method = RequestMethod.GET)
    public String viewProduct(ModelMap modelMap, HttpSession session) {
        List<ProductDetail> listProductDetails = productDetailServices.getListProductDetail();
        String message = (String) session.getAttribute("message");
        modelMap.put("message", message);
        modelMap.put("listProductDetails", listProductDetails);
        return "viewProduct";
    }

    @ModelAttribute("categories")
    public List<Category> listAllCategory() {
        List<Category> categories = categoryServices.getListCategory();
        return categories;
    }
    @ModelAttribute("products")
    public List<Product> listAllProduct() {
        List<Product> products = productServices.getListProduct();
        return products;
    }

    @RequestMapping(value = "/deleteProduct", method = RequestMethod.GET)
    public String deleteProduct(@RequestParam("productId") String productId, ModelMap modelMap) {
        //delete Product
        productServices.deleteProduct(productId);
        modelMap.put("message", "Delete complete Product Name : " + productId);
        return "redirect:viewProduct";
    }

    @RequestMapping(value = "/deleteProductDetail", method = RequestMethod.GET)
    public String deleteProductDetail(@RequestParam("productId") String productId, @RequestParam("productDetailId") String productDetailId) {
        productDetailServices.deleteProductDetail(productDetailId);
        //return "redirect:viewProductDetail?productId='"+productId+"'";
        return "redirect:viewProduct";
    }

    @RequestMapping(value = "/createProduct", method = RequestMethod.GET)
    public ModelAndView createProduct() {
        return new ModelAndView("createProduct", "command", new ProductModel());
    }

    @RequestMapping(value = "/createProductPost", method = RequestMethod.POST)
    public String createProductPost(@ModelAttribute("product") ProductModel productModel, HttpSession session) {
        //upload file
        productServices.createProduct(productModel);
        productImageServices.uploadFile(productModel);
        return "redirect:viewProduct";
    }

    @RequestMapping(value = "/createProductDetail", method = RequestMethod.GET)
    public ModelAndView createProductDetail(ModelMap modelMap, @RequestParam("productId") String productId) {
        Product product = productServices.getProduct(productId);
        modelMap.put("product", product);
        return new ModelAndView("createProduct", "command", new ProductModel());
    }

    @RequestMapping(value = "/createProductDetailPost", method = RequestMethod.POST)
    public String createProductDetailPost(@ModelAttribute("product") ProductModel productModel, HttpSession session) {
        //upload file
        productImageServices.uploadFile(productModel);
        productDetailServices.createProductDetail(productModel);
        return "redirect:viewProduct";
    }

    @RequestMapping(value = "/viewProductDetail", method = RequestMethod.GET)
    public String viewProductDetail(@RequestParam("productId") String productId, ModelMap modelMap) {
        List<ProductDetail> listProductDetails = productServices.getProduct(productId).getProductDetails();
        modelMap.put("listProductDetails", listProductDetails);
        return "viewProductDetail";
    }

    @RequestMapping(value = "/updateProduct", method = RequestMethod.GET)
    public ModelAndView updateProduct(@RequestParam("productDetailId") String productDetailId, ModelMap modelMap) {
        ProductDetail productDetail = productDetailServices.getProductDetail(productDetailId);
        modelMap.put("productDetail", productDetail);
        return new ModelAndView("updateProduct", "command", new ProductDetailModel());
    }

    @RequestMapping(value = "/updateProductPost", method = RequestMethod.POST)
    public String updateProductPost(@ModelAttribute("updateModel") ProductDetailModel productDetailModel) {
        productDetailServices.updateProductDetail(productDetailModel);
        return "redirect:viewProduct";
    }

    @RequestMapping(value = "/viewProductImages", method = RequestMethod.GET)
    public String viewProductImages(@RequestParam("productDetailId") String productDetailId, ModelMap modelMap) {
        ProductDetail productDetail = productDetailServices.getProductDetail(productDetailId);
        modelMap.put("productDetail", productDetail);
        return "viewProductImages";
    }

}