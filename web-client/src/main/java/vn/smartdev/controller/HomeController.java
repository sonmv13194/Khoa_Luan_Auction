package vn.smartdev.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import vn.smartdev.category.dao.entity.Category;
import vn.smartdev.category.services.CategoryServices;
import vn.smartdev.product.dao.entity.Discount;
import vn.smartdev.product.dao.entity.Product;
import vn.smartdev.product.dao.entity.ProductDetail;
import vn.smartdev.product.services.DiscountServices;
import vn.smartdev.product.services.ProductDetailServices;
import vn.smartdev.product.services.ProductServices;
import vn.smartdev.user.dao.manager.UserManager;

import javax.servlet.http.HttpSession;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * Handles requests for the application home page.
 */


@Controller
@RequestMapping(value = "/")
public class HomeController {

	@Autowired
	UserManager userManager;
	@Autowired
	private ProductServices productServices;
	@Autowired
	private ProductDetailServices productDetailServices;
	@Autowired
	private CategoryServices categoryServices;
	@Autowired
	private DiscountServices discountServices;


	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model, HttpSession session) {
		logger.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate );
		List<ProductDetail> listProductDetailNew = productDetailServices.findTop6ByOrderByCreateByDesc();

		List<ProductDetail> listProductDetailExpensivePrice = productDetailServices.findTop6ByOrderByProductDetailPriceDesc();

		List<ProductDetail> listProductDetailCheap = productDetailServices.findTop3ByOrderByProductDetailPriceAsc();

		List<ProductDetail> list8ProductDetail = productDetailServices.findTop8ByOrderByCreateByAsc();

		model.addAttribute("listProductDetailNew",listProductDetailNew);
		model.addAttribute("listProductDetailExpensivePrice",listProductDetailExpensivePrice);
		model.addAttribute("listProductDetailCheap",listProductDetailCheap);
		model.addAttribute("list8ProductDetail",list8ProductDetail);
		if(session.getAttribute("cartSession") == null){
			session.setAttribute("countItem", 0);
			session.setAttribute("total", 0);
		}

		return "homePage";
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

	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String admin(Locale locale, Model model) {
		logger.info("Welcome login! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);

		return "redirect:/admin/viewUser";
	}

	//view detail product
	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	public String viewDetail(Locale locale, Model model,@RequestParam("productDetailId") String id) {
		logger.info("Welcome login! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		List<ProductDetail> listProductDetailCheap = productDetailServices.findTop3ByOrderByProductDetailPriceAsc();
		ProductDetail productDetail = productDetailServices.getProductDetail(id);
		Product product = productServices.getProduct(productDetail.getProduct().getId());
		List<ProductDetail> listProductDetailExpensivePrice = productDetailServices.findTop6ByOrderByProductDetailPriceDesc();
		Discount discount = discountServices.findByProduct(product);
		if(discount == null){
			model.addAttribute("discount",0);
		}else {
			model.addAttribute("discount",discount.getDiscount());
		}
		model.addAttribute("serverTime", formattedDate);
		model.addAttribute("productDetail",productDetail);
		model.addAttribute("listProductDetailCheap",listProductDetailCheap);
		model.addAttribute("listProductDetailExpensivePrice",listProductDetailExpensivePrice);
		return "detailPage";
	}

	@RequestMapping(value = "/shopping", method = RequestMethod.GET)
	public String viewCart(Locale locale, ModelMap modelMap) {
		logger.info("Welcome login! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		modelMap.addAttribute("serverTime", formattedDate);

		return "shoppingCart";
	}
	@RequestMapping(value="/product",method = RequestMethod.GET)
	public String viewProduct(@RequestParam("check") String check,ModelMap modelMap)
	{
		List<ProductDetail> listProductDetail = productDetailServices.getListProductDetail();
		if(check.equals("all"))
		{
			modelMap.put("listProductDetail",listProductDetail);
		}
		else if(check.equals("productPriceAsc"))
		{
			List<ProductDetail> listProductDetailNew = productDetailServices.findByOrderByProductDetailPriceAsc();
			modelMap.put("listProductDetail",listProductDetailNew);
		}
		else if(check.equals("productPriceDesc"))
		{
			List<ProductDetail> listProductDetailNew = productDetailServices.findByOrderByProductDetailPriceDesc();
			modelMap.put("listProductDetail",listProductDetailNew);
		}
		else
		{
			List<ProductDetail> listProductDetailNew = productDetailServices.getListProductDetailByProduct(check);
			modelMap.put("listProductDetail",listProductDetailNew);
		}
		return "productPage";
	}
}
