package tn.esprit.services;
import java.util.List;
import javax.ejb.Local;
import tn.esprit.persistence.Partner;

@Local
public interface PartnerServiceLocal {
	
	public int addPartner(Partner p);
	public void updatePartner(Partner p);
	public void deletePartner(int partnerID);
	
	public void deletePart(Partner partner);
	public Partner findPartnerById(int partnerID);
	public List<Partner> getAllPartners();
	public List<Partner> rechercherAllPartnersByCompany(String company);

}