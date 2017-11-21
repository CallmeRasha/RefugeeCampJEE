package tn.esprit.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tn.esprit.persistence.JobOffer;
import tn.esprit.persistence.Partner;

/**
 * Session Bean implementation class JobOfferService
 */
@Stateless
public class JobOfferService implements JobOfferServiceRemote, JobOfferServiceLocal {

    /**
     * Default constructor. 
     */
	
	@PersistenceContext
	private EntityManager em;
	
    public JobOfferService() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public int addJobOffer(JobOffer p) {
		em.persist(p);
		return p.getId();
	}

	@Override
	public void updateJobOffer(JobOffer p) {
		em.merge(p);		
	}

	@Override
	public void deleteJobOffer(int id) {
		em.remove(em.find(JobOffer.class, id));
		
	}

	@Override
	public void deleteJobOffer(JobOffer jobOffer) {
		em.remove(em.merge(jobOffer));		
	}

	@Override
	public JobOffer findJobOfferById(int id) {
		JobOffer p= em.find(JobOffer.class, id);
		return p;
	}

	@Override
	public List<JobOffer> getAllJobOffer() {
		Query query = em.createQuery("select p from JobOffer p");
		List<JobOffer> jobOffers = query.getResultList();
		return jobOffers;
	}
}
