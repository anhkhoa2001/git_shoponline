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
import fpt.spring.model.Orders;
import fpt.spring.security.AuthenticationSystem;

@Controller
public class ManageController {

	
	@GetMapping(value = "/manage")
	public String manage(HttpServletRequest request, Model model) {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username = null;
		if (principal instanceof UserDetails) {
			username = ((UserDetails)principal).getUsername();
		} else {
			username = principal.toString();
		}

		Account account = null;
		if(username != null) {
			account = Main.dao.findAccountByUsername(username);
			model.addAttribute("account", account);
		} else {
			account = null;
		}
		if(account == null) {
			return "redirect:http://localhost:8080/myspring/login";
		} else {
			System.out.println(account.getRole());
			if(account.getRole().equals("ADMIN")) {
				String nowDay = Main.day.format(Main.localDate);
				List<Orders> list = Main.dao.getAllOrdersByCreated(nowDay);
				int count = 0, totalQuantity = 0, totalPrice = 0;
				for(Orders orders : list) {
					count++;
					totalQuantity += orders.getQuantity();
					totalPrice += orders.getTotal();
				}
				int countNoti = 0;
				List<Orders> list2 = Main.dao.getAllOrders();
				for(Orders o:list2) {
					if(!o.isStatus()) {
						countNoti++;
					}
				}
				model.addAttribute("count", count);
				model.addAttribute("totalQuantity", totalQuantity);
				model.addAttribute("totalPrice", totalPrice);
				model.addAttribute("countNoti", countNoti);
				
				return "manage";
			} else {
				return "redirect:home";
			}
		}
	}
}
