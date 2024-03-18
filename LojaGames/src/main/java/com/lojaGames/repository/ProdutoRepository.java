package com.lojaGames.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.lojaGames.model.ModelProduto;

public interface ProdutoRepository extends JpaRepository<ModelProduto, Long> {
	
	public List<ModelProduto> findAllByDescricaoProdutoContainingIgnoreCase(@Param("descricaoProduto") String descricaoProduto);

}