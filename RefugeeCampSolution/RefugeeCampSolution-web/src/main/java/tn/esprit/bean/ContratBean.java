package tn.esprit.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.SessionScoped;

import tn.esprit.persistence.JobContract;
import tn.esprit.persistence.Refug;
import tn.esprit.services.ContratServiceLocal;

@ManagedBean(name="contratBean")
@ViewScoped
public class ContratBean {

	public ContratBean() {
		// TODO Auto-generated constructor stub
	}
	
	@EJB
	private ContratServiceLocal contratServicesLocal;
		
		public JobContract contrat = new JobContract();
		private List<JobContract> jobContracts ;
		private Refug refugSelected= new Refug();
			
		public ContratServiceLocal getContratServicesLocal() {
			return contratServicesLocal;
		}

		public void setContratServicesLocal(ContratServiceLocal contratServicesLocal) {
			this.contratServicesLocal = contratServicesLocal;
		}

		public JobContract getContrat() {
			return contrat;
		}

		public void setContrat(JobContract contrat) {
			this.contrat = contrat;
		}

		public List<JobContract> getJobContracts() {
			return jobContracts;
		}

		public void setJobContracts(List<JobContract> jobContracts) {
			this.jobContracts = jobContracts;
		}

		public Refug getRefugSelected() {
			return refugSelected;
		}

		public void setRefugSelected(Refug refugSelected) {
			this.refugSelected = refugSelected;
		}

		@PostConstruct
		public void init() {
			 jobContracts = contratServicesLocal.GetAllJobContracts();
		}
		
	  public String CreateJobContrat()
	  {
			
			contratServicesLocal.CreateContrat("eeeee", 2, 3);
			System.out.println("work?");
		  return "JobOfferView/Contrat?faces-redirect=true";
		  
		}
		

}
