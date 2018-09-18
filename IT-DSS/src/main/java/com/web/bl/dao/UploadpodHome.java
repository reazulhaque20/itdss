package com.web.bl.dao;
// Generated Aug 1, 2018 3:05:01 PM by Hibernate Tools 4.3.5.Final

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;

import com.web.bl.model.Uploadpod;

/**
 * Home object for domain model class Uploadpod.
 * @see com.web.bl.gen.Uploadpod
 * @author Hibernate Tools
 */
@Repository
@Transactional
public class UploadpodHome {

	private static final Log log = LogFactory.getLog(UploadpodHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Uploadpod transientInstance) {
		log.debug("persisting Uploadpod instance");
		try {
			transientInstance.setUploadpodId(getUploadPODId());
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Uploadpod persistentInstance) {
		log.debug("removing Uploadpod instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Uploadpod merge(Uploadpod detachedInstance) {
		log.debug("merging Uploadpod instance");
		try {
			Uploadpod result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Uploadpod findById(BigDecimal id) {
		log.debug("getting Uploadpod instance with id: " + id);
		try {
			Uploadpod instance = entityManager.find(Uploadpod.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
	
	public BigDecimal getUploadPODId() {
		Query query;
		try {
			query = entityManager.createNativeQuery("select UPLOADPOD_SEQ.nextval from dual");
			BigDecimal  uploadPODId= (BigDecimal) query.getSingleResult();
			return uploadPODId;
		}catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Uploadpod> findByMsisdn(String msisdn){
		Query query;
		try {
			query = entityManager.createQuery("SELECT e FROM Uploadpod e WHERE e.msisdn=:msisdn");
			query.setParameter("msisdn", msisdn);
			
			return (List<Uploadpod>) query.getResultList();
		}catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
}
