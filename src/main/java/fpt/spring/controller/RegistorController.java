package fpt.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RegistorController {
	
	@GetMapping(value = "/registor")
	public String registor() {
		return "create";
	}
	
	
}
