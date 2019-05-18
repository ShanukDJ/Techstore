package com.emalcoding.springBootREST.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emalcoding.springBootREST.model.Shipping;
import com.emalcoding.springBootREST.repository.ShippingRepository;

@Service
public class ShippingDao {
	
	@Autowired
	ShippingRepository productRepository;
	
	public Shipping save(Shipping pro) {
		return productRepository.save(pro);
	}
	
	public List<Shipping> findAll(){
		return productRepository.findAll();
	}
	
	public Shipping findOne(Long proid) {
		return productRepository.findOne(proid);
		
	}
	
	public void delete(Shipping pro) {
		productRepository.delete(pro);
	}

}
