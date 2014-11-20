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
	private int idPai;
	private int idFilho;
	private List<Produto> produtosPai;
	private List<Produto> produtosFilho;
	private RepositorioEstruturaProduto repositorioEstruturaProduto;
	private RepositorioProduto repositorioProduto;
	private List<EstruturaProduto> allEstruturaProduto;

	public ControleEstruturaProduto() {
		repositorioEstruturaProduto = new RepositorioEstruturaProduto();
		repositorioProduto = new RepositorioProduto();
		estruturaProduto = new EstruturaProduto();
	}

	public String salvar() {
		estruturaProduto.setProdutoPai(repositorioProduto.ObterPorId(idPai));
		estruturaProduto
				.setProdutoFilho(repositorioProduto.ObterPorId(idFilho));
		repositorioEstruturaProduto.salvar(estruturaProduto);
		return "listarEstruturaProdutos";
	}

	public String novo() {
		estruturaProduto = new EstruturaProduto();
		return "formularioEstruturaProduto";
	}

	public String remover() {
		repositorioEstruturaProduto.remover(estruturaProduto);
		return "listarEstruturaProdutos";
	}

	public String editar() {
		return "formularioEstruturaProduto";
	}

	public EstruturaProduto getEstruturaProduto() {
		return estruturaProduto;
	}

	public void setEstruturaProduto(EstruturaProduto estruturaProduto) {
		this.estruturaProduto = estruturaProduto;
	}

	public int getIdPai() {
		return idPai;
	}

	public void setIdPai(int idPai) {
		this.idPai = idPai;
	}

	public int getIdFilho() {
		return idFilho;
	}

	public void setIdFilho(int idFilho) {
		this.idFilho = idFilho;
	}

	public List<Produto> getProdutosPai() {
		return produtosPai;
	}

	public void setProdutosPai(List<Produto> produtosPai) {
		this.produtosPai = produtosPai;
	}

	public List<Produto> getProdutosFilho() {
		return produtosFilho;
	}

	public void setProdutosFilho(List<Produto> produtosFilho) {
		this.produtosFilho = produtosFilho;
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

	public void setAllEstruturaProduto(
			List<EstruturaProduto> allEstruturaProduto) {
		this.allEstruturaProduto = allEstruturaProduto;
	}

}
