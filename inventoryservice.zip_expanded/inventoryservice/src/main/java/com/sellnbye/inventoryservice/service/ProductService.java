package com.sellnbye.inventoryservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sellnbye.inventoryservice.model.product;
import com.sellnbye.inventoryservice.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	ProductRepository productRepository;

	/* search all types*/
//	public List<product> getAll(){
//		return productRepository.findAll();
//	}
	public Optional<List<product>> getALL(){
		if(productRepository.count() == 0){
			return Optional.empty();
		}else {
			return Optional.of(productRepository.findAll());
		}
	}
	
	public String addOne(product pro) {
		productRepository.save(pro);
		return "Product Added Succesfully";
	}
	
	public product get(int empId) {
		return productRepository.findById(empId).get();
	}

	public String editOne(product pro) {
		productRepository.save(pro);
		return "Product Updated Succesfully";
	}

	public String deleteOne(int proId) {
		productRepository.deleteById(proId);
		return "Product Deleted Succesfully";
	}

}
