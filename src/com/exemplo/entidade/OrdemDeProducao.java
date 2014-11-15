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
@Table(name="ordemdeproducao")
public class OrdemDeProducao {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idOrdemDeProducao")
	private int id;
	@OneToOne
	private EtapaDeProducao etapa;
	@Column(name="data", nullable=false)
	@Temporal(TemporalType.DATE)
	private Date data;
	@OneToOne
	private Produto produto;
	@Column
	private int quantidade;
	@Column
	private boolean ativo;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public EtapaDeProducao getEtapa() {
		return etapa;
	}
	public void setEtapa(EtapaDeProducao etapa) {
		this.etapa = etapa;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public boolean isAtivo() {
		return ativo;
	}
	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
	
}



