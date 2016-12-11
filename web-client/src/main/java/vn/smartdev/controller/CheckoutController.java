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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import vn.smartdev.invoice.dao.entity.CartModel;
import vn.smartdev.invoice.dao.entity.Invoice;
import vn.smartdev.invoice.dao.entity.InvoiceDetail;
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
		modelMap.addAttribute("invoiceEntity",new Invoice());
		return "checkoutPage";
	}
	@RequestMapping(value = "/comfirmCheckout", method = RequestMethod.POST)
	public String checkoutAdd(@Valid Invoice invoice,
			BindingResult bindingResult,
			ModelMap modelMap, HttpSession session, HttpServletResponse response, HttpServletRequest request) throws Exception {
		@SuppressWarnings("unchecked")
		List<CartModel> carts = (List<CartModel>)session.getAttribute("cartSession");
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		String city = request.getParameter("city");
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
//			Invoice invoiceAdd = new Invoice(Calendar.getInstance().getTime(),
//					email, phone, "1", username, firstName, lastName, address, city, null);
			Invoice invoiceAdd = new Invoice();
			invoiceService.save(invoiceAdd);
			for(CartModel cart : carts){
				InvoiceDetail invoiceDetail = new InvoiceDetail();
				invoiceDetailService.save(invoiceDetail);
			}
			session.removeAttribute("cartSession");
		} catch (NullPointerException e) {
			// TODO: handle exception
			return "cartPage";
		}
		
		return "homePage";
	}
}