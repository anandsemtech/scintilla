/**
 * 
 */
package com.aequalis.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aequalis.model.Transaction;
import com.aequalis.model.User;
import java.util.List;
import java.lang.String;

/**
 * @author leoanbarasanm
 *
 */
public interface TransactionRepository extends JpaRepository<Transaction, Long>{
	List<Transaction> findByUser(User user);
	List<Transaction> findByCutomeraddress(String cutomeraddress);
}
