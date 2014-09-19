package com.exemplo.testes;

import java.util.Date;

import com.exemplo.entidade.Fornecedor;
import com.exemplo.entidade.FornecedorProduto;
import com.exemplo.entidade.Produto;
import com.exemplo.repositorio.FornecedorService;



public class Teste {
	public static void main(String[] args) {
		FornecedorService service = new FornecedorService();

		service.getEm().getTransaction().begin();

		Fornecedor fornecedor = new Fornecedor();
		fornecedor.setAtivo(true);
		fornecedor.setNomeFantasia("");
        Produto produto1 = new Produto();
        service.getEm().persist(produto1);
        
        FornecedorProduto fornecedorProduto = new FornecedorProduto();
        
        fornecedorProduto.setFornecedor(fornecedor);
        fornecedorProduto.setProduto(produto1);
        fornecedorProduto.setDataCriacao(new Date());
        
        
        fornecedor.getFornecedorProdutos().add(fornecedorProduto);
        
        service.getEm().persist(fornecedor);
       
        service.getEm().getTransaction().commit();
		System.out.println("Done");
			
	}

}
