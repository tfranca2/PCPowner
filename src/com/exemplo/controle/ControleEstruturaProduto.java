package com.exemplo.controle;

import java.util.ArrayList;
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
	private int idPai;
	private List<Integer> idFilhos;
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
	}
	
	public String novo(){
		estruturaProduto = new EstruturaProduto();
		return "formularioEstruturaProduto";
	}
	
	public List<Produto> objetosSelecionados(){
		List<Produto> produtos = new ArrayList<Produto>();	
		for (int ids : idFilhos) {	
				produtos.add(repositorioProduto.ObterPorId(ids));
			}
		return produtos;
	}
	
	public String salvar(){
		produtoPai = repositorioProduto.ObterPorId(idPai);
		estruturaProduto.setProdutosFilho(produtosFilho);
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

	public int getIdPai() {
		return idPai;
	}

	public void setIdPai(int idPai) {
		this.idPai = idPai;
	}

	public List<EstruturaProduto> getAllEstruturaProduto() {
		allEstruturaProduto = repositorioEstruturaProduto.listarTodos();
		return allEstruturaProduto;
	}

	public void setAllEstruturaProduto(List<EstruturaProduto> allEstruturaProduto) {
		this.allEstruturaProduto = allEstruturaProduto;
	}

	public List<Integer> getIdFilhos() {
		return idFilhos;
	}

	public void setIdFilhos(List<Integer> idFilhos) {
		this.idFilhos = idFilhos;
	}
}
