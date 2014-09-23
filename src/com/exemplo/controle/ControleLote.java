package com.exemplo.controle;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.exemplo.entidade.Lote;
import com.exemplo.repositorio.RepositorioLote;

@ManagedBean
@SessionScoped
public class ControleLote {
	private Lote lote;
	private List<Lote> lotes;
	private RepositorioLote repositorioLote;
	
	public ControleLote(){
		repositorioLote = new RepositorioLote();
	}
	
	public String novo(){
		lote = new Lote();
		return "formularioLote";
	}
	
	public String salvar(){
		repositorioLote.salvar(lote);
		return "listarLotes";
	}

	public String editar(Lote lote){
		this.lote = lote;
		return "formularioLote";
	}
	
	public String remover(Lote lote){
		repositorioLote.remover(lote);;
		return null;
	}
	
	public String cancelar(){
		return "listarLotes";
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
	
}
