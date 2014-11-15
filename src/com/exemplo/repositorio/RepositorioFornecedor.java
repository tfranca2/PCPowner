package com.exemplo.repositorio;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.exemplo.entidade.Fornecedor;

public class RepositorioFornecedor {
	
	EntityManagerFactory emf;
	EntityManager em;
	
	public RepositorioFornecedor(){
		emf = Persistence.createEntityManagerFactory("pcp");
		em = emf.createEntityManager();
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
		Query consulta = em.createQuery("select fornecedor from Fornecedor fornecedor");
		List<Fornecedor> fornecedores = consulta.getResultList();
		em.getTransaction().commit();
		emf.close();
		return fornecedores;
	}
	
	public Fornecedor ObterPorId(int id){
		em.getTransaction().begin();
		Fornecedor fornecedor = em.find(Fornecedor.class, id);
		em.getTransaction().commit();
		emf.close();
		return fornecedor;
	}
	
}
