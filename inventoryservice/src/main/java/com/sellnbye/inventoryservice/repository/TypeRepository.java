/**
 * 
 */
package com.sellnbye.inventoryservice.repository;

import com.sellnbye.inventoryservice.model.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Janandhi Chamudika
 *
 */
public interface TypeRepository extends JpaRepository<Type, Long>{

}
