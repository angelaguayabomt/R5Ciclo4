/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Reto2C4.Reto2.repositorio;

import com.Reto2C4.Reto2.interfaces.InterfacePeripheral;
import com.Reto2C4.Reto2.modelo.Peripheral;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author angys
 */
@Repository
public class PeripheralRepositorio {
    @Autowired
    private InterfacePeripheral repository;
	
    public List<Peripheral> getAll() {
        return repository.findAll();
    }
    public Optional<Peripheral> getClothe(String reference) {
        return repository.findById(reference);
    }
    public Peripheral create(Peripheral clothe) {
	return repository.save(clothe);
    }
    public void update(Peripheral clothe) {
	repository.save(clothe);
    }
    public void delete(Peripheral clothe) {
	repository.delete(clothe);
    }
    
    public List<Peripheral> findByPriceLessThanEqual(double precio) {
    return repository.findByPriceLessThanEqual(precio);
    }
    public List<Peripheral> findByDescriptionLike(String description) {
    return repository.findByDescriptionLike(description);
    }
}

