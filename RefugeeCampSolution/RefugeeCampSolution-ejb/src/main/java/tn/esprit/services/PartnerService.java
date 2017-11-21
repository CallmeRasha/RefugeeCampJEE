package tn.esprit.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import tn.esprit.persistence.Partner;

/**
 * Session Bean implementation class PartnerService
 */
@Stateless
public class PartnerService implements PartnerServiceRemote, PartnerServiceLocal {

	@PersistenceContext
	private EntityManager em;
	
    /**
     * Default constructor. 
     */
    public PartnerService() {
    }

	@Override
	public int addPartner(Partner p) {
		em.persist(p);
		return p.getPartnerID();
	}

	@Override
	public void updatePartner(Partner p) {
		em.merge(p);
		
	}

	@Override
	public void deletePartner(int partnerID) {
		em.remove(em.find(Partner.class, partnerID));
		
	}

	@Override
	public Partner findPartnerById(int partnerID) {
		Partner p= em.find(Partner.class, partnerID);
		return p;
	}

	@Override
	public List<Partner> getAllPartners() {
		Query query = em.createQuery("select p from Partner p");
		List<Partner> partners = query.getResultList();
		return partners;
	}

	@Override
	public void deletePart(Partner partner) {
		em.remove(em.merge(partner));	
	}
	
	@Override
	public List<Partner> rechercherAllPartnersByCompany(String company) {
		TypedQuery<Partner> querry = em.createQuery("Select t from Partner t where t.company =:company",Partner.class);
		querry.setParameter("company", company);
		return querry.getResultList();
	}

}
