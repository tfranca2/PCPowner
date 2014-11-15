package com.exemplo.entidade;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="lote")
public class Lote {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idLote")
	private int id;
	@Column(name="lote")
	private String descricao;
	@Column
	private boolean ativo;
	@Column(name="fabricacao", nullable=false)
	@Temporal(TemporalType.DATE)
	private Date fabricacao;
	@Column(name="validade", nullable=false)
	@Temporal(TemporalType.DATE)
	private Date validade;
	@OneToOne
	private Produto produto;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public boolean isAtivo() {
		return ativo;
	}
	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
	public Date getFabricacao() {
		return fabricacao;
	}
	public void setFabricacao(Date fabricacao) {
		this.fabricacao = fabricacao;
	}
	public Date getValidade() {
		return validade;
	}
	public void setValidade(Date validade) {
		this.validade = validade;
	}
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
	@Override
	public String toString() {
		return "Lote [id=" + id + ", descricao=" + descricao + ", ativo="
				+ ativo + ", fabricacao=" + fabricacao + ", validade="
				+ validade + ", produto=" + produto + "]";
	}
}
