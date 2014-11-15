package com.exemplo.controle;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.exemplo.entidade.OrdemDeProducao;
import com.exemplo.repositorio.RepositorioEtapaDeProducao;
import com.exemplo.repositorio.RepositorioOrdemDeProducao;
import com.exemplo.repositorio.RepositorioProduto;

@ManagedBean
@SessionScoped
public class ControleOrdemDeProducao {
	private OrdemDeProducao ordemDeProducao;
	private List<OrdemDeProducao> ordensDeProducao;
	private RepositorioOrdemDeProducao repositorioOrdemDeProducao;
	private RepositorioEtapaDeProducao repositorioEtapaDeProducao;
	private RepositorioProduto repositorioProduto;
	private int etapa;
	private int produto;
	
	public ControleOrdemDeProducao(){
		repositorioOrdemDeProducao = new RepositorioOrdemDeProducao();
		repositorioEtapaDeProducao = new RepositorioEtapaDeProducao();
		repositorioProduto = new RepositorioProduto();
	}
	
	public String novo(){
		ordemDeProducao = new OrdemDeProducao();
		ordemDeProducao.setAtivo(true);
		return "formularioOrdemDeProducao";
	}
	
	public String salvar(){
		ordemDeProducao.setEtapa(repositorioEtapaDeProducao.ObterPorId(etapa));
		ordemDeProducao.setProduto(repositorioProduto.ObterPorId(produto));
		repositorioOrdemDeProducao.salvar(ordemDeProducao);
		return "listarOrdemDeProducao";
	}

	public String editar(OrdemDeProducao ordemDeProducao){
		this.ordemDeProducao = ordemDeProducao;
		this.etapa = ordemDeProducao.getEtapa().getId();
		this.produto = ordemDeProducao.getProduto().getId();
		return "formularioOrdemDeProducao";
	}
	
	public String remover(OrdemDeProducao ordemDeProducao){
		repositorioOrdemDeProducao.remover(ordemDeProducao);
		return null;
	}
	
	public String cancelar(){
		return "listarOrdemDeProducao";
	}

	public OrdemDeProducao getOrdemDeProducao() {
		return ordemDeProducao;
	}

	public void setOrdemDeProducao(OrdemDeProducao ordemDeProducao) {
		this.ordemDeProducao = ordemDeProducao;
	}

	public List<OrdemDeProducao> getOrdensDeProducao() {
		ordensDeProducao = repositorioOrdemDeProducao.listarTodos();
		return ordensDeProducao;
	}

	public void setOrdensDeProducao(List<OrdemDeProducao> ordensDeProducao) {
		this.ordensDeProducao = ordensDeProducao;
	}

	public int getProduto() {
		return produto;
	}

	public void setProduto(int produto) {
		this.produto = produto;
	}

	public int getEtapa() {
		return etapa;
	}

	public void setEtapa(int etapa) {
		this.etapa = etapa;
	}
	
}
