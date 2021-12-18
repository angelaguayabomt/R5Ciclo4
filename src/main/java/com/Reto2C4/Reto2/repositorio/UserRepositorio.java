/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Reto2C4.Reto2.repositorio;

import com.Reto2C4.Reto2.interfaces.InterfaceUser;
import com.Reto2C4.Reto2.modelo.User;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

/**
 *
 * @author angys
 */
@Repository
public class UserRepositorio {
        @Autowired
    private InterfaceUser InterfaceUser;
    
    @Autowired
    private MongoTemplate mongoTemplate;

    public List<User> getAll() {
        return (List<User>) InterfaceUser.findAll();
    }

    public Optional<User> getUser(int id) {
        return InterfaceUser.findById(id);
    }

    public User create(User user) {
        return InterfaceUser.save(user);
    }
    
    public void update(User user) {
        InterfaceUser.save(user);
    }
    
    public void delete(User user) {
        InterfaceUser.delete(user);
    }

    public boolean emailExists(String email) {
        Optional<User> usuario = InterfaceUser.findByEmail(email);
        
        return !usuario.isEmpty();
    }
    
    public Optional<User> authenticateUser(String email, String password) {
        return InterfaceUser.findByEmailAndPassword(email, password);
    }
    
    public Optional<User> lastUserId(){
    return InterfaceUser.findTopByOrderByIdDesc();
    }
    
    public List<User> birthtDayList(String monthBirthtDay) {
        return InterfaceUser.findByMonthBirthtDay(monthBirthtDay);
    }
        
}