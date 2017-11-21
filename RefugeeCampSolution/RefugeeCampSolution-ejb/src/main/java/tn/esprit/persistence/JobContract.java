package tn.esprit.persistence;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: JobContract
 *
 */

@Entity
@Table(name="JobContracts")
public class JobContract implements Serializable {

	@EmbeddedId
	private JobContractPK id;
		
	@Column(name="Salary")
	private String salary;
	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name="JobOfferID", insertable = false, updatable = false)
	private JobOffer jobOffer;
	
	@ManyToOne
	@JoinColumn(name="RefugID", insertable = false, updatable = false)
	private Refug refug;

	public JobContract() {
		super();
	}   
	public String getSalary() {
		return this.salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}
	public JobContract( String salary, int jobOffer, int refug) {
		
		this.salary = salary;
		this.getId().setJobOfferID(jobOffer);
		this.getId().setRefugID(refug);
	
	}
	
	public JobContractPK getId() {
		return id;
	}
	public void setId(JobContractPK id) {
		this.id = id;
	}
	public JobOffer getJobOffer() {
		return jobOffer;
	}
	public void setJobOffer(JobOffer jobOffer) {
		this.jobOffer = jobOffer;
	}
	public Refug getRefug() {
		return refug;
	}
	public void setRefug(Refug refug) {
		this.refug = refug;
	}
	
}
