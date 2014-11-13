package com.exemplo.testes;

import java.util.ArrayList;
import java.util.List;

import com.exemplo.entidade.EstruturaProduto;
import com.exemplo.entidade.Produto;
import com.exemplo.repositorio.RepositorioEstruturaProduto;
import com.exemplo.repositorio.RepositorioProduto;


public class Teste {

	public static void main(String[] args) {
		List<EstruturaProduto> list = new ArrayList<EstruturaProduto>();
		EstruturaProduto ep = new EstruturaProduto();
		EstruturaProduto ep2 = new EstruturaProduto();
		RepositorioProduto rp = new RepositorioProduto();
		RepositorioEstruturaProduto re = new RepositorioEstruturaProduto();
		Produto a = new Produto();
		Produto b = new Produto();
		Produto c = new Produto();
		
		a = rp.ObterPorId(5);
		b = rp.ObterPorId(7);
		c = rp.ObterPorId(8);
		
		
		
		ep.setAtivo(true);
		ep.setConversor(1);
		ep.setProdutoFilho(a);
		
		
		
		ep2.setAtivo(true);
		ep2.setConversor(2);
	
		ep2.setProdutoFilho(b);
		
		
		
		
		list.add(ep2);
		list.add(ep);
	
		for (EstruturaProduto estruturaProduto : list) {
			estruturaProduto.setProdutoPai(a);
			re.salvar(estruturaProduto);
		}
		
		
		
		
		
	}
}
