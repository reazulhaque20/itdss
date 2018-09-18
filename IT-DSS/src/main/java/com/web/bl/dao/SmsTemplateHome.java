package com.web.bl.dao;
// Generated Aug 6, 2018 4:16:58 PM by Hibernate Tools 4.3.5.Final

import java.math.BigDecimal;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.web.bl.model.SmsTemplate;

/**
 * Home object for domain model class SmsTemplate.
 * @see com.web.bl.gen.SmsTemplate
 * @author Hibernate Tools
 */
@Repository
@Transactional
public class SmsTemplateHome {

	private static final Log log = LogFactory.getLog(SmsTemplateHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(SmsTemplate transientInstance) {
		log.debug("persisting SmsTemplate instance");
		try {
			transientInstance.setSmsTmplId(getSmsTemplateId());
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(SmsTemplate persistentInstance) {
		log.debug("removing SmsTemplate instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public SmsTemplate merge(SmsTemplate detachedInstance) {
		log.debug("merging SmsTemplate instance");
		try {
			SmsTemplate result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public SmsTemplate findById(BigDecimal id) {
		log.debug("getting SmsTemplate instance with id: " + id);
		try {
			SmsTemplate instance = entityManager.find(SmsTemplate.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
	
	public BigDecimal getSmsTemplateId() {
		Query query;
		try {
			query = entityManager.createNativeQuery("select SMS_TEMPL_SEQ.nextval from dual");
			BigDecimal smsTemplID = (BigDecimal) query.getSingleResult();
			return smsTemplID;
		}catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
}
