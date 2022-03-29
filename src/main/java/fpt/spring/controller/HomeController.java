 package fpt.spring.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import fpt.spring.main.Main;
import fpt.spring.model.Account;
import fpt.spring.model.Category;
import fpt.spring.model.PhoneTab;
import fpt.spring.security.AuthenticationSystem;
import fpt.spring.service.AccountService;
import fpt.spring.service.CategoryService;
import fpt.spring.service.PhoneTabService;

@Controller
public class HomeController {
	
	@Autowired
	private AccountService accountService;
	
	@Autowired
	private PhoneTabService phoneTabService;
	
	@Autowired
	private CategoryService categoryService;
	
	@GetMapping(value = "/home")
	public String home(HttpServletRequest request, Model model) {
		//islog = true: da dang nhap
		//islog = false: chua dang nhap
		model.addAttribute("isLog", AuthenticationSystem.isLogged());
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username = null;
		String role = auth.getAuthorities().toString();
		if (principal instanceof UserDetails) {
			username = ((UserDetails)principal).getUsername();
		} else {
			username = principal.toString();
		}
		
		if(username != null) {
			Account account = Main.dao.findAccountByUsername(username);
			model.addAttribute("account", account);
		}
		
		String url = "home";
		if(role.contains("ADMIN")) {
			url = "manage";
		}
		
		return url;
	}
	
	@GetMapping(value = "/")
	public String defaultHome() {
		return "index";
	}
	
	@GetMapping(value = "/test")
	public String testHomt(Model model) {
		List<Category> list = categoryService.findAll();
		
		model.addAttribute("entity", list);
		return "test";
	}
}
