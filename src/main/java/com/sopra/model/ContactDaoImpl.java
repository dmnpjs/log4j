package com.sopra.model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;


public class ContactDaoImpl implements ContactDao {
	EntityManager em=Context.getInstance().getEmf().createEntityManager();

	@Override
	public List<Contact> findAll() {
		Query q = em.createQuery("from Client");
		return q.getResultList();
	}

	@Override
	public Contact findByKey(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteByKey(Integer key) {
		Contact a = em.find(Contact.class, key);
		try {
			em.getTransaction().begin();
			if (a != null) {
				em.remove(a);
			}
			em.getTransaction().commit();

		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			em.getTransaction().rollback();
		}}

	@Override
	public Contact insert(Contact obj) {
		try {
			em.getTransaction().begin();
			em.persist(obj);
			em.getTransaction().commit();

		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			em.getTransaction().rollback();
		}
		return obj;
	}

	@Override
	public void update(Contact obj) {
		Contact a = null;
		try {
			em.getTransaction().begin();
			a = em.merge(obj);
			em.getTransaction().commit();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			em.getTransaction().rollback();
		}

	}

		
	}


