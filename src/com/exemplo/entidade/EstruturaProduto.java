package com.exemplo.entidade;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="estruturaProduto")
public class EstruturaProduto {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="idEstruturaProduto")
	private int id;
	@OneToOne
	private Produto produtoPai;
	@OneToMany
	private List<Produto> produtosFilho;
	@Column
	private float conversor;
	@Column
	private boolean ativo;
	
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
	public boolean isAtivo() {
		return ativo;
	}
	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
	
	@Override
	public String toString() {
		return "EstruturaProduto [id=" + id + ", produtoPai=" + produtoPai
				+ ", conversor=" + conversor
				+ ", ativo=" + ativo + "]";
	}
	public List<Produto> getProdutosFilho() {
		return produtosFilho;
	}
	public void setProdutosFilho(List<Produto> produtosFilho) {
		this.produtosFilho = produtosFilho;
	}
}
