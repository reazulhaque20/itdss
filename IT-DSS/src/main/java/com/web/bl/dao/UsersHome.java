package com.web.bl.dao;
// Generated May 27, 2018 12:58:26 PM by Hibernate Tools 4.3.5.Final

import java.math.BigDecimal;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;

import com.web.bl.model.Users;

/**
 * Home object for domain model class Users.
 * @see com.web.bl.model.Users
 * @author Hibernate Tools
 */
@Repository
@Transactional
public class UsersHome {

	private static final Log log = LogFactory.getLog(UsersHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Users transientInstance) {
		log.debug("persisting Users instance");
		try {
			transientInstance.setUserid(getUsersID());
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Users persistentInstance) {
		log.debug("removing Users instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Users merge(Users detachedInstance) {
		log.debug("merging Users instance");
		try {
			Users result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}
	
	public BigDecimal getUsersID() {
		Query query;
		try {
			query = entityManager.createNativeQuery("select USERS_SEQ.nextval from dual");
			BigDecimal usersId = (BigDecimal) query.getSingleResult();
			return usersId;
		}catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public Users findById(BigDecimal id) {
		log.debug("getting Users instance with id: " + id);
		try {
			Users instance = entityManager.find(Users.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
