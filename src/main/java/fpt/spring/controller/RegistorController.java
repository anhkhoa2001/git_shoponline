package fpt.spring.controller;

import javax.servlet.http.HttpServletRequest;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import fpt.spring.main.Main;
import fpt.spring.model.Account;
import fpt.spring.service.AccountService;

@Controller
public class RegistorController {
	
	@Autowired
	private AccountService accountService;
	
	@GetMapping(value = "/registor")
	public String registor() {
		return "create";
	}
	
	@RequestMapping(value = "/registor", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
	@ResponseBody
	public String registor(HttpServletRequest request, @RequestBody String data, Model model) {
		JSONParser parser = new JSONParser();  
		try {
			JSONObject jsonObject = (JSONObject) parser.parse(data);
			String name = jsonObject.get("name").toString();
			String phone = jsonObject.get("phone").toString();
			String email = jsonObject.get("email").toString();
			String username = jsonObject.get("username").toString();
			String pass = jsonObject.get("pass").toString();
			String address = jsonObject.get("address").toString();
			String role = "CUSTOMER";
			String date = Main.day.format(Main.localDate);
			
			Account account = new Account(username, address, role, date, email, name, pass, phone);
			accountService.save(account);
			return "1";
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return null;
	}
}
