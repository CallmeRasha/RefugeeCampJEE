package tn.esprit.services;

import java.util.List;

import javax.ejb.Local;

import tn.esprit.persistence.JobContract;

@Local
public interface ContratServiceLocal {
	
	public void saveOrupdate(JobContract a);
	public void deleteRefug(JobContract Adoption);
	public List<JobContract> GetAllJobContracts();
	public void CreateContrat( String salary, int jobOffer, int refug);
	public void CreateContratAkram(JobContract jb);

}
