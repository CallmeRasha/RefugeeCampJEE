package tn.esprit.services;

import java.util.List;

import javax.ejb.Local;

import tn.esprit.persistence.Refug;

@Local
public interface RefServiceLocal {
	
	public List<Refug> getAllRefugees();
	public void Affect(int refugID, int id);

}
