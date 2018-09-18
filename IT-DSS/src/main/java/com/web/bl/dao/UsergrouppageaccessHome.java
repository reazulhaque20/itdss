package com.web.bl.dao;
// Generated Jun 3, 2018 11:54:15 AM by Hibernate Tools 4.3.5.Final

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;

import com.web.bl.model.Usergroup;
import com.web.bl.model.Usergrouppageaccess;

/**
 * Home object for domain model class Usergrouppageaccess.
 * @see com.web.bl.model.Usergrouppageaccess
 * @author Hibernate Tools
 */
@Repository
@Transactional
public class UsergrouppageaccessHome {

	private static final Log log = LogFactory.getLog(UsergrouppageaccessHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Usergrouppageaccess transientInstance) {
		log.debug("persisting Usergrouppageaccess instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Usergrouppageaccess persistentInstance) {
		log.debug("removing Usergrouppageaccess instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Usergrouppageaccess merge(Usergrouppageaccess detachedInstance) {
		log.debug("merging Usergrouppageaccess instance");
		try {
			Usergrouppageaccess result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Usergrouppageaccess findById(BigDecimal id) {
		log.debug("getting Usergrouppageaccess instance with id: " + id);
		try {
			Usergrouppageaccess instance = entityManager.find(Usergrouppageaccess.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Usergrouppageaccess> findByUserGroupandPageID(Usergroup ug, BigDecimal pageID) {
		Query query;
		try {
			query = entityManager.createQuery("SELECT e FROM Usergrouppageaccess e WHERE e.usergroup=:ug AND e.usergrouppage.usergrouppageid=:pageID",Usergrouppageaccess.class);
			query.setParameter("ug", ug);
			query.setParameter("pageID", pageID);
			return (List<Usergrouppageaccess>) query.getResultList();
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
}
