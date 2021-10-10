package com.gestion.blanchiment.dto;




public class Userdto {

    	private String email;
	private String firstName;
	private String lastName;
	private Long phoneNumber;
	private String username;
	private Long authority;
	private boolean isenabled;
	private String password;
	
	public String getEmail() {
	    return email;
	}
	public void setEmail(String email) {
	    this.email = email;
	}
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
	
	public String getUsername() {
	    return username;
	}
	public void setUsername(String username) {
	    this.username = username;
	}
	public Long getPhoneNumber() {
	    return phoneNumber;
	}
	public void setPhoneNumber(Long phoneNumber) {
	    this.phoneNumber = phoneNumber;
	}
	public Long getAuthority() {
	    return authority;
	}
	public void setAuthority(Long authority) {
	    this.authority = authority;
	}

	
	public Userdto(String email, String firstName, String lastName, 
		Long phoneNumber, String username, Long authority) {
	    super();
	    this.email = email;
	    this.firstName = firstName;
	    this.lastName = lastName;
	    this.phoneNumber = phoneNumber;
	    this.username = username;
	    this.authority = authority;
	}
	public boolean isIsenabled() {
		return isenabled;
	}
	public void setIsenabled(boolean isenabled) {
		this.isenabled = isenabled;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
}
