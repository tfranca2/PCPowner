package com.exemplo.controle;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.exemplo.entidade.Endereco;
import com.exemplo.repositorio.RepositorioEndereco;

@ManagedBean
@SessionScoped
public class ControleEndereco {
	private Endereco endereco;
	private List<Endereco> enderecos;
	private RepositorioEndereco repositorioEndereco;
	
	public ControleEndereco(){
		repositorioEndereco = new RepositorioEndereco();
	}
	
	public String novo(){
		endereco = new Endereco();
		return "formularioEndereco";
	}
	
	public String salvar(){
		repositorioEndereco.salvar(endereco);
		
		return "listarEnderecos";
	}

	public String editar(){
		return "formularioEndereco";
	}
	
	public String remover(){
		repositorioEndereco.remover(endereco);
		return "listarEnderecos";
	}
	
	public String cancelar(){
		return "listarEnderecos";
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public List<Endereco> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}

}
