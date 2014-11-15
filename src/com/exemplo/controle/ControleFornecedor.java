package com.exemplo.controle;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.exemplo.entidade.Contato;
import com.exemplo.entidade.Endereco;
import com.exemplo.entidade.Fornecedor;
import com.exemplo.repositorio.RepositorioCidade;
import com.exemplo.repositorio.RepositorioFornecedor;

@ManagedBean
@SessionScoped
public class ControleFornecedor {
	private Fornecedor fornecedor;
	private List<Fornecedor> fornecedores;
	private RepositorioFornecedor repositorioFornecedor;
	private RepositorioCidade repositorioCidade;
	private int cidade;
	private Endereco endereco;
	private Contato contato;
	
	public ControleFornecedor(){
		repositorioFornecedor = new RepositorioFornecedor();
		repositorioCidade = new RepositorioCidade();
	}
	
	public String novo(){
		fornecedor = new Fornecedor();
		endereco = new Endereco();
		contato = new Contato();
		contato.setAtivo(true);
		fornecedor.setAtivo(true);
		return "formularioFornecedor";
	}
	
	public String salvar(){
		endereco.setCidade(repositorioCidade.ObterPorId(cidade));
		fornecedor.setEndereco(endereco);
		fornecedor.setContato(contato);
		repositorioFornecedor.salvar(fornecedor);
		return "listarFornecedores";
	}

	public String editar(Fornecedor fornecedor){
		this.fornecedor = fornecedor;
		this.endereco = fornecedor.getEndereco();
		this.cidade = fornecedor.getEndereco().getCidade().getId();
		this.contato = fornecedor.getContato();
		return "formularioFornecedor";
	}
	
	public String remover(Fornecedor fornecedor){
		repositorioFornecedor.remover(fornecedor);;
		return null;
	}
	
	public String cancelar(){
		return "listarFornecedores";
	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	public List<Fornecedor> getFornecedores() {
		fornecedores = repositorioFornecedor.listarTodos();
		return fornecedores;
	}

	public void setFornecedores(List<Fornecedor> fornecedores) {
		this.fornecedores = fornecedores;
	}

	public int getCidade() {
		return cidade;
	}

	public void setCidade(int cidade) {
		this.cidade = cidade;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Contato getContato() {
		return contato;
	}

	public void setContato(Contato contato) {
		this.contato = contato;
	}
	
}
