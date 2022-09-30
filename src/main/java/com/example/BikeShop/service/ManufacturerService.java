package com.example.BikeShop.service;

import com.example.BikeShop.model.Manufacturer;

import java.util.List;

public interface ManufacturerService {
    List<Manufacturer> findAll();
    List<Manufacturer> findAllByName(String name);
    Manufacturer findById(Long id);
    Manufacturer save(Manufacturer manufacturer);
    Manufacturer update(Long id, Manufacturer manufacturer);
    Manufacturer updateName(Long id, String name);
    void deleteById(Long id);
}
