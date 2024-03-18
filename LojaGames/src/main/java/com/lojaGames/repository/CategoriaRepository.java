package com.lojaGames.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.lojaGames.model.ModelCategoria;

public interface CategoriaRepository extends JpaRepository<ModelCategoria, Long>{
	
	public List<ModelCategoria> findAllByDescricaoCategoriaContainingIgnoreCase(@Param("descricaoCategoria") String descricaoCategoria);

}