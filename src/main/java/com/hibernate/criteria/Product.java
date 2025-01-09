package com.hibernate.criteria;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Product {

    @Id
    private int productId;
    private String productName;
    private String productBrand;
    private int productPrice;
    
    public int getProductId() { 
        return productId;
    }
    public void setProductId(int productId) {
        this.productId = productId;
    }
    public String getProductName() {
        return productName;
    }
    public void setProductName(String productName) {
        this.productName = productName;
    }
    public String getProductBrand() {
        return productBrand;
    }
    public void setProductBrand(String productBrand) {
        this.productBrand = productBrand;
    }
    public int getProductPrice() {
        return productPrice;
    }
    public void setProductPrice(int productPrice) {
        this.productPrice = productPrice;
    }
    @Override
    public String toString() {
        return "Product [productId=" + productId + ", productName=" + productName + ", productBrand=" + productBrand
                + ", productPrice=" + productPrice + "]";
    }
}

