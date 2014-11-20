package com.exemplo.controle;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.exemplo.entidade.ChaoDeFabrica;
import com.exemplo.entidade.EstruturaProduto;
import com.exemplo.entidade.OrdemDeProducao;
import com.exemplo.repositorio.RepositorioChaoDeFabrica;
import com.exemplo.repositorio.RepositorioEstruturaProduto;
import com.exemplo.repositorio.RepositorioOrdemDeProducao;

@ManagedBean
@SessionScoped
public class ControleChaoDeFabrica{
	private ChaoDeFabrica chaoDeFabrica;
	private List<ChaoDeFabrica> chaosDeFabrica;
	private List<OrdemDeProducao> ordens;
	private RepositorioChaoDeFabrica repositorioChaoDeFabrica;
	private RepositorioOrdemDeProducao repositorioOrdemDeProducao;
	private RepositorioEstruturaProduto repositorioEstruturaProduto;
	private Date data;
	private int etapa;
	private double perda;
	private double aproveitamento;

	public ControleChaoDeFabrica(){
		repositorioChaoDeFabrica = new RepositorioChaoDeFabrica();
		repositorioOrdemDeProducao = new RepositorioOrdemDeProducao();
		repositorioEstruturaProduto = new RepositorioEstruturaProduto();
	}
	
	public String filtrar(){
		
		List<OrdemDeProducao> ordens = repositorioOrdemDeProducao.listarTodos();
		List<OrdemDeProducao> ordensFiltradas = new ArrayList<OrdemDeProducao>();
//		List<OrdemDeProducao> ordensDaData = new ArrayList<OrdemDeProducao>();
		
//		SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd");
//	    String d = dt.format(data);
		
//		for (OrdemDeProducao ordemDeProducao : ordens) {
//			if(dt.format(ordemDeProducao.getData()) == d)
//				ordensDaData.add(ordemDeProducao);
//		}
//		for (OrdemDeProducao ordemDeProducao : ordensDaData) {
		for (OrdemDeProducao ordemDeProducao : ordens) {
			if(ordemDeProducao.getEtapa().getId() == etapa)
				ordensFiltradas.add(ordemDeProducao);
		}
		
		this.ordens = ordensFiltradas;
		selecionaSubProdutos();
		return "";
	}
	
	public String selecionaSubProdutos(){
		chaosDeFabrica = new ArrayList<ChaoDeFabrica>();
		int idProdutoPai = 0;
		List<EstruturaProduto> estruturas = repositorioEstruturaProduto.listarTodos();
		
		for (OrdemDeProducao ordem : ordens) {
			idProdutoPai = ordem.getProduto().getId();
			for (EstruturaProduto estruturaProduto : estruturas) {
				if(estruturaProduto.getProdutoPai().getId() == idProdutoPai){
					chaoDeFabrica = new ChaoDeFabrica();
					chaoDeFabrica.setOrdem(ordem);
					chaoDeFabrica.setConsumoNominal( ordem.getQuantidade()*estruturaProduto.getConversor() );
					chaoDeFabrica.setProduto(estruturaProduto.getProdutoFilho());
					this.chaosDeFabrica.add(chaoDeFabrica);
				}
			}
		}
		
		return "";
	}
	
	public void calculaPerda(){
		perda = chaoDeFabrica.getConsumoReal() - chaoDeFabrica.getConsumoNominal();
	}

	public void calculaAproveitamento(){
		aproveitamento = (1-(perda/chaoDeFabrica.getConsumoNominal()))*100;
	}
	
	public String novo(){
		chaoDeFabrica = new ChaoDeFabrica();
		return "formularioChaoDeFabrica";
	}
	
	public String salvar(){
		repositorioChaoDeFabrica.salvar(chaoDeFabrica);		
		return "listarChaoDeFabrica";
	}

	public String editar(ChaoDeFabrica chao){
		if( chao.getConsumoReal() == 0.0 ){			
			this.chaoDeFabrica = repositorioChaoDeFabrica.filtrarPorOrdemProduto(chao);
		}else{
			this.chaoDeFabrica = chao;
		}
		return "formularioChaoDeFabrica";
	}
	
	public String remover(ChaoDeFabrica chao){
		this.chaoDeFabrica = chao;
		repositorioChaoDeFabrica.remover(chaoDeFabrica);
		return "listarChaoDeFabrica";
	}
	
	public String cancelar(){
		return "listarChaoDeFabrica";
	}

	
	
	
	
	
	
	public ChaoDeFabrica getChaoDeFabrica() {
		return chaoDeFabrica;
	}

	public void setChaoDeFabrica(ChaoDeFabrica chaoDeFabrica) {
		this.chaoDeFabrica = chaoDeFabrica;
	}

	public List<ChaoDeFabrica> getChaosDeFabrica() {
		return chaosDeFabrica;
	}

	public void setChaosDeFabrica(List<ChaoDeFabrica> chaosDeFabrica) {
		this.chaosDeFabrica = chaosDeFabrica;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public List<OrdemDeProducao> getOrdens() {
		return ordens;
	}

	public void setOrdens(List<OrdemDeProducao> ordens) {
		this.ordens = ordens;
	}

	public int getEtapa() {
		return etapa;
	}

	public void setEtapa(int etapa) {
		this.etapa = etapa;
	}

	public double getPerda() {
		return perda;
	}

	public void setPerda(double perda) {
		this.perda = perda;
	}

	public double getAproveitamento() {
		return aproveitamento;
	}

	public void setAproveitamento(double aproveitamento) {
		this.aproveitamento = aproveitamento;
	}
}
