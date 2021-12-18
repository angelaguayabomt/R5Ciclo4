/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Reto2C4.Reto2.servicio;

import com.Reto2C4.Reto2.modelo.User;
import com.Reto2C4.Reto2.repositorio.UserRepositorio;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author angys
 */
@Service
public class UserService {
    @Autowired
    private UserRepositorio UserRepositorio;

    public List<User> getAll() {
        return UserRepositorio.getAll();
    }

    public Optional<User> getUser(int id) {
        
        return UserRepositorio.getUser(id);
    }

    public User create(User user) {
        if (user.getId() == null) {
            return user;            
        }else {
            Optional<User> e = UserRepositorio.getUser(user.getId());
            if (e.isEmpty()) {
                if (emailExists(user.getEmail())==false){
                    return UserRepositorio.create(user);
                }else{
                    return user;
                }
            }else{
                return user;
            }           
        }
    }

    public User update(User user) {

        if (user.getId() != null) {
            Optional<User> userDb = UserRepositorio.getUser(user.getId());
            if (!userDb.isEmpty()) {
                if (user.getIdentification() != null) {
                    userDb.get().setIdentification(user.getIdentification());
                }
                if (user.getName() != null) {
                    userDb.get().setName(user.getName());
                }
                if (user.getAddress() != null) {
                    userDb.get().setAddress(user.getAddress());
                }
                if (user.getCellPhone() != null) {
                    userDb.get().setCellPhone(user.getCellPhone());
                }
                if (user.getEmail() != null) {
                    userDb.get().setEmail(user.getEmail());
                }
                if (user.getPassword() != null) {
                    userDb.get().setPassword(user.getPassword());
                }
                if (user.getZone() != null) {
                    userDb.get().setZone(user.getZone());
                }
                
                UserRepositorio.update(userDb.get());
                return userDb.get();
            } else {
                return user;
            }
        } else {
            return user;
        }
    }
    
    public boolean delete(int userId) {
        Boolean aBoolean = getUser(userId).map(user -> {
            UserRepositorio.delete(user);
            return true;
        }).orElse(false);
        return aBoolean;
    }
    
    public boolean emailExists(String email) {
        return UserRepositorio.emailExists(email);
    }

    public User authenticateUser(String email, String password) {
        Optional<User> usuario = UserRepositorio.authenticateUser(email, password);

        if (usuario.isEmpty()) {
            return new User();
        } else {
            return usuario.get();
        }
    }
    
    public List<User> birthtDayList(String monthBirthtDay) {
        return UserRepositorio.birthtDayList(monthBirthtDay);
    }
    
}