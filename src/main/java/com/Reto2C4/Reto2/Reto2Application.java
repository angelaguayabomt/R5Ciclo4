package com.Reto2C4.Reto2;

import com.Reto2C4.Reto2.interfaces.InterfaceOrder;
import com.Reto2C4.Reto2.interfaces.InterfacePeripheral;
import com.Reto2C4.Reto2.interfaces.InterfaceUser;
import com.Reto2C4.Reto2.repositorio.OrderRepositorio;
import com.Reto2C4.Reto2.repositorio.UserRepositorio;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

@Component
@SpringBootApplication
public class Reto2Application implements CommandLineRunner {
        
@Autowired
    private InterfacePeripheral crudRepository;
    @Autowired
    private InterfaceUser InterfaceUser;
    @Autowired
    private InterfaceOrder InterfaceOrder;
    
    @Autowired
    private UserRepositorio UserRepositorio;
    
    @Autowired
    private OrderRepositorio OrderRepositorio;
    
    @Autowired
    private MongoTemplate mongoTemplate;

    public static void main(String[] args) {
        SpringApplication.run(Reto2Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        crudRepository.deleteAll();
        InterfaceUser.deleteAll();
        InterfaceOrder.deleteAll();
    }
}