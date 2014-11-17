package com.exemplo.controle;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.exemplo.entidade.Cliente;
import com.exemplo.repositorio.RepositorioCliente;

@ManagedBean
@SessionScoped
public class ControleCliente {
	private Cliente cliente;
	private List<Cliente> clientes;
	private RepositorioCliente repositorioCliente;
	
	
	public ControleCliente(){
		repositorioCliente = new RepositorioCliente();
	}
	
	public String novo(){
		cliente = new Cliente();
		return "formularioCliente";
	}
	
	public String salvar(){
		repositorioCliente.salvar(cliente);
		return "listarClientes";
	}

	public String editar(Cliente cliente){
		this.cliente = cliente;
		return "formularioCliente";
	}
	
	public String remover(Cliente cliente){
		repositorioCliente.remover(cliente);
		return null;
	}
	
	public String cancelar(){
		return "listarClientes";
	}
	
	public List<Cliente> getClientes() {
		clientes = repositorioCliente.listarTodos();
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
}
