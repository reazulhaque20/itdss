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

import com.web.bl.model.Customers;

/**
 * Home object for domain model class Customers.
 * @see com.web.bl.model.Customers
 * @author Hibernate Tools
 */
@Repository
@Transactional
public class CustomersHome {

	private static final Log log = LogFactory.getLog(CustomersHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public BigDecimal persist(Customers transientInstance) {
		log.debug("persisting Customers instance");
		try {
			BigDecimal customerID = getCustomersId();
			transientInstance.setCId(getCustomersId());
			entityManager.persist(transientInstance);
			log.debug("persist successful");
			return customerID;
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Customers persistentInstance) {
		log.debug("removing Customers instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Customers merge(Customers detachedInstance) {
		log.debug("merging Customers instance");
		try {
			Customers result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Customers findById(BigDecimal id) {
		log.debug("getting Customers instance with id: " + id);
		try {
			Customers instance = entityManager.find(Customers.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
	
	public BigDecimal getCustomersId() {
		Query query;
		try {
			query = entityManager.createNativeQuery("select CUSTOMERS_SEQ.nextval from dual");
			BigDecimal usersId = (BigDecimal) query.getSingleResult();
			return usersId;
		}catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
	
	public Integer getCustomerIdByMSISDN( String msisdn) {
		Query query;
		try {
			query = entityManager.createQuery("SELECT e.CId FROM Customers e WHERE e.msisdn=:msisdn", Customers.class).setParameter("msisdn", msisdn);
			
			return (Integer) query.getSingleResult();
		}catch(Exception ex) {
			ex.printStackTrace();
			return 0;
		}
		
	}
}
