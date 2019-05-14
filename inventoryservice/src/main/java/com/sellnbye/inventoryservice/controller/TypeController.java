/**
 * 
 */
package com.sellnbye.inventoryservice.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sellnbye.inventoryservice.dao.TypeDAO;
import com.sellnbye.inventoryservice.model.Type;

/**
 * @author Janandhi Chamudika
 * 
 * Controller will be accessing the DAO class
 *
 */

@RestController
@RequestMapping("/item")
public class TypeController {
	
	//create a object TypeDAO
	@Autowired
	TypeDAO typeDAO;
	
	/* to save a type*/
	@PostMapping("/types")
	public Type createType(@Valid @RequestBody Type typ) {
		return typeDAO.save(typ);
	}
	

	/*get all types*/
	@GetMapping("/types")
	public List<Type> getAllTypes(){
		return typeDAO.findAll();
	}
	
	
	/*get type by typid*/
	@GetMapping("/types/{id}")
	public ResponseEntity<Type> getTypeById(@PathVariable(value="id") Long typid){
		
		Type typ = typeDAO.findOne(typid);
		
		if(typ == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(typ);
		
	}
	
	
	/*update a type by typid*/
	@PutMapping("/types/{id}")
	public ResponseEntity<Type> updateType(@PathVariable(value="id") Long typid,@Valid @RequestBody Type typDetails){
		
		Type typ = typeDAO.findOne(typid);
		if(typ == null) {
			return ResponseEntity.notFound().build();
		}
		
		typ.setType(typDetails.getType());
		
		Type updateType = typeDAO.save(typ);
		return ResponseEntity.ok().body(updateType);
		
	}
	
	
	/*Delete a Type*/
	@DeleteMapping("/types/{id}")
	public ResponseEntity<Type> deleteEmployee(@PathVariable(value="id") Long typid){
		
		Type typ = typeDAO.findOne(typid);
		if(typ == null) {
			return ResponseEntity.notFound().build();
		}
		
		typeDAO.delete(typ);
		
		return ResponseEntity.ok().build();
		
	}
	
	
}
