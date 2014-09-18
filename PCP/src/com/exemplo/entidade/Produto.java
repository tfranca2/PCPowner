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
@Table(name="produto")
public class Produto {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idProduto")
	private int id;
	@Column
	private String produto;
	@OneToOne
	private Volume volume;
	@Column
	private String codigoDeBarras;
//	@OneToOne
//	private Tipo tipo;
	@Column
	private float pesoLiquido;
	@Column
	private float pesoBruto;
	@Column
	private int fatorCaixa;
	@Column
	private int fatorPallet;
	@Column
	private boolean controleDeQualidade;
	@OneToMany
	private List<Fornecedor> fornecedores;
	@Column
	private int estoqueMinimo;
	@Column
	private int validade;
	@Column
	private boolean ativo;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getProduto() {
		return produto;
	}
	public void setProduto(String produto) {
		this.produto = produto;
	}
	public Volume getVolume() {
		return volume;
	}
	public void setVolume(Volume volume) {
		this.volume = volume;
	}
	public String getCodigoDeBarras() {
		return codigoDeBarras;
	}
	public void setCodigoDeBarras(String codigoDeBarras) {
		this.codigoDeBarras = codigoDeBarras;
	}
//	public Tipo getTipo() {
//		return tipo;
//	}
//	public void setTipo(Tipo tipo) {
//		this.tipo = tipo;
//	}
	public float getPesoLiquido() {
		return pesoLiquido;
	}
	public void setPesoLiquido(float pesoLiquido) {
		this.pesoLiquido = pesoLiquido;
	}
	public float getPesoBruto() {
		return pesoBruto;
	}
	public void setPesoBruto(float pesoBruto) {
		this.pesoBruto = pesoBruto;
	}
	public int getFatorCaixa() {
		return fatorCaixa;
	}
	public void setFatorCaixa(int fatorCaixa) {
		this.fatorCaixa = fatorCaixa;
	}
	public int getFatorPallet() {
		return fatorPallet;
	}
	public void setFatorPallet(int fatorPallet) {
		this.fatorPallet = fatorPallet;
	}
	public boolean isControleDeQualidade() {
		return controleDeQualidade;
	}
	public void setControleDeQualidade(boolean controleDeQualidade) {
		this.controleDeQualidade = controleDeQualidade;
	}
	public List<Fornecedor> getFornecedores() {
		return fornecedores;
	}
	public void setFornecedores(List<Fornecedor> fornecedores) {
		this.fornecedores = fornecedores;
	}
	public int getEstoqueMinimo() {
		return estoqueMinimo;
	}
	public void setEstoqueMinimo(int estoqueMinimo) {
		this.estoqueMinimo = estoqueMinimo;
	}
	public int getValidade() {
		return validade;
	}
	public void setValidade(int validade) {
		this.validade = validade;
	}
	public boolean isAtivo() {
		return ativo;
	}
	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
	
//	@Override
//	public String toString() {
//		return "Produto [id=" + id + ", produto=" + produto + ", volume="
//				+ volume + ", codigoDeBarras=" + codigoDeBarras + ", tipo="
//				+ tipo + ", pesoLiquido=" + pesoLiquido + ", pesoBruto="
//				+ pesoBruto + ", fatorCaixa=" + fatorCaixa + ", fatorPallet="
//				+ fatorPallet + ", controleDeQualidade=" + controleDeQualidade
//				+ ", fornecedores=" + fornecedores + ", estoqueMinimo="
//				+ estoqueMinimo + ", validade=" + validade + ", ativo=" + ativo
//				+ "]";
//	}
}
//
//enum Tipo { 
//	Acabado(1), Elaboracao(2), Embalagem(3), Imobilizado(4); 
//	public int valorTipo; 
//	
//	Tipo(int valor) { 
//		valorTipo = valor; 
//	} 
//}

