package com.web.bl.dao;
// Generated Jun 3, 2018 11:54:15 AM by Hibernate Tools 4.3.5.Final

import java.math.BigDecimal;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;

import com.web.bl.model.Userandusergroupmap;

/**
 * Home object for domain model class Userandusergroupmap.
 * @see com.web.bl.model.Userandusergroupmap
 * @author Hibernate Tools
 */
@Repository
@Transactional
public class UserandusergroupmapHome {

	private static final Log log = LogFactory.getLog(UserandusergroupmapHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Userandusergroupmap transientInstance) {
		log.debug("persisting Userandusergroupmap instance");
		try {
			transientInstance.setUserandusergroupmapid(getuserandUserGroupMapID());
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Userandusergroupmap persistentInstance) {
		log.debug("removing Userandusergroupmap instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Userandusergroupmap merge(Userandusergroupmap detachedInstance) {
		log.debug("merging Userandusergroupmap instance");
		try {
			Userandusergroupmap result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Userandusergroupmap findById(BigDecimal id) {
		log.debug("getting Userandusergroupmap instance with id: " + id);
		try {
			Userandusergroupmap instance = entityManager.find(Userandusergroupmap.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
	
	public BigDecimal getuserandUserGroupMapID() {
		Query query;
		try {
			query = entityManager.createNativeQuery("select USERGROUPANDUSERGROUPMAP_SEQ.nextval from dual");
			
			return (BigDecimal) query.getSingleResult();
		}catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
	
	public Userandusergroupmap getUserandUserGroupMapByUserNameandPassword(String userName, String password) throws RuntimeException {
		Query query;
		try {
			query = entityManager.createQuery("SELECT e FROM Userandusergroupmap e WHERE e.users.networkid =:userName AND e.users.password =:password ");
			query.setParameter("userName", userName);
			query.setParameter("password", password);
			return (Userandusergroupmap) query.getSingleResult(); 
		}catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
}
