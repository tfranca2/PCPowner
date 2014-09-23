package com.exemplo.repositorio;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.exemplo.entidade.Produto;

public class RepositorioProduto {
	
	EntityManagerFactory emf;
	EntityManager em;
	
	public RepositorioProduto(){
		emf = Persistence.createEntityManagerFactory("pcp");
		em = emf.createEntityManager();
	}

	public void salvar(Produto produto){
		em.getTransaction().begin();
		em.merge(produto);
		em.getTransaction().commit();
		emf.close();
	} 
	
	public void remover(Produto produto){
		em.getTransaction().begin();
		em.remove(produto);
		em.getTransaction().commit();
		emf.close();
	} 
	
	@SuppressWarnings("unchecked")
	public List<Produto> listarTodos(){
		em.getTransaction().begin();
		Query consulta = em.createQuery("select produto from Produto produto");
		List<Produto> produtos = consulta.getResultList();
		em.getTransaction().commit();
		emf.close();
		return produtos;
	}
	
	public Produto ObterPorId(int id){
		em.getTransaction().begin();
		Produto produto = em.find(Produto.class, id);
		em.getTransaction().commit();
		emf.close();
		return produto;
	}
	
}
