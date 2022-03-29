package fpt.spring.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import fpt.spring.main.Main;
import fpt.spring.model.Account;
import fpt.spring.security.AuthenticationSystem;

@Controller
public class addToCartController {
	
	@RequestMapping(value = "/product/details/addtocart", method = RequestMethod.GET)
	@ResponseBody
	public String home(HttpServletRequest request, Model model) {
		boolean isLog = AuthenticationSystem.isLogged();
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
		String code = request.getParameter("code");
		
		
		return isLog ? "1" : "0";
	}
}
