package com.example.BikeShop.persistance;

import com.example.BikeShop.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findAllByOrderByPriceAsc();



    List<Product> findAllByOrderByPriceDesc();

    long countAllByPriceGreaterThan(@Param("price") Float price);

    List<Product> findAllByPriceGreaterThan(@Param("price") Float price);
    List<Product> findAllByManufacturerId(@Param("id") Long id);
    List<Product> findAllByNameLikeAndManufacturerIdOrderByPriceDesc(String name, Long manufacturerId);
}
