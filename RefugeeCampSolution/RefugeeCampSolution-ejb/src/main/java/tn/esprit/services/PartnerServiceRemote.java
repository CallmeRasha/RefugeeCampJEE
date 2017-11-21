package tn.esprit.services;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.persistence.Partner;

@Remote
public interface PartnerServiceRemote {
	
	public int addPartner(Partner p);
	public void updatePartner(Partner p);
	public void deletePartner(int partnerID);
	
	public void deletePart(Partner partner);
	public Partner findPartnerById(int partnerID);
	public List<Partner> getAllPartners();

}
