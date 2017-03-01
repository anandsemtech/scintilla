/**
 * 
 */
package com.aequalis.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aequalis.model.Type;
import java.lang.Long;

/**
 * @author leoanbarasanm
 *
 */

public interface TypeRepository extends JpaRepository<Type, Long> {

	Type findByTypeid(Long typeid);
}
