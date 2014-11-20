package com.exemplo.repositorio;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.exemplo.entidade.EstruturaProduto;
import com.exemplo.entidade.Produto;

public class RepositorioEstruturaProduto {
	
	EntityManagerFactory emf;
	EntityManager em;
	
	public RepositorioEstruturaProduto(){
		emf = Persistence.createEntityManagerFactory("pcp");
		em = emf.createEntityManager();
	}

	public void salvar(EstruturaProduto estruturaProduto){
		em.getTransaction().begin();
		em.merge(estruturaProduto);
		em.getTransaction().commit();
		emf.close();
	} 
	
	public void remover(EstruturaProduto estruturaProduto){
		em.getTransaction().begin();
		em.remove(estruturaProduto);
		em.getTransaction().commit();
		emf.close();
	} 
	
	@SuppressWarnings("unchecked")
	public List<EstruturaProduto> listarTodos(){
		em.getTransaction().begin();
		Query consulta = em.createQuery("select estruturaProduto from EstruturaProduto estruturaProduto");
		List<EstruturaProduto> estruturaProdutos = consulta.getResultList();
		em.getTransaction().commit();
		emf.close();
		return estruturaProdutos;
	}
	
	public EstruturaProduto ObterPorId(int id){
		em.getTransaction().begin();
		EstruturaProduto estruturaProduto = em.find(EstruturaProduto.class, id);
		em.getTransaction().commit();
		emf.close();
		return estruturaProduto;
	}
	
	public List<Produto> produtosFilho(){
		
		return null;
	}
	
}
