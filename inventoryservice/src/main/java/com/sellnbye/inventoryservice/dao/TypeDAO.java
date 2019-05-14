/**
 * 
 */
package com.sellnbye.inventoryservice.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sellnbye.inventoryservice.model.Type;
import com.sellnbye.inventoryservice.repository.TypeRepository;

/**
 * @author Janandhi Chamudika
 * 
 * DAO is the place where we insert, update, delete, get the data from the database
 * using the typerepostitory and the model class
 *
 */

//in spring boot have to use service annotion in DAO class
@Service
public class TypeDAO {
	
	//create a object typerepostitory
	@Autowired
	TypeRepository typeRepository;

	/*to save a type*/
	
	public Type save(Type typ) {
		return typeRepository.save(typ);
	}
	
	
	/* search all types*/
	
	public List<Type> findAll(){
		return typeRepository.findAll();
	}
	
	
	/*get a type by id*/
	public Type findOne(Long typid) {
		return typeRepository.findOne(typid);
	}
	
	
	/*delete a type*/
	
	public void delete(Type typ) {
		typeRepository.delete(typ);
	}
	
}
