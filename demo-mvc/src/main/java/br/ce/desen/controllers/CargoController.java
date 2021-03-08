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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.ce.desen.domain.Cargo;
import br.ce.desen.domain.Departamento;
import br.ce.desen.service.CargoService;
import br.ce.desen.service.DepartamentoService;

@Controller
@RequestMapping("/cargos")
public class CargoController {
	
	@Autowired
	private CargoService cargoService;
	
	@Autowired
	private DepartamentoService departamentoService; 

	
	@GetMapping("/cadastrar")
	public String cadastrar(Cargo cargo) {
		return "/cargo/cadastro";
	}
	
	@PostMapping("/salvar")
	public String salvar(@Valid Cargo cargo, BindingResult result, RedirectAttributes attr) {
		
		if(result.hasErrors()) {
			return "/cargo/cadastro";
		}
		
		cargoService.salvar(cargo);
		attr.addFlashAttribute("success", "Cargo inserido com sucesso.");
		return "redirect:/cargos/cadastrar";
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("cargo", cargoService.buscarPorId(id));
		return "/cargo/cadastro";
	}	
	
	@PostMapping("/editar")
	public String editar(@Valid Cargo cargo, BindingResult result, RedirectAttributes attr) {
		
		if(result.hasErrors()) {
			return "/cargo/cadastro";
		}
		
		cargoService.editar(cargo);
		attr.addFlashAttribute("success", "Registro atualizado com sucesso.");
		return "redirect:/cargos/cadastrar"; 		
	}

//	@GetMapping("/excluir/{id}")
//	public String excluir(@PathVariable("id") Long id, RedirectAttributes attr) {
//		if(livroService.cargoTemFuncionario(id)) {			
//			attr.addAttribute("fail", "cargo não removido. Possui funcionário(s) vinculado(s).");
//		}else {
//			livroService.excluir(id);
//			attr.addAttribute("success", "Cargo excluído com sucesso.");			
//		}		
//		return "redirect:/cargos/listar";
//	}	

	
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("cargos", cargoService.buscarTodos());
		return "/cargo/lista";
	}	
	
	@ModelAttribute("departamentos")
	public List<Departamento> listaDeCargos() {
		return departamentoService.buscarTodos();		
	}	
	
	
}
