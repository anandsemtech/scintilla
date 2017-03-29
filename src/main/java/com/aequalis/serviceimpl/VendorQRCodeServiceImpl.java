/**
 * 
 */
package com.aequalis.serviceimpl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.aequalis.model.Vendor;
import com.aequalis.model.VendorQRCode;
import com.aequalis.repository.VendorQRCodeRepository;
import com.aequalis.service.VendorQRCodeService;

/**
 * @author leoanbarasanm
 *
 */
@Service
@Qualifier("vendorQrCodeService")
@Transactional
public class VendorQRCodeServiceImpl implements VendorQRCodeService {
	
	@Autowired
	VendorQRCodeRepository vendorQrCodeRepository;

	@Override
	public void addVendorQRCode(VendorQRCode qrCode) {
		vendorQrCodeRepository.saveAndFlush(qrCode);
	}

	@Override
	public VendorQRCode findByVendor(Vendor vendor) {
		return vendorQrCodeRepository.findByVendor(vendor);
	}
	

}
