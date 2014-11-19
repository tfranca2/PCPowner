package com.exemplo.controle;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.exemplo.entidade.OrdemDeCompra;
import com.exemplo.repositorio.RepositorioFornecedor;
import com.exemplo.repositorio.RepositorioOrdemDeCompra;
import com.exemplo.repositorio.RepositorioProduto;

@ManagedBean
@SessionScoped
public class ControleOrdemDeCompra {
	private int idProduto;
	private int idFornecedor;
	private OrdemDeCompra ordemDeCompra;
	private List<OrdemDeCompra> ordemDeCompras;
	private List<String> tiposFrete;
	private List<String> tiposPagamento;
	private RepositorioOrdemDeCompra repositorioOrdemDeCompra;
	private RepositorioFornecedor repositorioFornecedor;
	private RepositorioProduto repositorioProduto;
	
	public ControleOrdemDeCompra() {
		ordemDeCompras = new ArrayList<OrdemDeCompra>();
		tiposFrete = new ArrayList<String>();
		tiposPagamento = new ArrayList<String>();
		ordemDeCompra = new OrdemDeCompra();
		repositorioFornecedor = new RepositorioFornecedor();
		repositorioProduto = new RepositorioProduto();
		repositorioOrdemDeCompra = new RepositorioOrdemDeCompra();
	}
	
	@PostConstruct
	public void unit(){
		tiposPagamento.add("A Vista");
		tiposPagamento.add("Boleto");
		tiposPagamento.add("Cheque");
		
		tiposFrete.add("FOB");
		tiposFrete.add("CIF");
	}
	

	
	public String salvar() {
		ordemDeCompra.setProduto(repositorioProduto.ObterPorId(idProduto));
		ordemDeCompra.setFornecedor(repositorioFornecedor.ObterPorId(idFornecedor));

		
		ordemDeCompra.setValorTotal((ordemDeCompra.getValorUnitario() * ordemDeCompra.getQuantidade())+ ordemDeCompra.getValorFrete());
		
		repositorioOrdemDeCompra.salvar(ordemDeCompra);
		return "listarVolumes";
	}

	public int getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(int idProduto) {
		this.idProduto = idProduto;
	}

	public int getIdFornecedor() {
		return idFornecedor;
	}

	public void setIdFornecedor(int idFornecedor) {
		this.idFornecedor = idFornecedor;
	}

	public OrdemDeCompra getOrdemDeCompra() {
		return ordemDeCompra;
	}

	public void setOrdemDeCompra(OrdemDeCompra ordemDeCompra) {
		this.ordemDeCompra = ordemDeCompra;
	}

	public List<OrdemDeCompra> getOrdemDeCompras() {
		ordemDeCompras = repositorioOrdemDeCompra.listarTodos();
		return ordemDeCompras;
	}

	public void setOrdemDeCompras(List<OrdemDeCompra> ordemDeCompras) {
		this.ordemDeCompras = ordemDeCompras;
	}

	public List<String> getTiposFrete() {
		return tiposFrete;
	}

	public void setTiposFrete(List<String> tiposFrete) {
		this.tiposFrete = tiposFrete;
	}

	public List<String> getTiposPagamento() {
		return tiposPagamento;
	}

	public void setTiposPagamento(List<String> tiposPagamento) {
		this.tiposPagamento = tiposPagamento;
	}

	public RepositorioOrdemDeCompra getRepositorioOrdemDeCompra() {
		return repositorioOrdemDeCompra;
	}

	public void setRepositorioOrdemDeCompra(
			RepositorioOrdemDeCompra repositorioOrdemDeCompra) {
		this.repositorioOrdemDeCompra = repositorioOrdemDeCompra;
	}

}
