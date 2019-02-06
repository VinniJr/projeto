package com.projeto.projeto.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.projeto.projeto.model.Manutencao;
import com.projeto.projeto.service.ManutencaoService;

@Controller
public class ManutencaoController {
	
	
	@Autowired
	private ManutencaoService service;
	
	@GetMapping("/")
	public ModelAndView findAll() {
		
		ModelAndView mv = new ModelAndView("/post");
		mv.addObject("manutencoes", service.findAll());
		
		return mv;
	}
	
	@GetMapping("/add")
	public ModelAndView add(@Valid Manutencao manutencao) {
		
		ModelAndView mv = new ModelAndView("/manutencaoAdd");
		mv.addObject("manutencao", manutencao);
		
		return mv;
	}
	
	@GetMapping("/edit/{id}")
	public ModelAndView edit(@PathVariable("id") Long id) {
		
		return add(service.findOne(id));
	}
	
	@GetMapping("/delete/{id}")
	public ModelAndView delete(@PathVariable("id") Long id) {
		
		service.delete(id);
		
		return findAll();
	}
	
	@PostMapping("/save")
	public ModelAndView save(@Valid Manutencao manutencao, BindingResult result) {
		
		if(result.hasErrors()) {
			return add(manutencao);
		}
		
		service.save(manutencao);
		
		return findAll();
	}

}
