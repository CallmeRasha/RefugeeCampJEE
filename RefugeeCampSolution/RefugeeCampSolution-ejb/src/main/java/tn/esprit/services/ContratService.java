package tn.esprit.services;

import java.util.logging.Logger;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import tn.esprit.persistence.JobContract;
import tn.esprit.persistence.JobOffer;
import tn.esprit.persistence.Refug;

/**
 * Session Bean implementation class ContratService
 */
@Stateless
public class ContratService implements ContratServiceRemote, ContratServiceLocal {

    /**
     * Default constructor. 
     */
    public ContratService() {
        // TODO Auto-generated constructor stub
    }
    
    @PersistenceContext
	private EntityManager entityManager;
	
	
	
	@Override
	public void saveOrupdate(JobContract a) {
		
		entityManager.merge(a);
		
	}

	@Override
	public void deleteRefug(JobContract Adoption) {
		
		entityManager.remove(entityManager.merge(Adoption));
		
	}
	

	@Override
	public List<JobContract> GetAllJobContracts() {
		
		
		List<JobContract> found =null; 
		String jpql= " select u from JobContract u";
		TypedQuery<JobContract> query = entityManager.createQuery(jpql, JobContract.class);
		try {
			found = query.getResultList();
		} catch (Exception ex) {
			Logger.getLogger(ContratService.class.getName());}
		return found;
		
	}
	@Override
	public void CreateContrat( String salary, int jobOffer, int refug){
		JobContract cont = new JobContract(salary, jobOffer, refug);

		entityManager.merge(cont);
	}
	@Override
	public void CreateContratAkram(JobContract jb){
		

		entityManager.merge(jb);
	}

}
