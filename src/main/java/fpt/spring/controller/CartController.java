package fpt.spring.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import fpt.spring.main.Main;
import fpt.spring.model.Account;
import fpt.spring.security.AuthenticationSystem;

@Controller
public class CartController {

	@GetMapping(value = "/home/cart")
	public String cart(HttpServletRequest request, Model model) {
		//islog = true: da dang nhap
		//islog = false: chua dang nhap
		model.addAttribute("isLog", AuthenticationSystem.isLogged());
		
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username = null;
		if (principal instanceof UserDetails) {
			username = ((UserDetails)principal).getUsername();
		} else {
			username = principal.toString();
		}

		if(username != null) {
			Account account = Main.dao.findAccountByUsername(username);
			model.addAttribute("account", account);
		}
		
		return "cart";
	}
}
