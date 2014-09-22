<<<<<<< HEAD
package com.exemplo.entidade;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="fornecedor")
public class Fornecedor {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idFornecedor")
	private int id;
	@Column
	private String cpfCnpj;
	@Column
	private String razaoSocial;
	@Column
	private String nomeFantasia;
	@Column
	private String inscricaoEstadual;
	@Column
	private String inscricaoMunicipal;
	@OneToMany
	private List<Endereco> enderecos;
	@OneToMany
	private List<Contato> contatos;
	@Column
	private int prazoEntrega;
	@Column
	private boolean ativo;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNomeFantasia() {
		return nomeFantasia;
	}
	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}
	public String getRazaoSocial() {
		return razaoSocial;
	}
	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}
	public String getCpfCnpj() {
		return cpfCnpj;
	}
	public void setCpfCnpj(String cpfCnpj) {
		this.cpfCnpj = cpfCnpj;
	}
	public String getInscricaoEstadual() {
		return inscricaoEstadual;
	}
	public void setInscricaoEstadual(String inscricaoEstadual) {
		this.inscricaoEstadual = inscricaoEstadual;
	}
	public String getInscricaoMunicipal() {
		return inscricaoMunicipal;
	}
	public void setInscricaoMunicipal(String inscricaoMunicipal) {
		this.inscricaoMunicipal = inscricaoMunicipal;
	}
	public int getPrazoEntrega() {
		return prazoEntrega;
	}
	public void setPrazoEntrega(int prazoEntrega) {
		this.prazoEntrega = prazoEntrega;
	}
	public boolean isAtivo() {
		return ativo;
	}
	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
	public List<Endereco> getEnderecos() {
		return enderecos;
	}
	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}
	public List<Contato> getContatos() {
		return contatos;
	}
	public void setContatos(List<Contato> contatos) {
		this.contatos = contatos;
	}
	
	@Override
	public String toString() {
		return "Fornecedor [id=" + id + ", nomeFantasia=" + nomeFantasia
				+ ", razaoSocial=" + razaoSocial + ", cpfCnpj=" + cpfCnpj
				+ ", inscricaoEstadual=" + inscricaoEstadual
				+ ", inscricaoMunicipal=" + inscricaoMunicipal
				+ ", prazoEntrega=" + prazoEntrega + ", ativo=" + ativo
				+ ", enderecos=" + enderecos + ", contatos=" + contatos + "]";
	}
}
=======
package com.exemplo.entidade;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="fornecedor")
public class Fornecedor {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idFornecedor")
	private int id;
	@Column
	private String nomeFantasia;
	@Column
	private String razaoSocial;
	@Column
	private String cpfCnpj;
	@Column
	private String inscricaoEstadual;
	@Column
	private String inscricaoMunicipal;
	@Column
	private int prazoEntrega;
	@Column
	private boolean ativo;
//	@OneToMany
//	private List<Endereco> enderecos;
//	@OneToMany
//	private List<Contato> contatos;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "pk.fornecedor", cascade=CascadeType.ALL)
	private List<FornecedorProduto> fornecedorProdutos = new ArrayList<FornecedorProduto>();
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNomeFantasia() {
		return nomeFantasia;
	}
	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}
	public String getRazaoSocial() {
		return razaoSocial;
	}
	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}
	public String getCpfCnpj() {
		return cpfCnpj;
	}
	public void setCpfCnpj(String cpfCnpj) {
		this.cpfCnpj = cpfCnpj;
	}
	public String getInscricaoEstadual() {
		return inscricaoEstadual;
	}
	public void setInscricaoEstadual(String inscricaoEstadual) {
		this.inscricaoEstadual = inscricaoEstadual;
	}
	public String getInscricaoMunicipal() {
		return inscricaoMunicipal;
	}
	public void setInscricaoMunicipal(String inscricaoMunicipal) {
		this.inscricaoMunicipal = inscricaoMunicipal;
	}
	public int getPrazoEntrega() {
		return prazoEntrega;
	}
	public void setPrazoEntrega(int prazoEntrega) {
		this.prazoEntrega = prazoEntrega;
	}
	public boolean isAtivo() {
		return ativo;
	}
	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
	public List<FornecedorProduto> getFornecedorProdutos() {
		return fornecedorProdutos;
	}
	public void setFornecedorProdutos(List<FornecedorProduto> fornecedorProdutos) {
		this.fornecedorProdutos = fornecedorProdutos;
	}
}
>>>>>>> refs/heads/master
