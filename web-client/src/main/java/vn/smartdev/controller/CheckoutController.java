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

import vn.smartdev.invoice.dao.model.CartModel;
import vn.smartdev.invoice.dao.entity.Invoice;
import vn.smartdev.invoice.dao.entity.InvoiceDetail;
import vn.smartdev.invoice.dao.model.InvoiceModel;
import vn.smartdev.invoice.manager.InvoiceDetailService;
import vn.smartdev.invoice.manager.InvoiceService;

@Controller
@RequestMapping(value = "/")
public class CheckoutController {
	private static Logger logger = LoggerFactory.getLogger(CheckoutController.class);
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@Autowired
	InvoiceService invoiceService;
	@Autowired
	InvoiceDetailService invoiceDetailService;
	@RequestMapping(value = "/checkout", method = RequestMethod.GET)
	public String checkout(ModelMap modelMap) {
		modelMap.addAttribute("invoiceModel", new InvoiceModel());
		modelMap.addAttribute("invoice",new Invoice());
		return "checkoutPage";
	}
	@RequestMapping(value = "/confirmCheckout", method = RequestMethod.POST)
	public String checkoutAdd(@ModelAttribute InvoiceModel invoiceModel,
			BindingResult bindingResult,
			ModelMap modelMap, HttpSession session, HttpServletResponse response, HttpServletRequest request) throws Exception {
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
		}
		try {
			invoiceModel.setUsername(username);
//			Invoice invoiceAdd = new Invoice(Calendar.getInstance().getTime(),
//					email, phone, "1", username, firstName, lastName, address, city, null);
			invoiceService.save(invoiceModel,carts);
			session.removeAttribute("cartSession");
			session.removeAttribute("countItem");
			session.removeAttribute("total");
		} catch (NullPointerException e) {
			// TODO: handle exception
			return "cartPage";
		}
		return "redirect:/";
	}
}