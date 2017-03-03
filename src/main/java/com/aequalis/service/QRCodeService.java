/**
 * 
 */
package com.aequalis.service;

import com.aequalis.model.QRCode;
import com.aequalis.model.User;

/**
 * @author leoanbarasanm
 *
 */
public interface QRCodeService {
	public void addQRCode(QRCode qrCode);
	public QRCode findByUser(User user);
}
