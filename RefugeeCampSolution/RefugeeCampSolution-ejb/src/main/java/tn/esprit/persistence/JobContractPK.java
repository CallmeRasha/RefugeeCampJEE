package tn.esprit.persistence;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: JobContractPK
 *
 */

@Embeddable
public class JobContractPK implements Serializable {

	@Column(name="RefugID")
	private int refugID;
	
	@Column(name="JobOfferID")
	private int jobOfferID;
	private static final long serialVersionUID = 1L;

	public JobContractPK() {
		super();
	}   
	public int getRefugID() {
		return this.refugID;
	}

	public void setRefugID(int RefugID) {
		this.refugID = RefugID;
	}   
	public int getJobOfferID() {
		return this.jobOfferID;
	}

	public void setJobOfferID(int JobOfferID) {
		this.jobOfferID = JobOfferID;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + jobOfferID;
		result = prime * result + refugID;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		JobContractPK other = (JobContractPK) obj;
		if (jobOfferID != other.jobOfferID)
			return false;
		if (refugID != other.refugID)
			return false;
		return true;
	}
   
}
