package com.example.mvc_project.model.dao.client;

import com.example.mvc_project.model.entity.Client;
import org.springframework.data.repository.CrudRepository;

public interface ClientRepository extends CrudRepository<Client, Integer> {
}
