package tn.esprit.services;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.persistence.Refug;

@Remote
public interface RefServiceRemote {
	
	public List<Refug> getAllRefugees();
	public void Affect(int refugID, int id);

}
