package com.tss.controllers;

import com.tss.entities.Product;
import com.tss.repositories.ProductRepository;
import java.math.BigDecimal;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;


@RestController
@RequestMapping("/products")
public class ApplicationController {
    
    @Autowired
    ProductRepository productRepository;
    
    
    @Operation(summary = "Pobierz wszystkie produkty")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Lista produktów została pobrana"),
        @ApiResponse(responseCode = "500", description = "Błąd serwera")
    })
    @GetMapping()
    public List<Product> list() {
        return productRepository.findAll();
    }
       
    @Operation(summary = "Pobierz produkt po ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Produkt znaleziony"),
        @ApiResponse(responseCode = "404", description = "Produkt o podanym ID nie istnieje"),
        @ApiResponse(responseCode = "500", description = "Błąd serwera")
    })
    @GetMapping("/{id}")
    public ResponseEntity<Product> get(@PathVariable Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid product Id:" + id));
        return ResponseEntity.status(HttpStatus.OK).body(product);
    }

    @Operation(summary = "Dodaj nowy produkt")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Produkt został dodany"),
        @ApiResponse(responseCode = "400", description = "Błąd w danych wejściowych"),
        @ApiResponse(responseCode = "500", description = "Błąd serwera")
    })
    @PostMapping
    public ResponseEntity<?> post(@RequestBody Product input) {
        Product product = new Product();
        product.setName(input.getName());
        product.setPrice(input.getPrice());
        product.setUpdated(new java.util.Date());
        product.setDescription(input.getDescription());
        try {
            productRepository.save(product);
            return ResponseEntity.status(HttpStatus.CREATED).body(product);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error while saving product: " + e.getMessage());
        }
    }

    @Operation(summary = "Edytuj istniejący produkt")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Produkt został zaktualizowany"),
        @ApiResponse(responseCode = "404", description = "Produkt o podanym ID nie istnieje"),
        @ApiResponse(responseCode = "500", description = "Błąd serwera")
    })
    @PutMapping("/{id}")
    public ResponseEntity<Product> put(@PathVariable Long id, @RequestBody Product input) {
        Product existingProduct = productRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid product Id:" + id));
        existingProduct.setId(id);
        existingProduct.setName(input.getName() + " Modified");
        existingProduct.setPrice(input.getPrice());
        existingProduct.setUpdated(new java.util.Date());
        existingProduct.setDescription(input.getDescription());
        productRepository.save(existingProduct);
        return ResponseEntity.status(HttpStatus.OK).body(existingProduct);
    }

    @Operation(summary = "Usuń produkt")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "204", description = "Produkt został usunięty"),
        @ApiResponse(responseCode = "404", description = "Produkt o podanym ID nie istnieje"),
        @ApiResponse(responseCode = "500", description = "Błąd serwera")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid product Id:" + id));
        productRepository.delete(product);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ResponseEntity<String> handleIllegalArgumentException(IllegalArgumentException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Server Error")
    public ResponseEntity<String> handleException(Exception ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("An unexpected error occurred: " + ex.getMessage());
    }
}
