package com.exemplo.repositorio;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.exemplo.entidade.Contato;

public class RepositorioContato {
	
	EntityManagerFactory emf;
	EntityManager em;
	
	public RepositorioContato(){
		emf = Persistence.createEntityManagerFactory("pcp");
		em = emf.createEntityManager();
	}

	public void salvar(Contato contato){
		em.getTransaction().begin();
		em.merge(contato);
		em.getTransaction().commit();
		emf.close();
	} 
	
	public void remover(Contato contato){
		em.getTransaction().begin();
		em.remove(contato);
		em.getTransaction().commit();
		emf.close();
	} 
	
	@SuppressWarnings("unchecked")
	public List<Contato> listarTodos(){
		em.getTransaction().begin();
		Query consulta = em.createQuery("select contato from Contato contato");
		List<Contato> contatos = consulta.getResultList();
		em.getTransaction().commit();
		emf.close();
		return contatos;
	}
	
	public Contato ObterPorId(int id){
		em.getTransaction().begin();
		Contato contato = em.find(Contato.class, id);
		em.getTransaction().commit();
		emf.close();
		return contato;
	}
	
}
