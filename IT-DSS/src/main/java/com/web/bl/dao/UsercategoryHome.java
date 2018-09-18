package com.web.bl.dao;
// Generated May 27, 2018 12:58:26 PM by Hibernate Tools 4.3.5.Final

import java.math.BigDecimal;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;

import com.web.bl.model.Usercategory;

/**
 * Home object for domain model class Usercategory.
 * @see com.web.bl.model.Usercategory
 * @author Hibernate Tools
 */
@Repository
@Transactional
public class UsercategoryHome {

	private static final Log log = LogFactory.getLog(UsercategoryHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Usercategory transientInstance) {
		log.debug("persisting Usercategory instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Usercategory persistentInstance) {
		log.debug("removing Usercategory instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Usercategory merge(Usercategory detachedInstance) {
		log.debug("merging Usercategory instance");
		try {
			Usercategory result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Usercategory findById(BigDecimal id) {
		log.debug("getting Usercategory instance with id: " + id);
		try {
			Usercategory instance = entityManager.find(Usercategory.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
