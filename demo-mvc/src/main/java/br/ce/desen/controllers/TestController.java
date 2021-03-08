package br.ce.desen.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {

	@GetMapping("/teste")
	public String listar() {
		return "ok";
	}
}
