package vn.smartdev.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Template {
	@RequestMapping(value="/sign-up")
	public String signUp(){
		return "registration";
	}
	@RequestMapping(value="/sign-in")
	public String signIn(){
		return "sign-in";
	}
	@RequestMapping(value="/contact")
	public String conTact(){
		return "contact";
	}
	@RequestMapping(value="/checkout")
	public String checkOut(){
		return "checkout";
	}
	@RequestMapping(value="/home")
	public String home(){
		return "home";
	}
	@RequestMapping(value="/shopping-cart")
	public String cart(){
		return "shopping-cart";
	}
}
