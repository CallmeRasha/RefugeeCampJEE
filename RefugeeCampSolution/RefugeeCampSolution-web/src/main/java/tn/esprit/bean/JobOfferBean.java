package tn.esprit.bean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import tn.esprit.persistence.JobOffer;
import tn.esprit.services.JobOfferServiceLocal;
import tn.esprit.services.PartnerServiceLocal;

@ManagedBean
@ViewScoped
public class JobOfferBean {

	@EJB
	private JobOfferServiceLocal job;

	@EJB
	private PartnerServiceLocal partLoca;

	//@ManagedProperty(value = "#{PartnerBean}")
	private PartnerBean partBean;

	private JobOffer joboffer;
	private List<JobOffer> joboffers = new ArrayList<>();

	private JobOffer jobofferselected;

	private Boolean formList = true;
	private Boolean formEdit = false;
	private Boolean formDetails = false;

	@PostConstruct
	public void init() {
		joboffer = new JobOffer();
		partBean = new PartnerBean();
	}

	public PartnerServiceLocal getPartLoca() {
		return partLoca;
	}

	public void setPartLoca(PartnerServiceLocal partLoca) {
		this.partLoca = partLoca;
	}

	public PartnerBean getPartBean() {
		return partBean;
	}

	public void setPartBean(PartnerBean partBean) {
		this.partBean = partBean;
	}

	public JobOfferBean() {
		// TODO Auto-generated constructor stub
	}

	public JobOfferServiceLocal getJob() {
		return job;
	}

	public void setJob(JobOfferServiceLocal job) {
		this.job = job;
	}

	public JobOffer getJoboffer() {
		return joboffer;
	}

	public void setJoboffer(JobOffer joboffer) {
		this.joboffer = joboffer;
	}

	public List<JobOffer> getJoboffers() {
		return joboffers;
	}

	public void setJoboffers(List<JobOffer> joboffers) {
		this.joboffers = joboffers;
	}

	public JobOffer getJobofferselected() {
		return jobofferselected;
	}

	public void setJobofferselected(JobOffer jobofferselected) {
		this.jobofferselected = jobofferselected;
	}

	public Boolean getFormList() {
		return formList;
	}

	public void setFormList(Boolean formList) {
		this.formList = formList;
	}

	public Boolean getFormEdit() {
		return formEdit;
	}

	public void setFormEdit(Boolean formEdit) {
		this.formEdit = formEdit;
	}

	public Boolean getFormDetails() {
		return formDetails;
	}

	public void setFormDetails(Boolean formDetails) {
		this.formDetails = formDetails;
	}

	public JobOfferBean(JobOfferServiceLocal job, JobOffer joboffer, List<JobOffer> joboffers,
			JobOffer jobofferselected, Boolean formList, Boolean formEdit, Boolean formDetails) {
		super();
		this.job = job;
		this.joboffer = joboffer;
		this.joboffers = joboffers;
		this.jobofferselected = jobofferselected;
		this.formList = formList;
		this.formEdit = formEdit;
		this.formDetails = formDetails;
	}

	public String doAddOrSavejoboffers() {
//		joboffer.setPartner(partBean.getPartner());
		job.addJobOffer(joboffer);
		joboffers = job.getAllJobOffer();
		return "added!";

		// return "/PartnerView/ListOfPartners?faces-redirect=true";

	}

	public String doDeleteoffers(JobOffer JobOffer) {
		job.deleteJobOffer(JobOffer);
		setJoboffers(job.getAllJobOffer());
		// return "/pages/affichesponors?faces-redirect=true";
		return null;

	}

	public String selectEditPartners(JobOffer JobOffer) {
		this.jobofferselected = JobOffer;
		formEdit = true;
		formList = false;
		formDetails = false;

		return null;

	}

	public String doAddOrSavePartnersEdit() {

		job.updateJobOffer(jobofferselected);

		formEdit = false;
		formList = true;
		joboffers = job.getAllJobOffer();
		// return "/pages/affichesponors?faces-redirect=true";
		return null;

	}

}
