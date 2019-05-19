package com.emalcoding.springBootREST.controller;

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

import com.emalcoding.springBootREST.dao.ShippingDao;
import com.emalcoding.springBootREST.model.Shipping;

@RestController
@RequestMapping("/company")
public class ShipingController {
	
	@Autowired
	ShippingDao shippingDao;
	
	/*to save an product*/
	@PostMapping("/shipping")
	public Shipping createProduct(@Valid @RequestBody Shipping pro) {
		return shippingDao.save(pro);
	}

	/*get all products*/
	@GetMapping("/shipping")
	public List<Shipping> getAllProduct(){
		return shippingDao.findAll();
	}
	
	/*get product by proid*/
	@GetMapping("/shipping/{id}")
	public ResponseEntity<Shipping> getProductById(@PathVariable(value="id") Long proid) {
		
		Shipping pro=shippingDao.findOne(proid);
		
		if(pro==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(pro);
		}

	/*update an product by proid*/
	@PutMapping("/shipping/{id}")
	public ResponseEntity<Shipping> updateProduct(@PathVariable(value="id") Long proid,@Valid @RequestBody Shipping proDetails){
		
		Shipping pro=shippingDao.findOne(proid);
		if(pro==null) {
			return ResponseEntity.notFound().build();
		}
		pro.setName(proDetails.getName());
		pro.setDescription(proDetails.getDescription());
		pro.setDate(proDetails.getDate());
		pro.setPrice(proDetails.getPrice());
		pro.setQtyperunit(proDetails.getQtyperunit());
		
		Shipping updateProduct=shippingDao.save(pro);
		return ResponseEntity.ok().body(updateProduct);
	}
	
	/*Delete an product*/
	@DeleteMapping("/shipping/{id}")
	public ResponseEntity<Shipping> deleteProduct(@PathVariable(value="id") Long proid){
		
		Shipping pro=shippingDao.findOne(proid);
		if(pro==null) {
			return ResponseEntity.notFound().build();
		}
		shippingDao.delete(pro);
		
		return ResponseEntity.ok().build();
	}
	
	
	
}


