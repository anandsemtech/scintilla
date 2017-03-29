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
@Table(name="vendorqrcode")
public class VendorQRCode implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long qrcodeid;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "vendorid")
	private Vendor vendor;
	
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
	 * @return the vendor
	 */
	public Vendor getVendor() {
		return vendor;
	}

	/**
	 * @param vendor the vendor to set
	 */
	public void setVendor(Vendor vendor) {
		this.vendor = vendor;
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
