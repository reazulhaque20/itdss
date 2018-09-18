package com.web.bl.dao;
// Generated Apr 15, 2018 10:36:42 AM by Hibernate Tools 4.3.5.Final

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;

import com.web.bl.model.Emails;

/**
 * Home object for domain model class Emails.
 * @see com.web.bl.model.Emails
 * @author Hibernate Tools
 */
@Repository
@Transactional
public class EmailsHome {

	private static final Log log = LogFactory.getLog(EmailsHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Emails transientInstance) {
		log.debug("persisting Emails instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Emails persistentInstance) {
		log.debug("removing Emails instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Emails merge(Emails detachedInstance) {
		log.debug("merging Emails instance");
		try {
			Emails result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Emails findById(Emails id) {
		log.debug("getting Emails instance with id: " + id);
		try {
			Emails instance = entityManager.find(Emails.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
	
	public Emails finfByMSISDN(String msisdn) {
		
		Query query;
		try {
			query = entityManager.createQuery("SELECT e FROM Emails e WHERE e.id.msisdn=:msisdn", Emails.class).setParameter("msisdn", msisdn);
			//query = entityManager.createNativeQuery("select t.*, t.rowid from emails t where t.msisdn = '1962424653'", Emails.class);
			
			return (Emails) query.getSingleResult();
		}
		catch(Exception ex) {
			ex.printStackTrace();
			
			return null;
		}
		
	}
	
}
