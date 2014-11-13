package com.exemplo.entidade;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;

@Entity
@Table(name="estruturaProduto")
public class EstruturaProduto {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idEstruturaProduto")
	private int id;
	@ManyToMany(cascade =  CascadeType.ALL)
	private Produto produtoPai;
	@ManyToMany(cascade =  CascadeType.ALL)
	private Produto produtoFilho;
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
	public Produto getProdutoFilho() {
		return produtoFilho;
	}
	public void setProdutoFilho(Produto produtoFilho) {
		this.produtoFilho = produtoFilho;
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
				+ ", produtoFilho=" + produtoFilho 
				+ ", conversor=" + conversor
				+ ", ativo=" + ativo + "]";
	}
}
