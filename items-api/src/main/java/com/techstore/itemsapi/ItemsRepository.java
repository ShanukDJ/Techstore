package com.techstore.itemsapi;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface ItemsRepository extends CrudRepository<Items, Integer> {

    @Query(value = "SELECT i FROM Items i WHERE i.itemId=:itemId AND i.sellerId=:sellerId")
    Items findByItemIdAndSellerId(@Param("itemId") String itemId, @Param("sellerId") String sellerId);

}