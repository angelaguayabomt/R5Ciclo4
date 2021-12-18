/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Reto2C4.Reto2.controlador;

import com.Reto2C4.Reto2.modelo.Peripheral;
import com.Reto2C4.Reto2.servicio.PeripheralService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author angys
 */
@RestController
@RequestMapping("/api/peripherals")
@CrossOrigin("*")
public class PeripheralController {
    @Autowired
    private PeripheralService accessoryService;
       
    @GetMapping("/all")
    public List<Peripheral> getAll() {
        return accessoryService.getAll();
    }    
    @GetMapping("/{reference}")
    public Optional<Peripheral> getClothe(@PathVariable("reference") String reference) {
        return accessoryService.getClothe(reference);
    }
    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Peripheral create(@RequestBody Peripheral gadget) {
        return accessoryService.create(gadget);
    }    
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Peripheral update(@RequestBody Peripheral gadget) {
        return accessoryService.update(gadget);
    }
    @DeleteMapping("/{reference}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("reference") String reference) {
        return accessoryService.delete(reference);
    }
    @GetMapping("/price/{price}")
    public List<Peripheral> findByPriceLessThanEqual(@PathVariable("price") double precio) {
        return accessoryService.findByPriceLessThanEqual(precio);
    }

    @GetMapping("/description/{description}")
    public List<Peripheral> findByDescriptionLike(@PathVariable("description") String description) {
        return accessoryService.findByDescriptionLike(description);
    }
    
}

