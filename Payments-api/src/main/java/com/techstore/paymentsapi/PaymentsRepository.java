package com.techstore.paymentsapi;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface PaymentsRepository extends CrudRepository<Payments, Integer> {

    @Query(value = "SELECT p FROM Payments p WHERE p.paymentId=:paymentId")
    Payments findByPaymentId(@Param("paymentId") Integer paymentId);

}