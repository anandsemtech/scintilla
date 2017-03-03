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
import com.aequalis.repository.TypeRepository;
import com.aequalis.service.TypeService;

/**
 * @author leoanbarasanm
 *
 */
@Service
@Qualifier("typeService")
@Transactional
public class TypeServiceImpl implements TypeService {
	
	@Autowired
	TypeRepository typeRepository;

	@Override
	public List<Type> findAllType() {
		return typeRepository.findAll();
	}

	@Override
	public Type findByTypeid(Long typeid) {
		return typeRepository.findByTypeid(typeid);
	}

	@Override
	public Type findByName(String name) {
		return typeRepository.findByName(name);
	}
	

}
