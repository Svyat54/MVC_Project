package com.example.mvc_project.model.dao.order;

import com.example.mvc_project.model.dao.client.DbClientDAO;
import com.example.mvc_project.model.entity.Client;
import com.example.mvc_project.model.entity.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class DbOrderDAOTest {
    @Autowired
    DbOrderDAO dbOrderDAO;
    @Autowired
    DbClientDAO clientDAO;

    @Test
    void findAll() {
        List<Order> orders = dbOrderDAO.findAll();
        for(Order order : orders)
            System.out.println(order);
    }

    @Test
    void findById() {
        System.out.println(dbOrderDAO.findById(3));
    }

    @Test
    void save() {
        System.out.println(dbOrderDAO.save(new Order("Покупка товара по банковской карте",
                clientDAO.findById(1).get())));
        System.out.println(dbOrderDAO.save(new Order("Покупка товара по банковской карте",
                clientDAO.findById(4).get())));
        System.out.println(dbOrderDAO.save(new Order("Покупка товара в кредит", clientDAO.findById(1).get())));
        System.out.println(dbOrderDAO.save(new Order("Покупка товара в кредит", clientDAO.findById(4).get())));
        System.out.println(dbOrderDAO.save(new Order("Товар украл", clientDAO.findById(4).get())));
    }

    @Test
    void update() {
        Order order = new Order(5, "Товар украл", clientDAO.findById(1).get());
        System.out.println(dbOrderDAO.update(order));
    }

    @Test
    void delete() {
        System.out.println(dbOrderDAO.delete(5));
    }
}