package com.sellnbye.inventoryservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sellnbye.inventoryservice.model.Type;
import com.sellnbye.inventoryservice.model.product;

public interface ProductRepository extends JpaRepository<product , Integer>{

}
