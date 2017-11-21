package tn.esprit.bean;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import tn.esprit.persistence.Refug;
import tn.esprit.services.PartnerServiceLocal;
import tn.esprit.services.RefServiceLocal;



@ManagedBean
@ViewScoped
public class RefBean {

	public RefBean() {
		// TODO Auto-generated constructor stub
	}
	
	@EJB
	private RefServiceLocal ref;
	
	private Refug refug;
	private List<Refug> refugs= new ArrayList<>();
	
	private Refug refugselected;

	public RefServiceLocal getRef() {
		return ref;
	}

	public void setRef(RefServiceLocal ref) {
		this.ref = ref;
	}

	public Refug getRefug() {
		return refug;
	}

	public void setRefug(Refug refug) {
		this.refug = refug;
	}

	public List<Refug> getRefugs() {
		return refugs;
	}

	public void setRefugs(List<Refug> refugs) {
		this.refugs = refugs;
	}

	public Refug getRefugselected() {
		return refugselected;
	}

	public void setRefugselected(Refug refugselected) {
		this.refugselected = refugselected;
	}
	
	

}
