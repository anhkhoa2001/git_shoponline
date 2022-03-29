package fpt.spring.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import fpt.spring.main.Main;
import fpt.spring.model.Account;
import fpt.spring.model.Laptop;
import fpt.spring.model.PhoneTab;
import fpt.spring.model.Product;
import fpt.spring.security.AuthenticationSystem;

@Controller
public class ProductDetailController {
	
	@GetMapping(value = "/home/product/details")
	public String product(HttpServletRequest request, Model model) {
		model.addAttribute("isLog", AuthenticationSystem.isLogged());
		
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username = null;
		if (principal instanceof UserDetails) {
			username = ((UserDetails)principal).getUsername();
		} else {
			username = principal.toString();
		}

		String code = request.getParameter("code") == null ? "error" : request.getParameter("code");
		List<Product> list = Main.dao.getAllProduct();
		System.out.println(code);
		for(Product product : list) {
			if(product.getCode().equals(code)) {
				if(product.getCategory().getCatemenu().getId() == Main.CMID_PHONE || 
						product.getCategory().getCatemenu().getId() == Main.CMID_TABLET) {
					PhoneTab phoneTab = (PhoneTab) product;
					model.addAttribute("product", phoneTab);
				} else {
					Laptop laptop = (Laptop) product;
					model.addAttribute("product", laptop);
				}
			}
		}
		if(username != null) {
			Account account = Main.dao.findAccountByUsername(username);
			model.addAttribute("account", account);
		}
		
		return "productdetail";
	}

}
