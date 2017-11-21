package tn.esprit.services;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.persistence.JobOffer;

@Remote
public interface JobOfferServiceRemote {
	
	public int addJobOffer(JobOffer p);
	public void updateJobOffer(JobOffer p);
	public void deleteJobOffer(int id);
	
	public void deleteJobOffer(JobOffer jobOffer);
	public JobOffer findJobOfferById(int id);
	public List<JobOffer> getAllJobOffer();

}
