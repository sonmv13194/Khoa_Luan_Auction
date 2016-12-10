package vn.smartdev.controller.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import vn.smartdev.product.dao.entity.Product;
import vn.smartdev.product.dao.entity.ProductDetail;
import vn.smartdev.product.manager.ProductDetailServices;
import vn.smartdev.product.manager.ProductServices;
import vn.smartdev.user.dao.entity.User;
import vn.smartdev.user.exception.UserAlreadyExistsException;
import vn.smartdev.user.manager.UserManager;

import javax.management.relation.RoleNotFoundException;
import java.text.DateFormat;
import java.text.ParseException;
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
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate );
		List<ProductDetail> listProductDetailNew = productDetailServices.findTop6ByOrderByCreateByDesc();

		List<ProductDetail> listProductDetailExpenSivePrice = productDetailServices.findTop6ByOrderByProductDetailPriceDesc();

		List<ProductDetail> listProductDetailCheap = productDetailServices.findTop3ByOrderByProductDetailPriceAsc();

		List<ProductDetail> list8ProductDetail = productDetailServices.findTop8ByOrderByCreateByAsc();

		model.addAttribute("listProductDetailNew",listProductDetailNew);
		model.addAttribute("listProductDetailExpenSivePrice",listProductDetailExpenSivePrice);
		model.addAttribute("listProductDetailCheap",listProductDetailCheap);
		model.addAttribute("list8ProductDetail",list8ProductDetail);

		return "homePage";
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
	public String viewDetail(Locale locale, Model model,@RequestParam("productId") String productId) {
		logger.info("Welcome login! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		Product product = productServices.getProduct(productId);
		model.addAttribute("serverTime", formattedDate);
		model.addAttribute("product",product);


		return "detailPage";
	}

	@RequestMapping(value = "/shopping", method = RequestMethod.GET)
	public String viewCart(Locale locale, Model model) {
		logger.info("Welcome login! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);

		return "shoppingCart";
	}
}
