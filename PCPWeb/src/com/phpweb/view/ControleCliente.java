package com.phpweb.view;

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

	public String editar(){
		return "formularioCliente";
	}
	
	public String remover(){
		repositorioCliente.remover(cliente);
		return null;
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

