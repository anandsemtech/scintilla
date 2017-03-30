/**
 * 
 */
package com.aequalis.serviceimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.aequalis.model.Transaction;
import com.aequalis.model.User;
import com.aequalis.repository.TransactionRepository;
import com.aequalis.service.TransactionService;

/**
 * @author leoanbarasanm
 *
 */
@Service
@Qualifier("transactionService")
@Transactional
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	TransactionRepository transactionRepository;
	
	@Override
	public void addTransaction(Transaction transaction) {
		transactionRepository.saveAndFlush(transaction);
	}

	@Override
	public List<Transaction> findByUser(User user) {
		return transactionRepository.findByUser(user);
	}

	@Override
	public List<Transaction> findByCutomeraddress(String cutomeraddress) {
		return transactionRepository.findByCutomeraddress(cutomeraddress);
	}
	
}
