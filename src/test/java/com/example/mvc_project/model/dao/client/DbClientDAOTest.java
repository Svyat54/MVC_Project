package com.example.mvc_project.model.dao.client;

import com.example.mvc_project.model.entity.Client;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
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
}