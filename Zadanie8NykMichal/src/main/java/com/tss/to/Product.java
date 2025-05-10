package com.tss.to;

import java.math.BigDecimal;
import java.util.Date;

public class Product {
    
    private Long id;
    private String name;
    protected BigDecimal price;
    private Date updated;
    private String description;
    
    public Product(){
        
    }
    
    public Product(Long id, String name, BigDecimal price, Date updated,String description){
        this.id = id;
        this.name = name;
        this.price = price;
        this.updated = updated;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
}
