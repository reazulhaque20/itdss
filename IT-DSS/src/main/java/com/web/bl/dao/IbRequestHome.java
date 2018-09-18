package com.web.bl.dao;
// Generated Jun 12, 2018 12:23:17 PM by Hibernate Tools 4.3.5.Final

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;

import com.web.bl.model.IbRequest;

/**
 * Home object for domain model class IbRequest.
 * @see com.web.bl.gen.IbRequest
 * @author Hibernate Tools
 */
@Repository
@Transactional
public class IbRequestHome {

	private static final Log log = LogFactory.getLog(IbRequestHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(IbRequest transientInstance) {
		log.debug("persisting IbRequest instance");
		try {
			transientInstance.setIbRequestId(getibRequestID());
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(IbRequest persistentInstance) {
		log.debug("removing IbRequest instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public IbRequest merge(IbRequest detachedInstance) {
		log.debug("merging IbRequest instance");
		try {
			IbRequest result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}
	
	public BigDecimal getibRequestID() {
		Query query;
		try {
			query = entityManager.createNativeQuery("select IB_REQUEST_SEQ.nextval from dual");
			BigDecimal ibRequestID = (BigDecimal) query.getSingleResult();
			return ibRequestID;
		}catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public IbRequest findById(BigDecimal id) {
		log.debug("getting IbRequest instance with id: " + id);
		try {
			IbRequest instance = entityManager.find(IbRequest.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<IbRequest> findAllOpenIbRequest(){
		
		Query query;
		try {
			query = entityManager.createQuery("SELECT e FROM IbRequest e WHERE e.status='Open'");
			
			return (List<IbRequest>) query.getResultList();
		}catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<IbRequest> findByDateRange(Date startDate, Date endDate){
		Query query;
		try {
			query = entityManager.createQuery("SELECT e FROM IbRequest e where e.createdDate BETWEEN :startDate AND :endDate");
			query.setParameter("startDate", startDate);
			query.setParameter("endDate", endDate);
			return (List<IbRequest>) query.getResultList();
		}catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
	
	
	@SuppressWarnings("unchecked")
	public List<IbRequest> findByDateRangeandMsisdn(Date startDate, Date endDate, String msisdn){
		Query query;
		try {
			query = entityManager.createQuery("SELECT e FROM IbRequest e where e.createdDate BETWEEN :startDate AND :endDate and e.msisdn=:msisdn");
			query.setParameter("startDate", startDate);
			query.setParameter("endDate", endDate);
			query.setParameter("msisdn", msisdn);
			
			return (List<IbRequest>) query.getResultList();
		}catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<IbRequest> findByDateRangeAndStatus(Date startDate, Date endDate, String status){
		Query query;
		try {
			query = entityManager.createQuery("SELECT e FROM IbRequest e WHERE e.createdDate BETWEEN :startDate AND :endDate AND e.status=:status");
			query.setParameter("startDate", startDate);
			query.setParameter("endDate", endDate);
			query.setParameter("status", status);
			
			return (List<IbRequest>) query.getResultList();
		}catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<IbRequest> findByDatRangeAndMsisdnAndStatus(Date startDate, Date endDate, String msisdn, String status){
		Query query;
		try {
			query = entityManager.createQuery("SELECT e FROM IbRequest e WHERE e.createdDate BETWEEN :startDate AND :endDate AND e.msisdn=:msisdn AND e.status=:status");
			query.setParameter("startDate", startDate);
			query.setParameter("endDate", endDate);
			query.setParameter("msisdn", msisdn);
			query.setParameter("status", status);
			
			return (List<IbRequest>) query.getResultList();
		}catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
}
