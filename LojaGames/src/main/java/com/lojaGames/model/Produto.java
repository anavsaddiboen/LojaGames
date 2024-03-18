package com.lojaGames.model;

import org.springframework.format.annotation.NumberFormat;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tb_produtos")
public class ModelProduto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "Comando inválido! O nome do produto não pode estar vazio!")
	@Size(min = 5, message = "Comando inválido! O nome precisa ter mais do que 5 caracteres!")
	@Size(max = 45, message = "Comando inválido! O nome precisa ter menos do que 45 caracteres!")
	private String nomeProduto;

	@NotBlank(message = "Comando inválido! A descrição do produto não pode estar vazia!")
	@Size(min = 10, message = "Comando inválido! A descrição do produto precisa ter mais do que 10 caracteres!")
	@Size(max = 255, message = "Comando inválido! A descrição é muito grande! Precisa ter menos de 255 caracteres!")
	private String descricaoProduto;

	@NotNull(message = "Comando inválido! O valor do produto não pode estar vazio!")
	@Positive(message = "Comando inválido! O valor do produto deve ser um número positivo!")
	@NumberFormat(pattern = "#,###.##")
	@Column(columnDefinition = "decimal(6,2)")
	private Float precoProduto;

	@NotNull(message = "Comando inválido! A quantidade de estoque não pode estar vazia!")
	@Positive(message = "Comando inválido! A quantidade em estoque deve ser um número positivo!")
	private Integer quantidadeProduto;
	
	@ManyToOne
	@JsonIgnoreProperties("modelProduto")
	private ModelCategoria modelCategoria;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public String getDescricaoProduto() {
		return descricaoProduto;
	}

	public void setDescricaoProduto(String descricaoProduto) {
		this.descricaoProduto = descricaoProduto;
	}

	public Float getPrecoProduto() {
		return precoProduto;
	}

	public void setPrecoProduto(Float precoProduto) {
		this.precoProduto = precoProduto;
	}

	public Integer getQuantidadeProduto() {
		return quantidadeProduto;
	}

	public void setQuantidadeProduto(Integer quantidadeProduto) {
		this.quantidadeProduto = quantidadeProduto;
	}

	public ModelCategoria getModelCategoria() {
		return modelCategoria;
	}

	public void setModelCategoria(ModelCategoria modelCategoria) {
		this.modelCategoria = modelCategoria;
	}

}