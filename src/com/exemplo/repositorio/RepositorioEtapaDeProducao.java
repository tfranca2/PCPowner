package com.exemplo.repositorio;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.exemplo.entidade.EtapaDeProducao;

public class RepositorioEtapaDeProducao {
	
	EntityManagerFactory emf;
	EntityManager em;
	
	public RepositorioEtapaDeProducao(){
		emf = Persistence.createEntityManagerFactory("pcp");
		em = emf.createEntityManager();
	}

	public void salvar(EtapaDeProducao etapaDeProducao){
		em.getTransaction().begin();
		em.merge(etapaDeProducao);
		em.getTransaction().commit();
		emf.close();
	} 
	
	public void remover(EtapaDeProducao etapaDeProducao){
		em.getTransaction().begin();
		em.remove(etapaDeProducao);
		em.getTransaction().commit();
		emf.close();
	} 
	
	@SuppressWarnings("unchecked")
	public List<EtapaDeProducao> listarTodos(){
		em.getTransaction().begin();
		Query consulta = em.createQuery("select etapaDeProducao from EtapaDeProducao etapaDeProducao");
		List<EtapaDeProducao> etapaDeProducao = consulta.getResultList();
		em.getTransaction().commit();
		emf.close();
		return etapaDeProducao;
	}
	
	public EtapaDeProducao ObterPorId(int id){
		em.getTransaction().begin();
		EtapaDeProducao etapaDeProducao = em.find(EtapaDeProducao.class, id);
		em.getTransaction().commit();
		emf.close();
		return etapaDeProducao;
	}
	
}
