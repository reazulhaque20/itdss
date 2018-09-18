package com.web.bl.dao;
// Generated Sep 17, 2018 10:15:01 AM by Hibernate Tools 4.3.5.Final

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;

import com.web.bl.model.CustomerProduct;

/**
 * Home object for domain model class CustomerProduct.
 * @see com.web.bl.gen.CustomerProduct
 * @author Hibernate Tools
 */
@Repository
@Transactional
public class CustomerProductHome {

	private static final Log log = LogFactory.getLog(CustomerProductHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(CustomerProduct transientInstance) {
		log.debug("persisting CustomerProduct instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(CustomerProduct persistentInstance) {
		log.debug("removing CustomerProduct instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public CustomerProduct merge(CustomerProduct detachedInstance) {
		log.debug("merging CustomerProduct instance");
		try {
			CustomerProduct result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public CustomerProduct findById(BigDecimal id) {
		log.debug("getting CustomerProduct instance with id: " + id);
		try {
			CustomerProduct instance = entityManager.find(CustomerProduct.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<CustomerProduct> findByProductName(String prodName){
		Query query;
		try {
			query = entityManager.createQuery("SELECT e FROM CustomerProduct e WHERE e.prodName=:prodName");
			query.setParameter("prodName", prodName);
			
			return (List<CustomerProduct>) query.getResultList();
		}catch(Exception ex){
			ex.printStackTrace();
			return null;
		}
	}
}
