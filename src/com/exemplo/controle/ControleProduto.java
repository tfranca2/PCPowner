package com.exemplo.controle;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.exemplo.entidade.Produto;
import com.exemplo.repositorio.RepositorioFornecedor;
import com.exemplo.repositorio.RepositorioProduto;
import com.exemplo.repositorio.RepositorioVolume;

@ManagedBean
@SessionScoped
public class ControleProduto {
	
	private Produto produto;
	private List<Produto> produtos;
	
	private RepositorioProduto repositorioProduto;
	private RepositorioVolume repositorioVolume;
	private RepositorioFornecedor repositorioFornecedor;
	
	private int volumeId;
	private int fornecedorId;
	
	public ControleProduto(){
		repositorioProduto = new RepositorioProduto();
		repositorioVolume = new RepositorioVolume();
		repositorioFornecedor = new RepositorioFornecedor();
	}
	
	public String novo(){
		produto = new Produto();
		produto.setAtivo(true);
		return "formularioProduto";
	}
	
	public String salvar(){
		produto.setVolume(repositorioVolume.ObterPorId( volumeId ));
		produto.setFornecedor(repositorioFornecedor.ObterPorId( fornecedorId ));
		repositorioProduto.salvar(produto);
		return "listarProdutos";
	}

	public String editar(Produto produto){
		this.produto = produto;
		this.volumeId = produto.getVolume().getId();
		this.fornecedorId = produto.getFornecedor().getId();
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

	public int getVolumeId() {
		return volumeId;
	}

	public void setVolumeId(int volumeId) {
		this.volumeId = volumeId;
	}

	public int getFornecedorId() {
		return fornecedorId;
	}

	public void setFornecedorId(int fornecedorId) {
		this.fornecedorId = fornecedorId;
	}
	
}
