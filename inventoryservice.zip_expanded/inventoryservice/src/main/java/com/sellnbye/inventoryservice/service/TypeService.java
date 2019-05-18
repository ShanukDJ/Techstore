package com.sellnbye.inventoryservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sellnbye.inventoryservice.model.Type;
import com.sellnbye.inventoryservice.repository.TypeRepository;

@Service
public class TypeService {
	
	@Autowired
	TypeRepository typeRepository;

	/* search all types*/
	public List<Type> listAll(){
		return typeRepository.findAll();
	}
	
	/*to save a type*/
	private void save(Type type) {
		typeRepository.save(type);
	}
	
	/*get a type by id*/
	public Type get(Long id) {
		return typeRepository.findById(id).get();
		
	}
	
	/*delete a type*/
	public void delete(Long id) {
		typeRepository.deleteById(id);
	}
	
}
