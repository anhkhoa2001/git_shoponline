package fpt.spring.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import fpt.spring.main.Main;
import fpt.spring.model.Account;
import fpt.spring.model.Category;
import fpt.spring.model.OrderProduct;
import fpt.spring.model.Orders;
import fpt.spring.model.Product;
import fpt.spring.security.AuthenticationSystem;

@Controller
public class CheckOutController {

	@GetMapping(value = "/home/checkout")
	public String checkout(HttpServletRequest request, Model model) {
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
		if(code != null) {
			Product product = Main.dao.findProductByCode(code);
			model.addAttribute("product", product);
		} 
		
		return "checkout";
	}
	
	@RequestMapping(value = "/home/checkout", method = RequestMethod.POST)
	@ResponseBody
	public String checkoutSubmit(HttpServletRequest request, Model model, @RequestBody String data) {
		JSONParser parser = new JSONParser(); 
		int sizeOrders = Main.dao.getAllOrders().size();
		int sizeOrderProduct = Main.dao.getAllOrderProducts().size();
		try {
			List<OrderProduct> listOrderProducts = new ArrayList<>();
			JSONObject json = (JSONObject) parser.parse(data);
			JSONObject one = (JSONObject) json.get("step_one");
			JSONArray two = (JSONArray) json.get("step_two");
			JSONObject three = (JSONObject) json.get("step_three");
			
			String firstname = one.get("firstname").toString();
			String email = one.get("email").toString();
			String lastname = one.get("lastname").toString();
			String phone = one.get("phone").toString();
			String residence = one.get("residence").toString();
			String district = one.get("district").toString();
			String city = one.get("city").toString();
			
			Orders orders = new Orders(firstname + " " + lastname, email, phone, residence + " " + district + " " + city, 
								0, Main.day.format(Main.localDate), 0);
			
			int totalQuantity = ((Long) three.get("quantity")).intValue();
			int totalPrice = ((Long) three.get("total")).intValue();
			orders.setQuantity(totalQuantity);
			orders.setTotal(totalPrice);
			orders.setStatus(false);
			Main.dao.addOrder(orders);
			for(int i=0; i<two.size(); i++) {
				JSONObject jsonObject = (JSONObject) two.get(i);
				String code = jsonObject.get("code").toString();
				int quantity = ((Long) jsonObject.get("quantity")).intValue();
				int total = ((Long) jsonObject.get("totalPrice")).intValue();
				int cid = Integer.parseInt(jsonObject.get("cid").toString());
				OrderProduct orderProduct = new OrderProduct(code, quantity, total);
				Category category = Main.dao.findCategory(cid);
				listOrderProducts.add(orderProduct);
				orderProduct.setOrders(orders);
				orderProduct.setCategory(category);
				Main.dao.addOrderProduct(orderProduct);
			}
			
			if(sizeOrders + 1 == Main.dao.getAllOrders().size() && 
					sizeOrderProduct + two.size() == Main.dao.getAllOrderProducts().size()) {
				return "1";
			} else {
				return "0";
			}
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return null;
	}
}
