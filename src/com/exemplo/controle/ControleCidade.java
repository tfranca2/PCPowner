package com.exemplo.controle;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.exemplo.entidade.Cidade;
import com.exemplo.repositorio.RepositorioCidade;

@ManagedBean
@SessionScoped
public class ControleCidade {
	private Cidade cidade;
	private List<Cidade> cidades;
	private RepositorioCidade repositorioCidade;
	
	public ControleCidade(){
		repositorioCidade = new RepositorioCidade();
	}
	
	public String novo(){
		cidade = new Cidade();
		return "formularioCidade";
	}
	
	public String salvar(){
		repositorioCidade.salvar(cidade);
		
		return "listarCidades";
	}

	public String editar(){
		return "formularioCidade";
	}
	
	public String remover(){
		repositorioCidade.remover(cidade);
		return "listarCidades";
	}
	
	public String cancelar(){
		return "listarCidades";
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public List<Cidade> getCidades() {
		cidades = repositorioCidade.listarTodos();
		return cidades;
	}

	public void setCidades(List<Cidade> cidades) {
		this.cidades = cidades;
	}
	
}
