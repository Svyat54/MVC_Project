package com.example.mvc_project.model.dao.ordersItem;

import com.example.mvc_project.model.dao.item.DbItemDAO;
import com.example.mvc_project.model.dao.order.DbOrderDAO;
import com.example.mvc_project.model.entity.OrdersItem;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class DbOrdersItemDAOTest {
    @Autowired
    DbOrdersItemDAO dbOrdersItemDAO;
    @Autowired
    DbOrderDAO dbOrderDAO;
    @Autowired
    DbItemDAO dbItemDAO;

    @Test
    void findAll() {
        List<OrdersItem> ordersItems = dbOrdersItemDAO.findAll();
        for(OrdersItem ordersItem : ordersItems)
            System.out.println(ordersItem);
    }

    @Test
    void findById() {
        System.out.println(dbOrdersItemDAO.findById(2));
    }

    @Test
    void save() {
        System.out.println(dbOrdersItemDAO.save(new OrdersItem(5, dbItemDAO.findById(4).get(),
                dbOrderDAO.findById(4).get())));
        System.out.println(dbOrdersItemDAO.save(new OrdersItem(3, dbItemDAO.findById(7).get(),
                dbOrderDAO.findById(3).get())));
        System.out.println(dbOrdersItemDAO.save(new OrdersItem(2, dbItemDAO.findById(3).get(),
                dbOrderDAO.findById(2).get())));
        System.out.println(dbOrdersItemDAO.save(new OrdersItem(4, dbItemDAO.findById(7).get(),
                dbOrderDAO.findById(1).get())));
        System.out.println(dbOrdersItemDAO.save(new OrdersItem(15, dbItemDAO.findById(2).get(),
                dbOrderDAO.findById(6).get())));
    }

    @Test
    void update() {
        OrdersItem ordersItem = new OrdersItem(3,3, dbItemDAO.findById(3).get(), dbOrderDAO.findById(2).get());
        System.out.println(dbOrdersItemDAO.update(ordersItem));
    }

    @Test
    void delete() {
        System.out.println(dbOrdersItemDAO.delete(5));
    }
}