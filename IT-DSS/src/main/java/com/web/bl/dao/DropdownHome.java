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

import com.web.bl.model.Dropdown;

/**
 * Home object for domain model class Dropdown.
 * @see com.web.bl.model.Dropdown
 * @author Hibernate Tools
 */
@Repository
@Transactional
public class DropdownHome {

	private static final Log log = LogFactory.getLog(DropdownHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Dropdown transientInstance) {
		log.debug("persisting Dropdown instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Dropdown persistentInstance) {
		log.debug("removing Dropdown instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Dropdown merge(Dropdown detachedInstance) {
		log.debug("merging Dropdown instance");
		try {
			Dropdown result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Dropdown findById(BigDecimal id) {
		log.debug("getting Dropdown instance with id: " + id);
		try {
			Dropdown instance = entityManager.find(Dropdown.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Dropdown> findByName(String ddName){
		Query query;
		try {
			query = entityManager.createQuery("SELECT e FROM Dropdown e WHERE e.ddName=:ddName AND e.ddActive='YES'");
			query.setParameter("ddName", ddName);
			
			return (List<Dropdown>) query.getResultList();
		}catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
}
