package com.exemplo.controle;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.exemplo.entidade.Produto;
import com.exemplo.repositorio.RepositorioProduto;

@ManagedBean
@SessionScoped
public class ControleProduto {
	private Produto produto;
	private List<Produto> produtos;
	private RepositorioProduto repositorioProduto;
	
	public ControleProduto(){
		repositorioProduto = new RepositorioProduto();
	}
	
	public String novo(){
		produto = new Produto();
		return "formularioProduto";
	}
	
	public String salvar(){
		repositorioProduto.salvar(produto);
		return "listarProdutos";
	}

	public String editar(Produto produto){
		this.produto = produto;
		return "formularioProduto";
	}
	
	public String remover(Produto produto){
		repositorioProduto.remover(produto);
		return null;
	}
	
	public String cancelar(){
		return "listarProdutos";
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public List<Produto> getProdutos() {
		produtos = repositorioProduto.listarTodos();
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}
	
}
