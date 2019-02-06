package com.projeto.projeto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.projeto.projeto.model.Manutencao;

@Repository
public interface ManutencaoRepository extends JpaRepository<Manutencao, Long> {

	@Query("SELECT man FROM tab_manutencao man WHERE man.id = :id")
	public Manutencao findOne(@Param("id") Long id);

}
