package com.tss.services;

import com.tss.to.Product;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ProductService {
    
    @Autowired
    RestTemplate restTemplate;
    
    java.util.List<Product> productList = new java.util.ArrayList();
    
    public List<Product> productList(){
        ResponseEntity<Product[]> response = restTemplate.getForEntity("http://eurekaServiceClientProfile/products/",Product[].class);
        
        Product[] products = response.getBody();
        
        productList = java.util.Arrays.asList(products);
        return productList;
    }
}
