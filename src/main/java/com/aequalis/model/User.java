/**
 * 
 */
package com.aequalis.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 * @author leoanbarasanm
 *
 */
@Entity
@Table(name="users")
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long userid;

	@Column(name = "username")
	private String username;

	@Column(name = "password")
	private String password;
	
	@Column(name = "fullname")
	private String fullname;
	
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
	
	@Column(name = "unlocked")
	private Boolean unlocked;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "typeid")
	private Type type;
	
	@Column(name="lastlogin")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastLogin;
	
	@Column(name="currentlogin")
    @Temporal(TemporalType.TIMESTAMP)
    private Date currentLogin;
	
	
	@Transient
	private String balance;

	/**
	 * @return the userid
	 */
	public Long getUserid() {
		return userid;
	}

	/**
	 * @return the unlocked
	 */
	public Boolean getUnlocked() {
		return unlocked;
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
	 * @param unlocked the unlocked to set
	 */
	public void setUnlocked(Boolean unlocked) {
		this.unlocked = unlocked;
	}

	/**
	 * @return the lastLogin
	 */
	public Date getLastLogin() {
		return lastLogin;
	}

	/**
	 * @param lastLogin the lastLogin to set
	 */
	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}

	/**
	 * @return the currentLogin
	 */
	public Date getCurrentLogin() {
		return currentLogin;
	}

	/**
	 * @param currentLogin the currentLogin to set
	 */
	public void setCurrentLogin(Date currentLogin) {
		this.currentLogin = currentLogin;
	}

	/**
	 * @param userid the userid to set
	 */
	public void setUserid(Long userid) {
		this.userid = userid;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
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
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the fullname
	 */
	public String getFullname() {
		return fullname;
	}

	/**
	 * @param fullname the fullname to set
	 */
	public void setFullname(String fullname) {
		this.fullname = fullname;
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
		return "User [userid=" + userid + ", username=" + username + ", password=" + password + ", fullname=" + fullname
				+ ", contactnumber=" + contactnumber + ", email=" + email + ", website=" + website + ", address="
				+ address + ", bcaddress=" + bcaddress + ", unlocked=" + unlocked + ", type=" + type + ", lastLogin="
				+ lastLogin + ", currentLogin=" + currentLogin + ", balance=" + balance + "]";
	}
}
