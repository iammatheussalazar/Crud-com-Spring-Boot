package com.crud.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.crud.model.Cliente;
import com.crud.model.GeneroCliente;
import com.crud.repository.ClienteRepository;

@Controller
@RequestMapping("/clientes")
public class ClienteController {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@RequestMapping("/novo")
	public ModelAndView novo() {
		ModelAndView mv = new ModelAndView("CadastroCliente");
		mv.addObject("generoCliente", GeneroCliente.values());
		mv.addObject(new Cliente());
		return mv;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView salvar(@Valid Cliente cliente, BindingResult result, RedirectAttributes attributes) {
		ModelAndView mv = new ModelAndView("CadastroCliente");
		mv.addObject("generoCliente", GeneroCliente.values());
		if(result.hasErrors()) {
			return mv;
		}
		
		clienteRepository.save(cliente);
		
		ModelAndView mv2 = new ModelAndView("redirect:/clientes/novo");
		attributes.addFlashAttribute("mensagem", "Cliente salvo com sucesso!");
		return mv2;
	}
	
	@RequestMapping
	public ModelAndView listar() {
		List<Cliente> listaClientes = clienteRepository.findAll();
		ModelAndView mv = new ModelAndView("PesquisaCliente");
		mv.addObject("clientes", listaClientes);
		return mv;
	}
	
	@RequestMapping("/editar/{id}")
	public ModelAndView editar(@PathVariable("id") Long id) {
		Cliente cliente = clienteRepository.getById(id);
		
		ModelAndView mv = new ModelAndView("CadastroCliente");
		mv.addObject(cliente);
		return mv;
	}
	
	@RequestMapping(value = "/excluir/{id}")
	public String excluir(@PathVariable("id") Long id) {
		clienteRepository.deleteById(id);
		
		return "redirect:/clientes";
	}
	
}
