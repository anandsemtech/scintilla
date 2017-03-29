/**
 * 
 */
package com.aequalis.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aequalis.model.Vendor;
import java.lang.Long;
import java.lang.String;
import java.util.List;
import com.aequalis.model.Type;

/**
 * @author leoanbarasanm
 *
 */
public interface VendorRepository extends JpaRepository<Vendor, Long>{
	Vendor findByVendorid(Long vendorid);
	Vendor findByVendorname(String vendorname);
	List<Vendor> findByType(Type type);
}
