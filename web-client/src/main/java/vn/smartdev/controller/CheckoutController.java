package vn.smartdev.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import vn.smartdev.category.dao.entity.Category;
import vn.smartdev.category.manager.CategoryServices;
import vn.smartdev.invoice.dao.model.CartModel;
import vn.smartdev.invoice.dao.entity.Invoice;
import vn.smartdev.invoice.dao.model.InvoiceModel;
import vn.smartdev.invoice.services.InvoiceDetailServices;
import vn.smartdev.invoice.services.InvoiceServices;
import vn.smartdev.product.dao.entity.Product;
import vn.smartdev.product.manager.ProductServices;
import vn.smartdev.product.manager.SendEmailServicesImpl;

@Controller
@RequestMapping(value = "/")
public class CheckoutController {
	private static Logger logger = LoggerFactory.getLogger(CheckoutController.class);
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@Autowired
	private CategoryServices categoryServices;
	@Autowired
	InvoiceServices invoiceServices;
	@Autowired
	SendEmailServicesImpl sendEmailServicesImpl;
	@Autowired
	private ProductServices productServices;

	@Autowired
	InvoiceDetailServices invoiceDetailServices;
	@RequestMapping(value = "/checkout", method = RequestMethod.GET)
	public String checkout(ModelMap modelMap, HttpSession session) {
		List<CartModel> cartModels = (List<CartModel>) session.getAttribute("cartSession");
		if(cartModels.isEmpty()){
			return "cartPage";
		}else {
			modelMap.addAttribute("invoiceModel", new InvoiceModel());
			return "checkoutPage";
		}
	}
	@ModelAttribute
	public void listAllCategory(ModelMap modelMap){
		List<Category> listCategory = categoryServices.getListCategory();
		List<Product> listProduct = productServices.getListProduct();
		modelMap.addAttribute("listCategory", listCategory);
		modelMap.addAttribute("listProduct",listProduct);
	}
	@RequestMapping(value = "/confirmCheckout", method = RequestMethod.POST)
	public String checkoutAdd(@Valid InvoiceModel invoiceModel,
			BindingResult bindingResult,
			HttpSession session, HttpServletRequest request) throws Exception {
		@SuppressWarnings("unchecked")
		List<CartModel> carts = (List<CartModel>)session.getAttribute("cartSession");
		String username = request.getUserPrincipal().getName();
		if (bindingResult.hasErrors()) {
			// handle error
			logger.error("===Got error");
			return "checkoutPage";
		} else {
			logger.info("=== No error");
			// insert into database
			try {
				invoiceModel.setUsername(username);
				invoiceServices.save(invoiceModel,carts);
				sendEmailServicesImpl.sendEmail(invoiceModel.getEmail());
				session.removeAttribute("cartSession");
				session.removeAttribute("countItem");
				session.removeAttribute("total");
			} catch (NullPointerException e) {
				// TODO: handle exception
				return "cartPage";
			}
		}
		return "redirect:/";
	}
}