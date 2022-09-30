package com.example.BikeShop.persistance.impl;

import com.example.BikeShop.model.Manufacturer;
import com.example.BikeShop.persistance.ManufacturerRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;


@Repository
@Profile("in-memory")
public class ManufacturerRepositoryImpl implements ManufacturerRepository {

    private HashMap<Long, Manufacturer> manufacturers;
    private AtomicLong counter;

    public ManufacturerRepositoryImpl() {
        this.manufacturers = new HashMap<>();
        this.counter = new AtomicLong(0);
    }

    @Override
    public List<Manufacturer> findAll() {
        return new ArrayList<>(this.manufacturers.values());
    }

    @Override
    public List<Manufacturer> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Manufacturer> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<Manufacturer> findAllById(Iterable<Long> iterable) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public <S extends Manufacturer> List<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends Manufacturer> S saveAndFlush(S s) {
        return null;
    }

    @Override
    public void deleteInBatch(Iterable<Manufacturer> iterable) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Manufacturer getOne(Long aLong) {
        return null;
    }

    @Override
    public <S extends Manufacturer> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Manufacturer> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Manufacturer> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends Manufacturer> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Manufacturer> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Manufacturer> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public Optional<Manufacturer> findById(Long id) {
        return Optional.ofNullable(this.manufacturers.get(id));
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public Manufacturer save(Manufacturer manufacturer) {
        if (manufacturer.getId() == null) {
            manufacturer.setId(this.counter.getAndIncrement());
        }
        this.manufacturers.put(manufacturer.getId(), manufacturer);
        return manufacturer;
    }

    @Override
    public void deleteById(Long id) {
        this.manufacturers.remove(id);
    }

    @Override
    public void delete(Manufacturer manufacturer) {

    }

    @Override
    public void deleteAll(Iterable<? extends Manufacturer> iterable) {

    }

    @Override
    public void deleteAll() {

    }
}
