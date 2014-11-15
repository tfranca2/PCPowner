package com.exemplo.controle;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.exemplo.entidade.EtapaDeProducao;
import com.exemplo.repositorio.RepositorioEtapaDeProducao;

@ManagedBean
@SessionScoped
public class ControleEtapaDeProducao {
	
	private EtapaDeProducao etapaDeProducao;
	private List<EtapaDeProducao> etapasDeProducao;
	private RepositorioEtapaDeProducao repositorioEtapaDeProducao;
	
	public ControleEtapaDeProducao(){
		repositorioEtapaDeProducao = new RepositorioEtapaDeProducao();
	}
	
	public String novo(){
		etapaDeProducao = new EtapaDeProducao();
		etapaDeProducao.setAtivo(true);
		return "formularioEtapaDeProducao";
	}
	
	public String salvar(){
		repositorioEtapaDeProducao.salvar(etapaDeProducao);
		return "listarEtapaDeProducao";
	}

	public String editar(EtapaDeProducao etapaDeProducao){
		this.etapaDeProducao = etapaDeProducao;
		return "formularioEtapaDeProducao";
	}
	
	public String remover(EtapaDeProducao etapaDeProducao){
		repositorioEtapaDeProducao.remover(etapaDeProducao);
		return null;
	}
	
	public String cancelar(){
		return "listarEtapaDeProducao";
	}

	public EtapaDeProducao getEtapaDeProducao() {
		return etapaDeProducao;
	}

	public void setEtapaDeProducao(EtapaDeProducao etapaDeProducao) {
		this.etapaDeProducao = etapaDeProducao;
	}

	public List<EtapaDeProducao> getEtapasDeProducao() {
		etapasDeProducao = repositorioEtapaDeProducao.listarTodos();
		return etapasDeProducao;
	}

	public void setEtapasDeProducao(List<EtapaDeProducao> etapasDeProducao) {
		this.etapasDeProducao = etapasDeProducao;
	}
}

