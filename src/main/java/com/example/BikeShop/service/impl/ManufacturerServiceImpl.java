package com.example.BikeShop.service.impl;

import com.example.BikeShop.model.Manufacturer;
import com.example.BikeShop.model.exception.ManufacturerNotFoundException;
import com.example.BikeShop.persistance.ManufacturerRepository;
import com.example.BikeShop.service.ManufacturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManufacturerServiceImpl implements ManufacturerService {


    private final ManufacturerRepository manufacturerRepository;

    @Autowired
    public ManufacturerServiceImpl(ManufacturerRepository manufacturerRepository) {
        this.manufacturerRepository = manufacturerRepository;
    }

    @Override
    public List<Manufacturer> findAll() {
        return this.manufacturerRepository.findAll();
    }

    @Override
    public List<Manufacturer> findAllByName(String name) {
        return null;
    }

    @Override
    public Manufacturer findById(Long id) {
        return this.manufacturerRepository.findById(id)
                .orElseThrow(() -> new ManufacturerNotFoundException(id));
    }

    @Override
    public Manufacturer save(Manufacturer manufacturer) {
        return this.manufacturerRepository.save(manufacturer);
    }

    @Override
    public Manufacturer update(Long id, Manufacturer manufacturer) {
        Manufacturer m = this.findById(id);
        m.setName(manufacturer.getName());
        m.setAddress(manufacturer.getAddress());
        return this.manufacturerRepository.save(m);
    }

    @Override
    public Manufacturer updateName(Long id, String name) {
        Manufacturer m = this.findById(id);
        m.setName(name);
        return this.manufacturerRepository.save(m);
    }

    @Override
    public void deleteById(Long id) {
        this.manufacturerRepository.deleteById(id);
    }
}
