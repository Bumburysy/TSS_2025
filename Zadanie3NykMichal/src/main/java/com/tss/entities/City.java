package com.tss.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class City implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;
    
    private Integer pincode;
    
    private Long population;
    
    public City(){}
    
    public City(String name, Integer pincode){
        this.name = name;
        this.pincode = pincode;
    }
    
    public City(String name, Integer pincode, Long population){
        this.name = name;
        this.pincode = pincode;
        this.population = population;
    }
    
    public Long getId(){
        return id;
    }
    
    public void setId(Long id){
        this.id = id;
    }
    
    public String getName(){
        return name;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public Integer getPincode(){
        return pincode;
    }
    
    public void setPincode(Integer pincode){
        this.pincode = pincode;
    }
    
    public Long getPopulation(){
        return population;
    }
    
    public void setPopulation(Long population){
        this.population = population;
    }
    
    @Override
    public String toString(){
        return "City{" + "id=" + id + ", name=" + name + ", pincode=" + pincode + ", population=" + population + '}';
    }
}
