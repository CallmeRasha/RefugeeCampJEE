package tn.esprit.persistence;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import java.util.List;


/**
 * The persistent class for the Partners database table.
 * 
 */
@Entity
@Table(name="Partners")
public class Partner implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="PartnerID")
	private int partnerID;
	
	@Column(name="FirstName")
	@NotNull (message="Enter your first name")
	private String firstName;
	
	@Column(name="LastName")
	@NotNull (message="Enter your last name")
	private String lastName;
	
	@Column(name="Email")
	@NotNull (message="Enter your e-mail")
	private String email;

	@Column(name="Company")
	@NotNull (message="Enter your company")
	@Size(min = 2, max = 50)
	private String company;
	
	@Column(name="Title")
	@NotNull (message="Enter your CEO's name")
	private String title;
	
	@Column(name="Description")
	@NotNull (message="Enter company's description ")
	private String description;

	@Column(name="PhoneNumber")
	@NotNull (message="Enter your phone nmuber")
	private int phoneNumber;
		
	@Column(name="Status")
	private String status;
	
	//bi-directional many-to-one association to AspNetUser
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="AdminID")
	private AspNetUser aspNetUser;

	//bi-directional many-to-one association to JobOffer
	@OneToMany(mappedBy="partner", cascade=CascadeType.REMOVE)
	private List<JobOffer> jobOffers;

	public Partner() {
	}

	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getStatus() {
		return status;
	}



	public void setStatus(String status) {
		this.status = status;
	}



	public int getPartnerID() {
		return this.partnerID;
	}

	public void setPartnerID(int partnerID) {
		this.partnerID = partnerID;
	}

	
	public int getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	

	/*
	public String getPartnerDoc() {
		return partnerDoc;
	}

	public void setPartnerDoc(String partnerDoc) {
		this.partnerDoc = partnerDoc;
	}
	*/

	public String getFirstName() {
		return firstName;
	}



	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}



	public String getLastName() {
		return lastName;
	}



	public void setLastName(String lastName) {
		this.lastName = lastName;
	}



	public String getCompany() {
		return company;
	}



	public void setCompany(String company) {
		this.company = company;
	}



	public String getTitle() {
		return title;
	}



	public void setTitle(String title) {
		this.title = title;
	}



	public AspNetUser getAspNetUser() {
		return this.aspNetUser;
	}

	public void setAspNetUser(AspNetUser aspNetUser) {
		this.aspNetUser = aspNetUser;
	}

	public List<JobOffer> getJobOffers() {
		return this.jobOffers;
	}

	public void setJobOffers(List<JobOffer> jobOffers) {
		this.jobOffers = jobOffers;
	}

	public JobOffer addJobOffer(JobOffer jobOffer) {
		getJobOffers().add(jobOffer);
		jobOffer.setPartner(this);

		return jobOffer;
	}

	public JobOffer removeJobOffer(JobOffer jobOffer) {
		getJobOffers().remove(jobOffer);
		jobOffer.setPartner(null);

		return jobOffer;
	}



	public Partner(String firstName, String lastName, String email, String password, String company, String title,
			String description, int phoneNumber, String status) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		//this.password = password;
		this.company = company;
		this.title = title;
		this.description = description;
		this.phoneNumber = phoneNumber;
		this.status = status;
	}
	
	

}