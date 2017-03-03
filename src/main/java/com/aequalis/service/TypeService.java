/**
 * 
 */
package com.aequalis.service;

import java.util.List;

import com.aequalis.model.Type;

/**
 * @author leoanbarasanm
 *
 */
public interface TypeService {
	public List<Type> findAllType();
	
	public Type findByTypeid(Long typeid);
	
	public Type findByName(String name);
}
