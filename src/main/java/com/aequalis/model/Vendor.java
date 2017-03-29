/**
 * 
 */
package com.aequalis.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * @author leoanbarasanm
 *
 */
@Entity
@Table(name="vendors")
public class Vendor implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long vendorid;

	@Column(name = "vendorname")
	private String vendorname;

	@Column(name = "description")
	private String description;
	
	@Column(name = "contactnumber")
	private String contactnumber;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "website")
	private String website;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "bcaddress")
	private String bcaddress;
	
	@Column(name = "storepercentage")
	private Double storepercentage;
	
	@Column(name = "customerpercentage")
	private Double customerpercentage;
	
//	@Column(name = "scintillapercentage")
//	private Double scintillapercentage;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "typeid")
	private Type type;
	
	@Transient
	private String balance;

	/**
	 * @return the vendorid
	 */
	public Long getVendorid() {
		return vendorid;
	}

	/**
	 * @param vendorid the vendorid to set
	 */
	public void setVendorid(Long vendorid) {
		this.vendorid = vendorid;
	}

	/**
	 * @return the vendorname
	 */
	public String getVendorname() {
		return vendorname;
	}
	

	/**
	 * @return the balance
	 */
	public String getBalance() {
		return balance;
	}

	/**
	 * @param balance the balance to set
	 */
	public void setBalance(String balance) {
		this.balance = balance;
	}

	/**
	 * @param vendorname the vendorname to set
	 */
	public void setVendorname(String vendorname) {
		this.vendorname = vendorname;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the contactnumber
	 */
	public String getContactnumber() {
		return contactnumber;
	}

	/**
	 * @param contactnumber the contactnumber to set
	 */
	public void setContactnumber(String contactnumber) {
		this.contactnumber = contactnumber;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the website
	 */
	public String getWebsite() {
		return website;
	}

	/**
	 * @param website the website to set
	 */
	public void setWebsite(String website) {
		this.website = website;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the bcaddress
	 */
	public String getBcaddress() {
		return bcaddress;
	}

	/**
	 * @param bcaddress the bcaddress to set
	 */
	public void setBcaddress(String bcaddress) {
		this.bcaddress = bcaddress;
	}

	/**
	 * @return the storepercentage
	 */
	public Double getStorepercentage() {
		return storepercentage;
	}

	/**
	 * @param storepercentage the storepercentage to set
	 */
	public void setStorepercentage(Double storepercentage) {
		this.storepercentage = storepercentage;
	}

	/**
	 * @return the customerpercentage
	 */
	public Double getCustomerpercentage() {
		return customerpercentage;
	}

	/**
	 * @param customerpercentage the customerpercentage to set
	 */
	public void setCustomerpercentage(Double customerpercentage) {
		this.customerpercentage = customerpercentage;
	}


	/**
	 * @return the type
	 */
	public Type getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(Type type) {
		this.type = type;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Vendor [vendorid=" + vendorid + ", vendorname=" + vendorname + ", description=" + description
				+ ", contactnumber=" + contactnumber + ", email=" + email + ", website=" + website + ", address="
				+ address + ", bcaddress=" + bcaddress + ", storepercentage=" + storepercentage
				+ ", customerpercentage=" + customerpercentage + ", type=" + type + ", balance=" + balance + "]";
	}

}
