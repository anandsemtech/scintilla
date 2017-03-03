/**
 * 
 */
package com.aequalis.serviceimpl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.aequalis.model.QRCode;
import com.aequalis.model.User;
import com.aequalis.repository.QRCodeRepository;
import com.aequalis.service.QRCodeService;

/**
 * @author leoanbarasanm
 *
 */
@Service
@Qualifier("qrCodeService")
@Transactional
public class QRCodeServiceImpl implements QRCodeService {
	
	@Autowired
	QRCodeRepository qrCodeRepository;
	
	@Override
	public void addQRCode(QRCode qrCode) {
		qrCodeRepository.saveAndFlush(qrCode);
	}
	@Override
	public QRCode findByUser(User user) {
		return qrCodeRepository.findByUser(user);
	}

}
