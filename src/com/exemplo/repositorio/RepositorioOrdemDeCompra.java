package com.exemplo.repositorio;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.exemplo.entidade.OrdemDeCompra;

public class RepositorioOrdemDeCompra{
	EntityManagerFactory emf;
	EntityManager em;
	
	public RepositorioOrdemDeCompra() {
		emf = Persistence.createEntityManagerFactory("pcp");
		em =  emf.createEntityManager();
	}
	
	public void salvar(OrdemDeCompra ordemDeCompra){
		em.getTransaction().begin();
		em.merge(ordemDeCompra);
		em.getTransaction().commit();
		emf.close();
	}
	
	public void remover(OrdemDeCompra ordemDeCompra){
		em.getTransaction().begin();
		em.remove(ordemDeCompra);
		em.getTransaction().commit();
		emf.close();
	}
	
	@SuppressWarnings("unchecked")
	public List<OrdemDeCompra> listarTodos(){
		em.getTransaction().begin();
		Query consulta = em.createQuery("select ordemDeCompra from OrdemDeCompra ordemDeCompra");
		List<OrdemDeCompra> ordemDeCompras = consulta.getResultList();
		em.getTransaction().commit();
		emf.close();
		return ordemDeCompras;
		
	}
		public OrdemDeCompra obterPorId(int id){
			em.getTransaction().begin();
			OrdemDeCompra ordemDeCompra = em.find(OrdemDeCompra.class, id);
			em.getTransaction().commit();
			emf.close();
			return ordemDeCompra;
	}
}
