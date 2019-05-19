/**
 * 
 * save(), findAll(), findById(), deleteById() are the pre implemented methods in this jpa repository
 * 
 */
package com.sellnbye.inventoryservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sellnbye.inventoryservice.model.Type;

/**
 * @author Hemachandra
 *
 */
public interface TypeRepository extends JpaRepository<Type , Long>{

}
