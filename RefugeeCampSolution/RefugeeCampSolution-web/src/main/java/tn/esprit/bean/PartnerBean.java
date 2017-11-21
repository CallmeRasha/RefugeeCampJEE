package tn.esprit.bean;


import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;

import tn.esprit.persistence.Partner;
import tn.esprit.services.PartnerServiceLocal;

@ManagedBean
@ViewScoped
public class PartnerBean {
	
	@EJB
	private PartnerServiceLocal par;
	
	private Partner partner;
	private List<Partner> partners= new ArrayList<>();
	
	private Partner partnerselected;

	private Boolean formList = true;
	private Boolean formEdit = false;
	private Boolean formDetails = false;
	
	public Partner getPartner() {
		return partner;
	}

	public void setPartner(Partner partner) {
		this.partner = partner;
	}


	public List<Partner> getPartners() {
		return partners;
	}


	public void setPartners(List<Partner> partners) {
		this.partners = partners;
	}


	public Partner getPartnerselected() {
		return partnerselected;
	}


	public void setPartnerselected(Partner partnerselected) {
		this.partnerselected = partnerselected;
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
	
	public PartnerServiceLocal getPar() {
		return par;
	}

	public void setPar(PartnerServiceLocal par) {
		this.par = par;
	}


	public PartnerBean(PartnerServiceLocal par, Partner partner, List<Partner> partners,
			Partner partnerselected, Boolean formList, Boolean formEdit, Boolean formDetails) {
		super();
		this.par = par;
		this.partner = partner;
		this.partners = partners;
		this.partnerselected = partnerselected;
		this.formList = formList;
		this.formEdit = formEdit;
		this.formDetails = formDetails;
	}

	@PostConstruct
	public void init() {
		partner = new Partner();
		//partnerselected=new Partner();
		partners=par.getAllPartners();
	}
	
	public PartnerBean() {
		super();
		// TODO Auto-generated constructor stub
	}


	public String doAddOrSavepartners() {
		
		try {
		       String gRecaptchaResponse = FacesContext.getCurrentInstance().
		       getExternalContext().getRequestParameterMap().get("g-recaptcha-response");
		       boolean verify = VerifyRecaptcha.verify(gRecaptchaResponse);
		       if(verify){
		    	 partner.setStatus("nottreated");
		    	   par.addPartner(partner);
		            return "Success";
		       }else{
		            FacesContext context = FacesContext.getCurrentInstance();
		            context.addMessage( null, new FacesMessage( "Select Captcha") );
		            return null;
		         }
		        } catch (Exception e) {
		            System.out.println(e);
		        }
		partners = par.getAllPartners();
		//par.addPartner(partner);
		//partner.getStatus();
		
	return "/PartnerView/ListOfPartners?faces-redirect=true";

	}
	
	public String doDeletePartners(Partner Partner) {
		par.deletePart(Partner);
		setPartners(par.getAllPartners());
		//return "/pages/affichesponors?faces-redirect=true";
		return null;

	}
	
	public String selectEditPartners(Partner partner) {
		this.partnerselected = partner;
		formEdit = true;
		formList = false;
		formDetails = false;

		return null;
		

	}
			
	public String doAddOrSavePartnersEdit() {
	
	par.updatePartner(partnerselected);

	formEdit = false;
	formList = true;
	partners = par.getAllPartners();
	//return "/pages/affichesponors?faces-redirect=true";
	return null;
				
		}
	
	public String submit_form(){
        try {
       String gRecaptchaResponse = FacesContext.getCurrentInstance().
       getExternalContext().getRequestParameterMap().get("g-recaptcha-response");
       boolean verify = VerifyRecaptcha.verify(gRecaptchaResponse);
       if(verify){
            return "Success";
       }else{
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage( null, new FacesMessage( "Select Captcha") );
            return null;
         }
        } catch (Exception e) {
            System.out.println(e);
        }
       return null;
    }    
	 
	public void traiter(Partner p){
		this.partnerselected=p;
		partnerselected.setStatus("traitee");
		par.updatePartner(partnerselected);
		par.getAllPartners();
	}
	
	public void submit() {
		System.out.println("Your email: " +partner.getEmail()+"is valid");
		// Set the message here
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Email is OK", "ok");  
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}
	
	public List<Partner> rechercherAllPartnersByCompany() {
		List<Partner> lstPartnersByCompany = par.rechercherAllPartnersByCompany(partner.getCompany());
		if (lstPartnersByCompany.isEmpty()) {
			return null;
		} else {
			return lstPartnersByCompany;
		}
	}
	
	public String gohome(){
		formDetails=false;
		formEdit=false;
		formList=true;
		return null;
	}
	
//alltraining = trainingLocal.rechercheralltrainings();
	
	/*
	public String upload() throws IOException {
        InputStream inputStream = uploadedFile.getInputStream();       
       FileOutputStream outputStream = new FileOutputStream(getFilename(uploadedFile));
        
       byte[] buffer = new byte[4096];       
       int bytesRead = 0;
       while(true) {                       
           bytesRead = inputStream.read(buffer);
           if(bytesRead > 0) {
               outputStream.write(buffer, 0, bytesRead);
           }else {
               break;
           }                      
       }
       outputStream.close();
       inputStream.close();
       
       return "success";
   }

   private static String getFilename(Part part) {
       for (String cd : part.getHeader("content-disposition").split(";")) {
           if (cd.trim().startsWith("filename")) {
               String filename = cd.substring(cd.indexOf('=') + 1).trim().replace("\"", "");
               return filename.substring(filename.lastIndexOf('/') + 1).substring(filename.lastIndexOf('\\') + 1); // MSIE fix.
           }
       }
       return null;
   }
   */
	
}
