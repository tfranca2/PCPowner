package com.exemplo.controle;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.exemplo.entidade.EstruturaProduto;
import com.exemplo.entidade.Produto;
import com.exemplo.repositorio.RepositorioEstruturaProduto;
import com.exemplo.repositorio.RepositorioProduto;

@ManagedBean
@SessionScoped
public class ControleEstruturaProduto {
	private EstruturaProduto estruturaProduto;
	private Produto produtoPai;
	private List<Produto> produtosPai;
	private List<Produto> produtosFilho;
	private List<Produto> produtosFilhosSelecionados;
	private RepositorioEstruturaProduto repositorioEstruturaProduto;
	private RepositorioProduto repositorioProduto;
	private List<EstruturaProduto> allEstruturaProduto;

	public ControleEstruturaProduto() {
		repositorioEstruturaProduto = new RepositorioEstruturaProduto();
		repositorioProduto = new RepositorioProduto();
		estruturaProduto = new EstruturaProduto();
	}
	
	public String novo(){
		estruturaProduto = new EstruturaProduto();
		return "listarEstruturaProduto";
	}
	
	public String salvar(){
		
		estruturaProduto.setProdutoPai(produtoPai);
		repositorioEstruturaProduto.salvar(estruturaProduto);
		return "listarEstruturaProduto";
	}

	public String editar(){
		return "formularioCliente";
	}
	
	public String remover(){
		repositorioEstruturaProduto.remover(estruturaProduto);
		return "ListarEstruturaProduto";
	}
	
	public String cancelar(){
		return "formularioEstruturaProduto";
	}
	
	
	
	
	
	//-------------------------------------------------------------------------------------------------------------//

	
	
	public EstruturaProduto getEstruturaProduto() {
		return estruturaProduto;
	}

	public void setEstruturaProduto(EstruturaProduto estruturaProduto) {
		this.estruturaProduto = estruturaProduto;
	}

	public Produto getProdutoPai() {
		return produtoPai;
	}

	public void setProdutoPai(Produto produtoPai) {
		this.produtoPai = produtoPai;
	}

	public List<Produto> getProdutosPai() {
		produtosPai = repositorioProduto.listarTodos();
		return produtosPai;
	}

	public void setProdutosPai(List<Produto> produtosPai) {
		this.produtosPai = produtosPai;
	}

	public List<Produto> getProdutosFilho() {
		produtosFilho = repositorioProduto.listarTodos();
		return produtosFilho;
	}

	public void setProdutosFilho(List<Produto> produtosFilho) {
		this.produtosFilho = produtosFilho;
	}

	public List<Produto> getProdutosFilhosSelecionados() {
		return produtosFilhosSelecionados;
	}

	public void setProdutosFilhosSelecionados(
			List<Produto> produtosFilhosSelecionados) {
		this.produtosFilhosSelecionados = produtosFilhosSelecionados;
	}

	public RepositorioEstruturaProduto getRepositorioEstruturaProduto() {
		return repositorioEstruturaProduto;
	}

	public void setRepositorioEstruturaProduto(
			RepositorioEstruturaProduto repositorioEstruturaProduto) {
		this.repositorioEstruturaProduto = repositorioEstruturaProduto;
	}

	public RepositorioProduto getRepositorioProduto() {
		return repositorioProduto;
	}

	public void setRepositorioProduto(RepositorioProduto repositorioProduto) {
		this.repositorioProduto = repositorioProduto;
	}

	public List<EstruturaProduto> getAllEstruturaProduto() {
		allEstruturaProduto = repositorioEstruturaProduto.listarTodos();
		return allEstruturaProduto;
	}

	public void setAllEstruturaProduto(List<EstruturaProduto> allEstruturaProduto) {
		this.allEstruturaProduto = allEstruturaProduto;
	}
}
