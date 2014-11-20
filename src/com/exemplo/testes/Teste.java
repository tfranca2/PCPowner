package com.exemplo.testes;

import com.exemplo.entidade.EstruturaProduto;
import com.exemplo.entidade.OrdemDeCompra;
import com.exemplo.repositorio.RepositorioOrdemDeCompra;



public class Teste {

	public static void main(String[] args) {
		
		OrdemDeCompra ordemDeCompra = new OrdemDeCompra();
		RepositorioOrdemDeCompra compra = new RepositorioOrdemDeCompra();
		
		ordemDeCompra.setNumeroDaOrdem("dwdwd");
		
		compra.salvar(ordemDeCompra);

	}
}
