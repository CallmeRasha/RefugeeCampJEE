package tn.esprit.services;

import java.util.List;

import javax.ejb.Local;

import tn.esprit.persistence.JobOffer;

@Local
public interface JobOfferServiceLocal {
	
	public int addJobOffer(JobOffer p);
	public void updateJobOffer(JobOffer p);
	public void deleteJobOffer(int id);
	
	public void deleteJobOffer(JobOffer jobOffer);
	public JobOffer findJobOfferById(int id);
	public List<JobOffer> getAllJobOffer();

}
