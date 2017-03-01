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

/**
 * @author leoanbarasanm
 *
 */
@Entity
@Table(name="transaction")
public class Transaction implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long transactionid;

	@Column(name = "transactiondate")
	@Temporal(TemporalType.TIMESTAMP)
    private Date transactiondate;

	@Column(name = "cutomeraddress")
	private String cutomeraddress;
	
	@Column(name = "transactionaddress")
	private String transactionaddress;
	
	@Column(name = "transactionamount")
	private String transactionamount;
	
	@Column(name = "transactiondescription")
	private String transactiondescription;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "userid")
	private User user;

	/**
	 * @return the transactionid
	 */
	public Long getTransactionid() {
		return transactionid;
	}

	/**
	 * @return the transactiondescription
	 */
	public String getTransactiondescription() {
		return transactiondescription;
	}

	/**
	 * @param transactiondescription the transactiondescription to set
	 */
	public void setTransactiondescription(String transactiondescription) {
		this.transactiondescription = transactiondescription;
	}

	/**
	 * @param transactionid the transactionid to set
	 */
	public void setTransactionid(Long transactionid) {
		this.transactionid = transactionid;
	}

	/**
	 * @return the transactiondate
	 */
	public Date getTransactiondate() {
		return transactiondate;
	}

	/**
	 * @param transactiondate the transactiondate to set
	 */
	public void setTransactiondate(Date transactiondate) {
		this.transactiondate = transactiondate;
	}

	/**
	 * @return the cutomeraddress
	 */
	public String getCutomeraddress() {
		return cutomeraddress;
	}

	/**
	 * @param cutomeraddress the cutomeraddress to set
	 */
	public void setCutomeraddress(String cutomeraddress) {
		this.cutomeraddress = cutomeraddress;
	}

	/**
	 * @return the transactionaddress
	 */
	public String getTransactionaddress() {
		return transactionaddress;
	}

	/**
	 * @param transactionaddress the transactionaddress to set
	 */
	public void setTransactionaddress(String transactionaddress) {
		this.transactionaddress = transactionaddress;
	}

	/**
	 * @return the transactionamount
	 */
	public String getTransactionamount() {
		return transactionamount;
	}

	/**
	 * @param transactionamount the transactionamount to set
	 */
	public void setTransactionamount(String transactionamount) {
		this.transactionamount = transactionamount;
	}

	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Transaction [transactionid=" + transactionid + ", transactiondate=" + transactiondate
				+ ", cutomeraddress=" + cutomeraddress + ", transactionaddress=" + transactionaddress
				+ ", transactionamount=" + transactionamount + ", user=" + user + "]";
	}
	
}
