package br.ce.desen.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.ce.desen.domain.Cargo;
import br.ce.desen.domain.Funcionario;
import br.ce.desen.domain.Uf;
import br.ce.desen.service.CargoService;
import br.ce.desen.service.FuncionarioService;

@Controller
@RequestMapping("/funcionarios")
public class FuncionarioController {
	
	@Autowired
	private FuncionarioService funcionarioService;
	
	@Autowired
	private CargoService cargoService;

	@GetMapping("/cadastrar")
	public String cadastrar(Funcionario funcionario) {
		return "/funcionario/cadastro";
	}
	
	@PostMapping("/salvar")
	public String salvar(@Valid Funcionario funcionario, BindingResult result, RedirectAttributes attr) {
		
		if(result.hasErrors()) {			
			return "/funcionario/cadastro";
		}
		
		funcionarioService.salvar(funcionario);		
		attr.addFlashAttribute("success", "Funcionário inserido com sucesso.");
		return "redirect:/funcionarios/cadastrar";
		
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("funcionario", funcionarioService.buscarPorId(id));
		return "/funcionario/cadastro";		
	}
	
	@PostMapping("/editar")
	public String editar(@Valid Funcionario funcionario, BindingResult result, RedirectAttributes attr) {
		
		if(result.hasErrors()) {
			return "/funcionario/cadastro";
		}
		
		funcionarioService.editar(funcionario);
		attr.addFlashAttribute("success", "Funcionarios atualizado com sucesso.");
		return "redirect:/funcionarios/cadastrar";
	}	

	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, RedirectAttributes attr) {
		funcionarioService.excluir(id);
		attr.addFlashAttribute("success", "Funcionarios excluído com sucesso.");
		return "redirect:/funcionarios/listar";
	}
	
	@ModelAttribute("cargos")
	public List<Cargo> getCargos() {
		return cargoService.buscarTodos();
	}	
	
	@ModelAttribute("ufs")
	public Uf[] getUfs() {
		return Uf.values();
	}

	@GetMapping("/buscar/nome")
	public String getPorNome(@RequestParam("nome") String nome, ModelMap model) {
		model.addAttribute("funcionarios", funcionarioService.buscarPorNome(nome));
		return "/funcionario/lista";		
	}	
	
	@GetMapping("/buscar/cargo")
	public String buscarPorCargo(@RequestParam("id") Long id, ModelMap model) {
		model.addAttribute("funcionarios", funcionarioService.buscarPorCargo(id));
		return "/funcionario/lista";	
	}
	
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("funcionarios", funcionarioService.buscarTodos());
		return "/funcionario/lista";
	}	
	
}