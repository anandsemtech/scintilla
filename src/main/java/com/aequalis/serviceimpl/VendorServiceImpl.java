/**
 * 
 */
package com.aequalis.serviceimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.aequalis.model.Type;
import com.aequalis.model.Vendor;
import com.aequalis.repository.VendorRepository;
import com.aequalis.service.VendorService;

/**
 * @author leoanbarasanm
 *
 */
@Service
@Qualifier("vendorService")
@Transactional
public class VendorServiceImpl implements VendorService {
	
	@Autowired
	VendorRepository vendorRepository;

	@Override
	public void addVendor(Vendor vendor) {
		vendorRepository.saveAndFlush(vendor);
	}

	@Override
	public Vendor findByVendorid(Long vendorid) {
		return vendorRepository.findByVendorid(vendorid);
	}

	@Override
	public List<Vendor> findAll() {
		return vendorRepository.findAll();
	}

	@Override
	public Vendor findByVendorname(String vendorname) {
		return vendorRepository.findByVendorname(vendorname);
	}

	@Override
	public List<Vendor> findByType(Type type) {
		return vendorRepository.findByType(type);
	}

}
