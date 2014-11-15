package com.exemplo.controle;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.exemplo.entidade.Lote;
import com.exemplo.repositorio.RepositorioLote;
import com.exemplo.repositorio.RepositorioProduto;

@ManagedBean
@SessionScoped
public class ControleLote {
	private Lote lote;
	private List<Lote> lotes;
	private RepositorioLote repositorioLote;
	private RepositorioProduto repositorioProduto;
	private int produtoId;
	private Date fabricacao;
	
	public ControleLote(){
		repositorioLote = new RepositorioLote();
		repositorioProduto = new RepositorioProduto();
	}
	
	public String novo(){
		lote = new Lote();
		fabricacao = new Date(System.currentTimeMillis());
		lote.setAtivo(true);
		return "formularioLote";
	}
	
	public String salvar(){
		lote.setProduto(repositorioProduto.ObterPorId(produtoId));
		lote.setFabricacao(fabricacao);
		repositorioLote.salvar(lote);
		return "listarLotes";
	}

	public String editar(Lote lote){
		this.lote = lote;
		this.fabricacao = lote.getFabricacao();
		this.produtoId = lote.getProduto().getId();
		return "formularioLote";
	}
	
	public String remover(Lote lote){
		repositorioLote.remover(lote);;
		return null;
	}
	
	public String cancelar(){
		return "listarLotes";
	}

	public void atualizaValidade(){
		int add = repositorioProduto.ObterPorId(produtoId).getValidade();
		Calendar c = Calendar.getInstance();
		c.setTime(fabricacao);
		c.add(Calendar.DAY_OF_MONTH, add);
		lote.setValidade(c.getTime());
	}
	
	public Lote getLote() {
		return lote;
	}

	public void setLote(Lote lote) {
		this.lote = lote;
	}

	public List<Lote> getLotes() {
		lotes = repositorioLote.listarTodos();
		return lotes;
	}

	public void setLotes(List<Lote> lotes) {
		this.lotes = lotes;
	}

	public int getProdutoId() {
		return produtoId;
	}

	public void setProdutoId(int produtoId) {
		this.produtoId = produtoId;
	}

	public Date getFabricacao() {
		return fabricacao;
	}

	public void setFabricacao(Date fabricacao) {
		this.fabricacao = fabricacao;
	}
	
}
