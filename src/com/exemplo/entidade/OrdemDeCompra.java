package com.exemplo.entidade;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table
public class OrdemDeCompra {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idOrdemDeCompra")
	private int id;
	@Column
	private String numeroDaOrdem;
	@Column
	private String requisitante;
	@ManyToOne
	private Produto produto;
	@ManyToOne
	private Fornecedor fornecedor;
	@Column
	private double valorUnitario;
	@Column
	private double quantidade;
	@Column
	private double valorTotal;
	@Column
	@Temporal(TemporalType.DATE)
	private Date dataEmicao;
	@Column
	@Temporal(TemporalType.DATE)
	private Date dataEntrega;
	@Column
	private String tipoFrete;
	@Column
	private double valorFrete;
	@Column
	private String tipoPagamento;

	
	
	
	
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNumeroDaOrdem() {
		return numeroDaOrdem;
	}

	public void setNumeroDaOrdem(String numeroDaOrdem) {
		this.numeroDaOrdem = numeroDaOrdem;
	}

	public String getRequisitante() {
		return requisitante;
	}

	public void setRequisitante(String requisitante) {
		this.requisitante = requisitante;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	



	public Date getDataEmicao() {
		return dataEmicao;
	}

	public void setDataEmicao(Date dataEmicao) {
		this.dataEmicao = dataEmicao;
	}

	public Date getDataEntrega() {
		return dataEntrega;
	}

	public void setDataEntrega(Date dataEntrega) {
		this.dataEntrega = dataEntrega;
	}

	public String getTipoFrete() {
		return tipoFrete;
	}

	public void setTipoFrete(String tipoFrete) {
		this.tipoFrete = tipoFrete;
	}

	public double getValorFrete() {
		return valorFrete;
	}

	public void setValorFrete(double valorFrete) {
		this.valorFrete = valorFrete;
	}

	public String getTipoPagamento() {
		return tipoPagamento;
	}

	public void setTipoPagamento(String tipoPagamento) {
		this.tipoPagamento = tipoPagamento;
	}

	public double getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(double valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	public double getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(double quantidade) {
		this.quantidade = quantidade;
	}

	public double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}

}
