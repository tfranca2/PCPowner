package com.exemplo.repositorio;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.exemplo.entidade.Volume;

public class RepositorioVolume {
	
	EntityManagerFactory emf;
	EntityManager em;
	
	public RepositorioVolume(){
		emf = Persistence.createEntityManagerFactory("pcp");
		em = emf.createEntityManager();
	}

	public void salvar(Volume volume){
		em.getTransaction().begin();
		em.merge(volume);
		em.getTransaction().commit();
		emf.close();
	} 
	
	public void remover(Volume volume){
		em.getTransaction().begin();
		em.remove(volume);
		em.getTransaction().commit();
		emf.close();
	} 
	
	@SuppressWarnings("unchecked")
	public List<Volume> listarTodos(){
		em.getTransaction().begin();
		Query consulta = em.createQuery("select volume from Volume volume");
		List<Volume> volumes = consulta.getResultList();
		em.getTransaction().commit();
		emf.close();
		return volumes;
	}
	
	public Volume ObterPorId(int id){
		em.getTransaction().begin();
		Volume volume = em.find(Volume.class, id);
		em.getTransaction().commit();
		emf.close();
		return volume;
	}
	
}
