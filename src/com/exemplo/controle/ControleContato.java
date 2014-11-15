package com.exemplo.controle;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.exemplo.entidade.Contato;
import com.exemplo.repositorio.RepositorioContato;

@ManagedBean
@SessionScoped
public class ControleContato {
	private Contato contato;
	private List<Contato> contatos;
	private RepositorioContato repositorioContato;
	
	public ControleContato(){
		repositorioContato = new RepositorioContato();
	}
	
	public String novo(){
		contato = new Contato();
		return "formularioContato";
	}
	
	public String salvar(){
		repositorioContato.salvar(contato);
		
		return "listarContatos";
	}

	public String editar(){
		return "formularioCidade";
	}
	
	public String remover(){
		repositorioContato.remover(contato);
		return "listarContatos";
	}
	
	public String cancelar(){
		return "listarContatos";
	}

	public Contato getContato() {
		return contato;
	}

	public void setContato(Contato contato) {
		this.contato = contato;
	}

	public List<Contato> getContatos() {
		return contatos;
	}

	public void setContatos(List<Contato> contatos) {
		this.contatos = contatos;
	}
	
}
