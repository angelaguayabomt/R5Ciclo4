/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Reto2C4.Reto2.controlador;

import com.Reto2C4.Reto2.modelo.Order;
import com.Reto2C4.Reto2.servicio.OrderService;
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
@RequestMapping("/api/order")
@CrossOrigin("*")

public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/all")
    public List<Order> getAll() {
        return orderService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Order> getOrder(@PathVariable("id") int id) {
        return orderService.getOrder(id);
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Order create(@RequestBody Order gadget) {
        return orderService.create(gadget);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Order update(@RequestBody Order gadget) {
        return orderService.update(gadget);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id) {
        return orderService.delete(id);
    }
    
    //Ordenes de pedido asociadas a los asesores de una zona
    @GetMapping("/zona/{zona}")
    public List<Order> findByZone(@PathVariable("zona") String zone){
        return orderService.findByZone(zone);
    }
    
    // Ordenes de un asesor
    @GetMapping("/salesman/{id}")
    public List<Order> ordersSalesManByID(@PathVariable("id") Integer id){
        return orderService.ordersSalesManByID(id);
    }
    
    //Ordenes de un asesor x Estado
    @GetMapping("/state/{state}/{id}")
    public List<Order> ordersSalesManByState(@PathVariable("state") String state, @PathVariable("id") Integer id){
        return orderService.ordersSalesManByState(state, id);
    }
    
    //Ordenes de un asesor x Fecha
    @GetMapping("/date/{date}/{id}")
    public List<Order> ordersSalesManByDate(@PathVariable("date") String dateStr, @PathVariable("id") Integer id) {
        return orderService.ordersSalesManByDate(dateStr,id);
    }

}
