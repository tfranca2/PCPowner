package com.exemplo.repositorio;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.exemplo.entidade.Lote;

public class RepositorioLote {
	
	EntityManagerFactory emf;
	EntityManager em;
	
	public RepositorioLote(){
		emf = Persistence.createEntityManagerFactory("pcp");
		em = emf.createEntityManager();
	}

	public void salvar(Lote lote){
		em.getTransaction().begin();
		em.merge(lote);
		em.getTransaction().commit();
		emf.close();
	} 
	
	public void remover(Lote lote){
		em.getTransaction().begin();
		em.remove(lote);
		em.getTransaction().commit();
		emf.close();
	} 
	
	@SuppressWarnings("unchecked")
	public List<Lote> listarTodos(){
		em.getTransaction().begin();
		Query consulta = em.createQuery("select lote from Lote lote");
		List<Lote> lotes = consulta.getResultList();
		em.getTransaction().commit();
		emf.close();
		return lotes;
	}
	
	public Lote ObterPorId(int id){
		em.getTransaction().begin();
		Lote lote = em.find(Lote.class, id);
		em.getTransaction().commit();
		emf.close();
		return lote;
	}
	
}
