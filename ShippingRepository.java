package com.emalcoding.springBootREST.repository;

import com.emalcoding.springBootREST.model.Shipping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface ShippingRepository extends JpaRepository<Shipping, Long> {

}
