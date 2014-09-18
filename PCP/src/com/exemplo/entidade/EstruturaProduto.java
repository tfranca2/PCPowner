package com.exemplo.entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="estruturaProduto")
public class EstruturaProduto {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idCliente")
	private int id;
	@Column
	private Produto produtoPai;
	@Column
	private Produto produtoFilho;
	@Column
	private Volume volumePai;
	@Column
	private Volume volumeFilho;
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
	public Volume getVolumePai() {
		return volumePai;
	}
	public void setVolumePai(Volume volumePai) {
		this.volumePai = volumePai;
	}
	public Volume getVolumeFilho() {
		return volumeFilho;
	}
	public void setVolumeFilho(Volume volumeFilho) {
		this.volumeFilho = volumeFilho;
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
				+ ", produtoFilho=" + produtoFilho + ", volumePai=" + volumePai
				+ ", volumeFilho=" + volumeFilho + ", conversor=" + conversor
				+ ", ativo=" + ativo + "]";
	}
}
