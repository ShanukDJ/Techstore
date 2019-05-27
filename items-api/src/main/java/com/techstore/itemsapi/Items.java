package com.techstore.itemsapi;

import javax.persistence.*;


@Entity
public class Items {


    public Integer getItemId() {
        return itemId;
    }

    public String getAddDate() {
        return addDate;
    }

    public void setAddDate(String addDate) {
        this.addDate = addDate;
    }

    public String getSellerId() {
        return sellerId;
    }

    public String getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(String itemPrice) {
        this.itemPrice = itemPrice;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public void setSellerId(String sellerId) {
        this.sellerId = sellerId;

    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer itemId;
    @Column(unique = true)
    private String sellerId;
    private String itemName;
    private String quantity;
    private String itemPrice;
    private String addDate;
}