package com.projeto.projeto.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotBlank;

@Entity(name = "tab_manutencao")
public class Manutencao implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2591338501861326335L;

	@Id
	@SequenceGenerator(name = "cod_manutencao", sequenceName = "cod_manutencao")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cod_manutencao")
	private Long id;
	
	@Column(nullable = false, length = 50)
	@NotBlank(message = "Descrição é uma informação obrigatória.")
	private String descricao;

}
