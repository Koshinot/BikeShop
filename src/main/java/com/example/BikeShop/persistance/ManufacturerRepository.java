package com.example.BikeShop.persistance;

import com.example.BikeShop.model.Manufacturer;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Profile("!in-memory")
public interface ManufacturerRepository extends JpaRepository<Manufacturer, Long> {

}
