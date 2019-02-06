package com.projeto.projeto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto.projeto.model.Manutencao;
import com.projeto.projeto.repository.ManutencaoRepository;



@Service
public class ManutencaoService {
	
	@Autowired
	private ManutencaoRepository repository;
	
	public List<Manutencao> findAll() {
		return repository.findAll();
	}
	
	public Manutencao findOne(Long id) {
		return repository.findOne(id);
	}
	public Manutencao save(Manutencao manutencao) {
		return repository.saveAndFlush(manutencao);
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
	

}
