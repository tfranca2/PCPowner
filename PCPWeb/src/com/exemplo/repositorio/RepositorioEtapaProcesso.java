package com.exemplo.repositorio;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.exemplo.entidade.EtapaProcesso;

public class RepositorioEtapaProcesso {
	
	EntityManagerFactory emf;
	EntityManager em;
	
	public RepositorioEtapaProcesso(){
		emf = Persistence.createEntityManagerFactory("pcp");
		em = emf.createEntityManager();
	}

	public void salvar(EtapaProcesso etapaProcesso){
		em.getTransaction().begin();
		em.merge(etapaProcesso);
		em.getTransaction().commit();
		emf.close();
	} 
	
	public void remover(EtapaProcesso etapaProcesso){
		em.getTransaction().begin();
		em.remove(etapaProcesso);
		em.getTransaction().commit();
		emf.close();
	} 
	
	@SuppressWarnings("unchecked")
	public List<EtapaProcesso> listarTodos(){
		em.getTransaction().begin();
		Query consulta = em.createQuery("select etapaProcesso from EtapaProcesso etapaProcesso");
		List<EtapaProcesso> etapaProcessos = consulta.getResultList();
		em.getTransaction().commit();
		emf.close();
		return etapaProcessos;
	}
	
	public EtapaProcesso ObterPorId(int id){
		em.getTransaction().begin();
		EtapaProcesso etapaProcesso = em.find(EtapaProcesso.class, id);
		em.getTransaction().commit();
		emf.close();
		return etapaProcesso;
	}
	
}
