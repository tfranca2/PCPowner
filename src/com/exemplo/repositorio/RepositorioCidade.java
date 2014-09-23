package com.exemplo.repositorio;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.exemplo.entidade.Cidade;

public class RepositorioCidade {
	
	EntityManagerFactory emf;
	EntityManager em;
	
	public RepositorioCidade(){
		emf = Persistence.createEntityManagerFactory("pcp");
		em = emf.createEntityManager();
	}

	public void salvar(Cidade cidade){
		em.getTransaction().begin();
		em.merge(cidade);
		em.getTransaction().commit();
		emf.close();
	} 
	
	public void remover(Cidade cidade){
		em.getTransaction().begin();
		em.remove(cidade);
		em.getTransaction().commit();
		emf.close();
	} 
	
	@SuppressWarnings("unchecked")
	public List<Cidade> listarTodos(){
		em.getTransaction().begin();
		Query consulta = em.createQuery("select cidade from Cidade cidade");
		List<Cidade> cidades = consulta.getResultList();
		em.getTransaction().commit();
		emf.close();
		return cidades;
	}
	
	public Cidade ObterPorId(int id){
		em.getTransaction().begin();
		Cidade cidade = em.find(Cidade.class, id);
		em.getTransaction().commit();
		emf.close();
		return cidade;
	}
	
}
