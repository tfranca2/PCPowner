package com.exemplo.repositorio;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.exemplo.entidade.Endereco;

public class RepositorioEndereco {
	
	EntityManagerFactory emf;
	EntityManager em;
	
	public RepositorioEndereco(){
		emf = Persistence.createEntityManagerFactory("pcp");
		em = emf.createEntityManager();
	}

	public void salvar(Endereco endereco){
		em.getTransaction().begin();
		em.merge(endereco);
		em.getTransaction().commit();
		emf.close();
	} 
	
	public void remover(Endereco endereco){
		em.getTransaction().begin();
		em.remove(endereco);
		em.getTransaction().commit();
		emf.close();
	} 
	
	@SuppressWarnings("unchecked")
	public List<Endereco> listarTodos(){
		em.getTransaction().begin();
		Query consulta = em.createQuery("select endereco from Endereco endereco");
		List<Endereco> enderecos = consulta.getResultList();
		em.getTransaction().commit();
		emf.close();
		return enderecos;
	}
	
	public Endereco ObterPorId(int id){
		em.getTransaction().begin();
		Endereco endereco = em.find(Endereco.class, id);
		em.getTransaction().commit();
		emf.close();
		return endereco;
	}
	
}
