package com.web.bl.dao;
// Generated May 27, 2018 2:03:08 PM by Hibernate Tools 4.3.5.Final

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

import com.web.bl.model.CustomersEmailAddress;

/**
 * Home object for domain model class CustomersEmailAddress.
 * @see com.web.bl.model.CustomersEmailAddress
 * @author Hibernate Tools
 */
@Repository
@Transactional
public class CustomersEmailAddressHome {

	private static final Log log = LogFactory.getLog(CustomersEmailAddressHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(CustomersEmailAddress transientInstance) {
		log.debug("persisting CustomersEmailAddress instance");
		try {
			transientInstance.setCeaId(getCustomersEmailAddressID());
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(CustomersEmailAddress persistentInstance) {
		log.debug("removing CustomersEmailAddress instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public CustomersEmailAddress merge(CustomersEmailAddress detachedInstance) {
		log.debug("merging CustomersEmailAddress instance");
		try {
			CustomersEmailAddress result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public CustomersEmailAddress findById(BigDecimal id) {
		log.debug("getting CustomersEmailAddress instance with id: " + id);
		try {
			CustomersEmailAddress instance = entityManager.find(CustomersEmailAddress.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
	
	public BigDecimal getCustomersEmailAddressID() {
		Query query;
		try {
			query = entityManager.createNativeQuery("select CUST_EMAIL_SEQ.nextval from dual");
			BigDecimal usersId = (BigDecimal) query.getSingleResult();
			return usersId;
		}catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
	
	public CustomersEmailAddress findByMsisdn(String msisdn) {
		Query query;
		try {
			query = entityManager.createQuery("SELECT e FROM CustomersEmailAddress e WHERE e.customers.msisdn=:msisdn");
			query.setParameter("msisdn", msisdn);
			return (CustomersEmailAddress) query.getSingleResult();
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<CustomersEmailAddress> findAllOpenStatusResuest(){
		Query query;
		try {
			query = entityManager.createQuery("SELECT e FROM CustomersEmailAddress e where e.isapproved='Open'");
			
			return (List<CustomersEmailAddress>)query.getResultList();
		}catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<CustomersEmailAddress> findAllNotVerifiedCustomers() {
		Query query;
		
		try {
			query = entityManager.createQuery("SELECT e FROM CustomersEmailAddress e WHERE e.isverified in ('NO') OR  e.isverified is null");
			
			return query.getResultList();
		}catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
	
	public CustomersEmailAddress findBySecretAndMailAddress(String secret, String email) {
		Query query;
		try {
			query = entityManager.createQuery("SELECT e FROM CustomersEmailAddress e WHERE e.emailAddress=:email");
//			query.setParameter("secret", secret);
			query.setParameter("email", email);
			
			return (CustomersEmailAddress) query.getSingleResult();
		}catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
	
	public CustomersEmailAddress findByClientMsisdnEmail(String client, String msisdn, String mail) {
		Query query;
		try {
			query = entityManager.createQuery("SELECT e FROM CustomersEmailAddress e WHERE e.customers.msisdn=:msisdn AND e.customers.customerSecret=:client AND e.emailAddress=:mail");
			query.setParameter("msisdn", msisdn);
			query.setParameter("client", client);
			query.setParameter("mail", mail);
			
			return (CustomersEmailAddress) query.getSingleResult();
		}catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<CustomersEmailAddress> findByDateRangeAndMsisdn(Date startDate, Date endDate, String msisdn){
		Query query;
		try {
			query = entityManager.createQuery("SELECT e FROM CustomersEmailAddress e WHERE e.updateddate BETWEEN :startDate AND :endDate AND e.customers.msisdn=:msisdn");
			query.setParameter("startDate", startDate);
			query.setParameter("endDate", endDate);
			query.setParameter("msisdn", msisdn);
			
			return (List<CustomersEmailAddress>) query.getResultList();
		}catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<CustomersEmailAddress> findByDateRangeAndEmailAddress(Date startDate, Date endDate, String emailAddress){
		Query query;
		try {
			query = entityManager.createQuery("SELECT e FROM CustomersEmailAddress e WHERE e.updateddate BETWEEN :startDate AND :endDate AND e.emailAddress=:emailAddress");
			query.setParameter("startDate", startDate);
			query.setParameter("endDate", endDate);
			query.setParameter("emailAddress", emailAddress);
			
			return (List<CustomersEmailAddress>) query.getResultList();
		}catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<CustomersEmailAddress> findByDateRange(Date startDate, Date endDate){
		Query query;
		try {
			query = entityManager.createQuery("SELECT e FROM CustomersEmailAddress e WHERE e.updateddate BETWEEN :startDate AND :endDate");
			query.setParameter("startDate", startDate);
			query.setParameter("endDate", endDate);
			
			return (List<CustomersEmailAddress>) query.getResultList();
		}catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<CustomersEmailAddress> findByDateRangeAndVerificationStatus(Date startDate, Date endDate, String verificatiionStatus){
		Query query;
		try {
			query = entityManager.createQuery("SELECT e FROM CustomersEmailAddress e WHERE e.updateddate BETWEEN :startDate AND :endDate AND e.isverified=:verificatiionStatus");
			query.setParameter("startDate", startDate);
			query.setParameter("endDate", endDate);
			query.setParameter("verificatiionStatus", verificatiionStatus);
			
			return (List<CustomersEmailAddress>) query.getResultList();
		}catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<CustomersEmailAddress> findByListEmailAddress(String emailAddress){
		Query query;
		try {
			query = entityManager.createQuery("SELECT e FROM CustomersEmailAddress e WHERE e.emailAddress=:emailAddress");
			query.setParameter("emailAddress", emailAddress);
			return (List<CustomersEmailAddress>) query.getResultList();
		}catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
	
	public CustomersEmailAddress findByEmailAddress(String emailAddress){
		Query query;
		try {
			query = entityManager.createQuery("SELECT e FROM CustomersEmailAddress e WHERE e.emailAddress=:emailAddress");
			query.setParameter("emailAddress", emailAddress);
			return (CustomersEmailAddress) query.getSingleResult();
		}catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
}
