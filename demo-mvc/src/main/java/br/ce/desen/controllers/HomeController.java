package br.ce.desen.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	@GetMapping({"/", "/home"})
	public String home() {
		return "home";
	}
	
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@GetMapping("/login-error")
	public String loginError(ModelMap model) {
		model.addAttribute("alert", "erro");
		model.addAttribute("titulo", "Credeciais inválidas"); 
		model.addAttribute("texto", "Login ou senha incorretos, tente novamente!");
		model.addAttribute("subtexto", "Acesso permitido apenas para cadastros já ativados.");
		
		return "login";
	}
	

}
