package com.exemplo.repositorio;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.exemplo.entidade.ChaoDeFabrica;

public class RepositorioChaoDeFabrica {
	
	EntityManagerFactory emf;
	EntityManager em;
	
	public RepositorioChaoDeFabrica(){
		emf = Persistence.createEntityManagerFactory("pcp");
		em = emf.createEntityManager();
	}

	public void salvar(ChaoDeFabrica chaodefabrica){
		em.getTransaction().begin();
		em.merge(chaodefabrica);
		em.getTransaction().commit();
		emf.close();
	} 
	
	public void remover(ChaoDeFabrica chaodefabrica){
		em.getTransaction().begin();
		em.remove(chaodefabrica);
		em.getTransaction().commit();
		emf.close();
	} 
	
	@SuppressWarnings("unchecked")
	public List<ChaoDeFabrica> listarTodos(){
		em.getTransaction().begin();
		Query consulta = em.createQuery("select chaodefabrica from ChaoDeFabrica chaodefabrica");
		List<ChaoDeFabrica> chaodefabrica = consulta.getResultList();
		em.getTransaction().commit();
		emf.close();
		return chaodefabrica;
	}
	
	@SuppressWarnings("unchecked")
	public ChaoDeFabrica filtrarPorOrdemProduto(ChaoDeFabrica chao){
		int ordem = chao.getOrdem().getId();
		int produto = chao.getProduto().getId();
		 try{
			em.getTransaction().begin();
			Query consulta = em.createQuery("select cf from ChaoDeFabrica cf where cf.ordem.id = :ordem and cf.produto.id = :produto ");
			consulta.setParameter("ordem", ordem );
			consulta.setParameter("produto", produto );
			List<ChaoDeFabrica> chaodefabrica = consulta.getResultList();
			em.getTransaction().commit();
			emf.close();
	
			return chaodefabrica.get(0);
		 }catch(Exception e){
			 return chao;
		 }
	}
	
	public ChaoDeFabrica ObterPorId(int id){
		em.getTransaction().begin();
		ChaoDeFabrica chaodefabrica = em.find(ChaoDeFabrica.class, id);
		em.getTransaction().commit();
		emf.close();
		return chaodefabrica;
	}
}
