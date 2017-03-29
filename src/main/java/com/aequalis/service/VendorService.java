/**
 * 
 */
package com.aequalis.service;

import java.util.List;

import com.aequalis.model.Type;
import com.aequalis.model.Vendor;

/**
 * @author leoanbarasanm
 *
 */
public interface VendorService {
	public void addVendor(Vendor vendor);
	
	public Vendor findByVendorid(Long vendorid);
	
	public List<Vendor> findAll();
	
	public Vendor findByVendorname(String vendorname);
	
	public List<Vendor> findByType(Type type);
}
