package com.gestion.blanchiment.entities;




import javax.persistence.*;








/**
 * The persistent class for the user database table.
 * 
 */
@Entity
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	private String email;

	private Boolean enabled;

	@Column(name="first_name")
	private String firstName;

	private Boolean isdeleted;

	@Column(name="last_name")
	private String lastName;

	@Column(name="last_password")
	private String lastPassword;


	private String password;

	@Column(name="phone_number")
	private Long phoneNumber;

	private String username;
	 
	
	 @ManyToOne
	private Authority authority;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public Boolean getIsdeleted() {
		return isdeleted;
	}

	public void setIsdeleted(Boolean isdeleted) {
		this.isdeleted = isdeleted;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getLastPassword() {
		return lastPassword;
	}

	public void setLastPassword(String lastPassword) {
		this.lastPassword = lastPassword;
	}


	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	

	


	public Authority getAuthority() {
		return authority;
	}

	public void setAuthority(Authority authority) {
		this.authority = authority;
	}

	public User(Long id, String email, Boolean enabled, String firstName, Boolean isdeleted, String lastName,
			String lastPassword, String password, Long phoneNumber, String username,
			 Authority authority) {
		super();
		this.id = id;
		this.email = email;
		this.enabled = enabled;
		this.firstName = firstName;
		this.isdeleted = isdeleted;
		this.lastName = lastName;
		this.lastPassword = lastPassword;
		this.password = password;
		this.phoneNumber = phoneNumber;
		this.username = username;
		this.authority = authority;
	}

	public User() {
		super();
	}




	 
	 
	}