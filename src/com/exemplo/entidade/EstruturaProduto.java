package com.exemplo.entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="estruturaProduto")
public class EstruturaProduto {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idEstruturaProduto")
	private int id;
	@ManyToOne
	private Produto produtoPai;
	@ManyToOne
	private Produto produtoFilho;
	@Column
	private float conversor;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Produto getProdutoPai() {
		return produtoPai;
	}
	public void setProdutoPai(Produto produtoPai) {
		this.produtoPai = produtoPai;
	}

	
	public float getConversor() {
		return conversor;
	}
	public void setConversor(float conversor) {
		this.conversor = conversor;
	}

	public Produto getProdutoFilho() {
		return produtoFilho;
	}
	public void setProdutoFilho(Produto produtoFilho) {
		this.produtoFilho = produtoFilho;
	}
	

}
