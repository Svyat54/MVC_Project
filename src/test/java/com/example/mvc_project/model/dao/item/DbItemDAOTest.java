package com.example.mvc_project.model.dao.item;

import com.example.mvc_project.model.entity.Item;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class DbItemDAOTest {
    @Autowired
    DbItemDAO dbItemDAO;

    @Test
    void findAll() {
        List<Item> items = dbItemDAO.findAll();
        for(Item item : items)
            System.out.println(item);
    }

    @Test
    void findById() {
        System.out.println(dbItemDAO.findById(2));
    }

    @Test
    void save() {
        System.out.println(dbItemDAO.save(new Item("Playstation 3", 111L)));
        System.out.println(dbItemDAO.save(new Item("Playstation 4", 222L)));
        System.out.println(dbItemDAO.save(new Item("Playstation 5", 333L)));
        System.out.println(dbItemDAO.save(new Item("X-Box 360", 121L)));
        System.out.println(dbItemDAO.save(new Item("X-Box One", 131L)));
        System.out.println(dbItemDAO.save(new Item("X-Box S", 141L)));
    }

    @Test
    void update() {
        Item item = new Item(1, "PC", 1L);
        System.out.println(dbItemDAO.update(item));
    }

    @Test
    void delete() {
        System.out.println(dbItemDAO.delete(1));
    }
}