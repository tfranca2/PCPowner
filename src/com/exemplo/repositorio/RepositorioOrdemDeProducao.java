package com.exemplo.repositorio;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.exemplo.entidade.OrdemDeProducao;

public class RepositorioOrdemDeProducao {

	EntityManagerFactory emf;
	EntityManager em;
	
	public RepositorioOrdemDeProducao(){
		emf = Persistence.createEntityManagerFactory("pcp");
		em = emf.createEntityManager();
	}

	public void salvar(OrdemDeProducao ordemDeProducao){
		em.getTransaction().begin();
		em.merge(ordemDeProducao);
		em.getTransaction().commit();
		emf.close();
	} 
	
	public void remover(OrdemDeProducao ordemDeProducao){
		em.getTransaction().begin();
		em.remove(ordemDeProducao);
		em.getTransaction().commit();
		emf.close();
	} 
	
	@SuppressWarnings("unchecked")
	public List<OrdemDeProducao> listarTodos(){
		em.getTransaction().begin();
		Query consulta = em.createQuery("select ordemDeProducao from OrdemDeProducao ordemDeProducao");
		List<OrdemDeProducao> ordensDeProducao = consulta.getResultList();
		em.getTransaction().commit();
		emf.close();
		return ordensDeProducao;
	}
	
	public OrdemDeProducao ObterPorId(int id){
		em.getTransaction().begin();
		OrdemDeProducao ordemDeProducao = em.find(OrdemDeProducao.class, id);
		em.getTransaction().commit();
		emf.close();
		return ordemDeProducao;
	}
	
}


