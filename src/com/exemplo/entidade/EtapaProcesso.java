package com.exemplo.entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="etapa")
public class EtapaProcesso {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idEtapa")
	private int id;
	@Column
	private String etapa;
	@Column
	private float duracao;
	@OneToOne
	private Produto produto;
	@Column
	private boolean ativo;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEtapa() {
		return etapa;
	}
	public void setEtapa(String etapa) {
		this.etapa = etapa;
	}
	public float getDuracao() {
		return duracao;
	}
	public void setDuracao(float duracao) {
		this.duracao = duracao;
	}
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	public boolean isAtivo() {
		return ativo;
	}
	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
	
	@Override
	public String toString() {
		return "EtapaDeProcesso [id=" + id + ", etapa=" + etapa + ", duracao="
				+ duracao + ", produto=" + produto + ", ativo=" + ativo + "]";
	}
	
}
