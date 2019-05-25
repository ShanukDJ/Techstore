package com.techstore.delivery;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface DeliveryRepository extends CrudRepository<DeliveryForms, Integer> {

    @Query(value = "SELECT d FROM DeliveryForms d WHERE d.dfId=:dfId")
    DeliveryForms findBydfId(@Param("dfId") Integer dfId);

}