/**
 * 
 */
package com.aequalis.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aequalis.model.QRCode;
import com.aequalis.model.User;

/**
 * @author leoanbarasanm
 *
 */
public interface QRCodeRepository extends JpaRepository<QRCode, Long>{
	QRCode findByUser(User user);
}
