package com.exemplo.controle;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.exemplo.entidade.Fornecedor;
import com.exemplo.repositorio.RepositorioFornecedor;

@ManagedBean
@SessionScoped
public class ControleFornecedor {
	private Fornecedor fornecedor;
	private List<Fornecedor> fornecedores;
	private RepositorioFornecedor repositorioFornecedor;
	
	public ControleFornecedor(){
		repositorioFornecedor = new RepositorioFornecedor();
	}
	
	public String novo(){
		fornecedor = new Fornecedor();
		return "formularioFornecedor";
	}
	
	public String salvar(){
		repositorioFornecedor.salvar(fornecedor);
		return "listarFornecedores";
	}

	public String editar(Fornecedor fornecedor){
		this.fornecedor = fornecedor;
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
	
}
