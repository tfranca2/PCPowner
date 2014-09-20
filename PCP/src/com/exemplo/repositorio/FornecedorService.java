package com.exemplo.repositorio;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.exemplo.entidade.Fornecedor;

public class FornecedorService {

	EntityManagerFactory emf;
	EntityManager em;
	
	public FornecedorService(){
		emf = Persistence.createEntityManagerFactory("loja");
		em = emf.createEntityManager();
	}
	
	
	

	public EntityManager getEm() {
		return em;
	}




	public void setEm(EntityManager em) {
		this.em = em;
	}




	public void salvar(Fornecedor fornecedor){
		em.getTransaction().begin();
		em.merge(fornecedor);
		em.getTransaction().commit();
		emf.close();
	} 
	
	public void remover(Fornecedor fornecedor){
		em.getTransaction().begin();
		em.remove(fornecedor);
		em.getTransaction().commit();
		emf.close();
	} 
	
	@SuppressWarnings("unchecked")
	public List<Fornecedor> listarTodos(){
		em.getTransaction().begin();
		Query consulta = em.createQuery("select cliente from Cliente cliente");
		List<Fornecedor> fornecedor = consulta.getResultList();
		em.getTransaction().commit();
		emf.close();
		return fornecedor;
	}
	
	public Fornecedor ObterPorId(int id){
		em.getTransaction().begin();
		Fornecedor fornecedor = em.find(Fornecedor.class, id);
		em.getTransaction().commit();
		emf.close();
		return fornecedor;
	}
}
