/**
 * 
 */
package com.aequalis.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aequalis.model.Vendor;
import com.aequalis.model.VendorQRCode;

/**
 * @author leoanbarasanm
 *
 */
public interface VendorQRCodeRepository extends JpaRepository<VendorQRCode, Long>{
	VendorQRCode findByVendor(Vendor vendor);
}
