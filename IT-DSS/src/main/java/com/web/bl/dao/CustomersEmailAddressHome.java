package com.web.bl.dao;
// Generated May 7, 2018 10:14:48 AM by Hibernate Tools 4.3.5.Final

import java.math.BigDecimal;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;

import com.web.bl.model.CustomersEmailAddress;

/**
 * Home object for domain model class CustomersEmailAddress.
 * @see com.web.bl.model.CustomersEmailAddress
 * @author Hibernate Tools
 */
@Repository
@Transactional
public class CustomersEmailAddressHome {

	private static final Log log = LogFactory.getLog(CustomersEmailAddressHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(CustomersEmailAddress transientInstance) {
		log.debug("persisting CustomersEmailAddress instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(CustomersEmailAddress persistentInstance) {
		log.debug("removing CustomersEmailAddress instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public CustomersEmailAddress merge(CustomersEmailAddress detachedInstance) {
		log.debug("merging CustomersEmailAddress instance");
		try {
			CustomersEmailAddress result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public CustomersEmailAddress findById(BigDecimal id) {
		log.debug("getting CustomersEmailAddress instance with id: " + id);
		try {
			CustomersEmailAddress instance = entityManager.find(CustomersEmailAddress.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
	
	public CustomersEmailAddress findByMSISDN(String msisdn) {
		Query query;
		try {
			query = entityManager.createQuery("SELECT e FROM CustomersEmailAddress e WHERE e.customers.msisdn=:msisdn", CustomersEmailAddress.class);
			query.setParameter("msisdn", msisdn);
			
			return (CustomersEmailAddress) query.getSingleResult(); 
		}catch(Exception ex) {
			//ex.printStackTrace();
			return null;
		}
	}
}
