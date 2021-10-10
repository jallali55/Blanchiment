package com.gestion.blanchiment.dto;




public class PersonneMoraleDto {
	private Integer id_pays;
	private String tel ;
	private String mobile ;
	private String email ;
	private String fax ;
	private String raisonSocial;
	private String numeroFiscal;
	private String numeroDocumentFiscal;
	private String formeJuridique;
	private String raisonEconomique;
	public Integer getId_pays() {
		return id_pays;
	}
	public void setId_pays(Integer id_pays) {
		this.id_pays = id_pays;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}
	public String getRaisonSocial() {
		return raisonSocial;
	}
	public void setRaisonSocial(String raisonSocial) {
		this.raisonSocial = raisonSocial;
	}
	public String getNumeroFiscal() {
		return numeroFiscal;
	}
	public void setNumeroFiscal(String numeroFiscal) {
		this.numeroFiscal = numeroFiscal;
	}
	public String getNumeroDocumentFiscal() {
		return numeroDocumentFiscal;
	}
	public void setNumeroDocumentFiscal(String numeroDocumentFiscal) {
		this.numeroDocumentFiscal = numeroDocumentFiscal;
	}
	public String getFormeJuridique() {
		return formeJuridique;
	}
	public void setFormeJuridique(String formeJuridique) {
		this.formeJuridique = formeJuridique;
	}
	public String getRaisonEconomique() {
		return raisonEconomique;
	}
	public void setRaisonEconomique(String raisonEconomique) {
		this.raisonEconomique = raisonEconomique;
	}
	public PersonneMoraleDto(Integer id_pays, String tel, String mobile, String email, String fax, String raisonSocial,
			String numeroFiscal, String numeroDocumentFiscal, String formeJuridique, String raisonEconomique) {
		super();
		this.id_pays = id_pays;
		this.tel = tel;
		this.mobile = mobile;
		this.email = email;
		this.fax = fax;
		this.raisonSocial = raisonSocial;
		this.numeroFiscal = numeroFiscal;
		this.numeroDocumentFiscal = numeroDocumentFiscal;
		this.formeJuridique = formeJuridique;
		this.raisonEconomique = raisonEconomique;
	}
	public PersonneMoraleDto() {
		super();
	}
	
	
	
		







	
}
