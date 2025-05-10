package com.tss.repositories;

import com.tss.entities.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {
    
    @Override
    java.util.List<Product> findAll();
}
