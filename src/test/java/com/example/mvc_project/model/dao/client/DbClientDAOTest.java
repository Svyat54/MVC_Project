package com.example.mvc_project.model.dao.client;

import com.example.mvc_project.model.entity.Client;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
class DbClientDAOTest {
    @Autowired
    DbClientDAO dbClientDAO;

    @Test
    void findAll() {
        List<Client> clients = dbClientDAO.findAll();
        for(Client client : clients)
            System.out.println(client);
    }

    @Test
    void findById() {
        System.out.println(dbClientDAO.findById(1));
    }

    @Test
    void save() {
        dbClientDAO.save(new Client("John"));
    }

    @Test
    void update() {
        Client client = new Client(1,"Olga");
        System.out.println(dbClientDAO.update(client));
    }

    @Test
    void delete() {
        System.out.println(dbClientDAO.delete(3));
    }
}