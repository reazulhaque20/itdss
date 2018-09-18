package com.web.bl.dao;
// Generated Jun 3, 2018 11:54:15 AM by Hibernate Tools 4.3.5.Final

import java.math.BigDecimal;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;

import com.web.bl.model.Usergrouppage;

/**
 * Home object for domain model class Usergrouppage.
 * @see com.web.bl.model.Usergrouppage
 * @author Hibernate Tools
 */
@Repository
@Transactional
public class UsergrouppageHome {

	private static final Log log = LogFactory.getLog(UsergrouppageHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Usergrouppage transientInstance) {
		log.debug("persisting Usergrouppage instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Usergrouppage persistentInstance) {
		log.debug("removing Usergrouppage instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Usergrouppage merge(Usergrouppage detachedInstance) {
		log.debug("merging Usergrouppage instance");
		try {
			Usergrouppage result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Usergrouppage findById(BigDecimal id) {
		log.debug("getting Usergrouppage instance with id: " + id);
		try {
			Usergrouppage instance = entityManager.find(Usergrouppage.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
