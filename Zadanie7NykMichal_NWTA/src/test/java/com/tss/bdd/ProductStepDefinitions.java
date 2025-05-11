package com.tss.bdd;

import com.tss.entities.Product;
import com.tss.repositories.ProductRepository;
import io.cucumber.java.en.*;
import org.springframework.beans.factory.annotation.Autowired;
import static org.junit.jupiter.api.Assertions.*;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_CLASS)
public class ProductStepDefinitions {

    @Autowired
    private ProductRepository productRepository;

    private Product testProduct;
    private Long createdProductId;
    
    @Given("użytkownik chce dodać produkt o nazwie {string}, cenie {double} i opisie {string}")
    public void addProductTest(String name, double price, String description) {
        testProduct = new Product();
        testProduct.setName(name);
        testProduct.setPrice(BigDecimal.valueOf(price));
        testProduct.setDescription(description);
        testProduct.setUpdated(new java.util.Date());
        System.out.println("Tworzenie produktu: " + name);
    }

    @When("produkt zostanie dodany do systemu")
    public void saveProductTest() {
        Product saved = productRepository.save(testProduct);
        createdProductId = saved.getId();
        System.out.println("Dodoano produktu o ID: " + saved.getId());
    }

    @Then("produkt powinien być dostępny do pobrania po ID")
    public void getProductTest() {
        Optional<Product> found = productRepository.findById(createdProductId);
        assertTrue(found.isPresent(), "Produkt nie został znaleziony w repozytorium");
        System.out.println("Dane Produktu: " + found.get().getName() + " " + found.get().getPrice() + " " + found.get().getDescription() + " " + found.get().getUpdated());
    }

    @And("jego nazwa powinna być równa {string}")
    public void productNameTest(String expectedName) {
        Product product = productRepository.findById(createdProductId).orElseThrow();
        assertEquals(expectedName, product.getName(), "Nazwa produktu nie pasuje");
        System.out.println("Nazwa: " + product.getName());
    }
    
    @Given("istnieją produkty {string} i {string} i użytkownik chce zobaczyć produkty w bazie")
    public void addMultipleProductsTest(String name1, String name2) {
        Product p1 = new Product();
        p1.setName(name1);
        p1.setPrice(BigDecimal.valueOf(100));
        p1.setDescription("Opis 1");
        p1.setUpdated(new java.util.Date());
        productRepository.save(p1);
        
        System.out.println("Dodoano produktu: " + p1.getName());

        Product p2 = new Product();
        p2.setName(name2);
        p2.setPrice(BigDecimal.valueOf(200));
        p2.setDescription("Opis 2");
        p2.setUpdated(new java.util.Date());
        productRepository.save(p2);
        
        System.out.println("Dodoano produktu: " + p2.getName());
    }
    
    @Then("produkty powinieny być dostępne w bazie")
    public void assertMultipleProductsTest() {
        List<Product> products = productRepository.findAll();
        assertTrue(!products.isEmpty(), "Brak produktów w bazie");
        System.out.println("Produkty w bazie:");
        products.forEach(p -> System.out.println("- " + p.getName()));
    }

    @And("powinno być co najmniej {int} produktów w systemie")
    public void CountProductsTest(int minCount) {
        long count = productRepository.count();
        assertTrue(count >= minCount, "Liczba produktów jest mniejsza niż oczekiwano");
        System.out.println("Liczba produktów: " + count);
    }
    
    @Given("istnieje produkt o nazwie {string}, cenie {double} i opisie {string} a użytkownik zmienia cenę")
    public void AddUpdateProductTest(String name, double price, String description) {
        Product p3 = new Product();
        p3.setName(name);
        p3.setPrice(BigDecimal.valueOf(price));
        p3.setDescription(description);
        p3.setUpdated(new java.util.Date());
        productRepository.save(p3);
        createdProductId = p3.getId();
        assertTrue(productRepository.findById(createdProductId).isPresent(), "Produkt nie został znaleziony w repozytorium");
        System.out.println("Znaleziono produkt: " + productRepository.findById(createdProductId).get().getName() + 
                " o cenie " + productRepository.findById(createdProductId).get().getPrice());
    }
    
    @When("użytkownik zmienia cenę produktu na {double}")
    public void updateProductPriceTest(double newPrice) {
        Product product = productRepository.findById(createdProductId).orElseThrow();
        product.setPrice(BigDecimal.valueOf(newPrice));
        product.setUpdated(new java.util.Date());
        productRepository.save(product);
        System.out.println("Zmieniono cenę produktu na: " + newPrice);
    }

    @Then("cena produktu powinna wynosić {double}")
    public void assertUpdatedPriceTest(double expectedPrice) {
        Product product = productRepository.findById(createdProductId).orElseThrow();
        assertEquals(0, product.getPrice().compareTo(BigDecimal.valueOf(expectedPrice)), "Cena nie została zaktualizowana");
        System.out.println("Nowa cena produktu: " + product.getPrice());
    }

    @Given("istnieje produkt o nazwie {string}, cenie {double} i opisie {string} a użytkownik usuwa produkt")
    public void AddDeleteProductTest(String name, double price, String description) {
        Product p4 = new Product();
        p4.setName(name);
        p4.setPrice(BigDecimal.valueOf(price));
        p4.setDescription(description);
        p4.setUpdated(new java.util.Date());
        productRepository.save(p4);
        createdProductId = p4.getId();
        assertTrue(productRepository.findById(createdProductId).isPresent(), "Produkt nie został znaleziony w repozytorium");
        System.out.println("Znaleziono produkt: " + productRepository.findById(createdProductId).get().getName());
    }
    
    @When("użytkownik usuwa produkt")
    public void deleteProductTest() {
        productRepository.deleteById(createdProductId);
        System.out.println("Produkt usunięty o ID: " + createdProductId);
    }

    @Then("produkt nie powinien istnieć w systemie")
    public void assertProductDeletedTest() {
        assertFalse(productRepository.findById(createdProductId).isPresent(), "Produkt nadal istnieje po usunięciu");
        System.out.println("Produkt nie istnieje.");
    }
    
    @When("użytkownik próbuje pobrać produkt o ID {int}")
    public void fetchNonExistingProductTest(int id) {
        // Rzuca wyjątek jeśli produkt nie istnieje
        productRepository.findById((long) id)
            .orElseThrow(() -> new IllegalArgumentException("Produkt o ID " + id + " nie istnieje"));
    }
}
