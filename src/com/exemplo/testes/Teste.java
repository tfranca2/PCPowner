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
		RepositorioEstruturaProduto re = new RepositorioEstruturaProduto();
		Produto b = new Produto();
		RepositorioProduto rp = new RepositorioProduto();
		Produto a = new Produto();
		
		a = rp.ObterPorId(5);
		
		System.out.println(a.getId());
		
		

	}
}
