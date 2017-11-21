package tn.esprit.persistence;

import java.io.Serializable;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: JobOffer
 *
 */
@Entity
@Table(name="JobOffers")
public class JobOffer implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="JobOfferID")
	private int id;
	
	@Column(name="SkillNeeded")
	private String skillNeeded;
		
	@Column(name="Description")
	private String description;
	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name="PartnerID", insertable = false, updatable = false)
	private Partner partner;

	@OneToMany(mappedBy="jobOffer")
	private List<JobContract> jobContract;

	public JobOffer() {
		super();
	}  
	public Partner getPartner() {
		return partner;
	}
	public void setPartner(Partner partner) {
		this.partner = partner;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSkillNeeded() {
		return skillNeeded;
	}
	public void setSkillNeeded(String skillNeeded) {
		this.skillNeeded = skillNeeded;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<JobContract> getJobContract() {
		return jobContract;
	}
	public void setJobContract(List<JobContract> jobContract) {
		this.jobContract = jobContract;
	}
   
}
