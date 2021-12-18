/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Reto2C4.Reto2.interfaces;

import com.Reto2C4.Reto2.modelo.Peripheral;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

/**
 *
 * @author angys
 */
public interface InterfacePeripheral extends MongoRepository<Peripheral, String> {
    public List<Peripheral> findByPriceLessThanEqual(double precio);
    
    @Query("{'description':{'$regex':'?0','$options':'i'}}")
    public List<Peripheral> findByDescriptionLike(String description);
}
