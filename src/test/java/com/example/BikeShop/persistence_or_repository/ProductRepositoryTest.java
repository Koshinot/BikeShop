package com.example.BikeShop.persistence_or_repository;

import com.example.BikeShop.model.Manufacturer;
import com.example.BikeShop.model.Product;
import com.example.BikeShop.persistance.ManufacturerRepository;
import com.example.BikeShop.persistance.ProductRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

@DataJpaTest
@ActiveProfiles("test")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ProductRepositoryTest {

    @Autowired
    ManufacturerRepository manufacturerRepository;

    @Autowired
    ProductRepository productRepository;

    @BeforeAll
    public void init() {
        Manufacturer m = new Manufacturer();
        m.setId(1l);
        m.setName("name1");
        m = manufacturerRepository.save(m);

        Product p1,p2,p3;
        p1 = new Product();
        p1.setQuantity(5);
        p1.setPrice(5f);
        p1.setManufacturer(m);

        p2 = new Product();
        p2.setQuantity(2);
        p2.setPrice(2f);
        p2.setManufacturer(m);

        p3 = new Product();
        p3.setQuantity(3);
        p3.setPrice(3f);
        p3.setManufacturer(m);
        this.productRepository.save(p1);
        this.productRepository.save(p2);
        this.productRepository.save(p3);
    }

    @Test
    void findAllByOrderByPriceAsc() {
        List<Product> products = this.productRepository.findAllByOrderByPriceAsc();
        assert products.get(0).getPrice().equals(2f);
        assert products.get(1).getPrice().equals(3f);
        assert products.get(2).getPrice().equals(5f);
    }

    @Test
    void findAllByOrderByPriceDesc() {
        List<Product> products = this.productRepository.findAllByOrderByPriceDesc();
        assert products.get(0).getPrice().equals(5f);
        assert products.get(1).getPrice().equals(3f);
        assert products.get(2).getPrice().equals(2f);
    }

    @Test
    void countAllByPriceGreaterThan() {
        long count = this.productRepository.countAllByPriceGreaterThan(4f);
        assert count == 1;
    }

    @Test
    void findAllByManufacturerId() {
        List<Product> products = this.productRepository.findAllByManufacturerId(1l);
        assert products.size() == 3;
    }

    @Test
    void findAllByNameLikeAndManufacturerIdOrderByPriceDesc() {
    }
}