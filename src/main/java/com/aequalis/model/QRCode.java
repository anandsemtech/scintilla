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
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author leoanbarasanm
 *
 */
@Entity
@Table(name="qrcode")
public class QRCode implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long qrcodeid;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "userid")
	private User user;
	
	@Lob
	@Column(name = "code", length=100000)
	private byte[] code;

	/**
	 * @return the qrcodeid
	 */
	public Long getQrcodeid() {
		return qrcodeid;
	}

	/**
	 * @param qrcodeid the qrcodeid to set
	 */
	public void setQrcodeid(Long qrcodeid) {
		this.qrcodeid = qrcodeid;
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

	/**
	 * @return the code
	 */
	public byte[] getCode() {
		return code;
	}

	/**
	 * @param code the code to set
	 */
	public void setCode(byte[] code) {
		this.code = code;
	}
	
}
