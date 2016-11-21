package br.com.smallbi.dal;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.smallbi.dal.interfaceDal.InterfaceDao;
import br.com.smallbi.dal.singleton.SingletonConexao;
import br.com.smallbi.entity.Empresa;

public class EmpresaDao implements InterfaceDao<Empresa>{

	@Override
	public void create(Empresa t) {
		EntityManager em = SingletonConexao.getInstance();
		em.getTransaction().begin();
		em.persist(t);
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public List<Empresa> list() {
		EntityManager em = SingletonConexao.getInstance();
		Query q = em.createQuery("SELECT e FROM Empresa e");
		return q.getResultList();
	}

	@Override
	public void update(Empresa t) {
		EntityManager em = SingletonConexao.getInstance();
		em.getTransaction().begin();
		em.merge(t);
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public void delete(Empresa t) {
		EntityManager em = SingletonConexao.getInstance();
		em.getTransaction().begin();
		em.remove(t);
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public Empresa getObjById(Integer id) {
		EntityManager em = SingletonConexao.getInstance();
		return em.find(Empresa.class, id);
	}

}
