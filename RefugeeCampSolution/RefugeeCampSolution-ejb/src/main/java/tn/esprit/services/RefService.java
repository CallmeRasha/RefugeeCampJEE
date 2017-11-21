package tn.esprit.services;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tn.esprit.persistence.JobContract;
import tn.esprit.persistence.JobOffer;
import tn.esprit.persistence.Refug;

/**
 * Session Bean implementation class RefService
 */
@Stateless
public class RefService implements RefServiceRemote, RefServiceLocal {

    /**
     * Default constructor. 
     */
	@EJB
	RefServiceLocal reflocal;
	
	@EJB
	JobOfferServiceLocal offerLocal;
	
	@PersistenceContext
	private EntityManager entityManager;
	
    public RefService() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public List<Refug> getAllRefugees() {
		Query query = entityManager.createQuery("select p from Refug p");
		List<Refug> Refugee = query.getResultList();
		return Refugee;
	}

	@Override
	public void Affect(int refugID, int id) {
		// TODO Auto-generated method stub
		
	}

}
