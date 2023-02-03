package com.example.mvc_project.model.dao.client;

import com.example.mvc_project.model.entity.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//имплементация дао клиента для работы с базой
@Service
public class DbClientDAO implements IClientDAO{
    @Autowired
    private ClientRepository clientRepository;

    @Override
    public List<Client> findAll() {
        return (List<Client>) clientRepository.findAll();
    }

    @Override
    public Optional<Client> findById(Integer id) {
        return clientRepository.findById(id);
    }

    @Override
    public Client save(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public Client update(Client client) {
        if(clientRepository.findById(client.getId()).isPresent())
            return clientRepository.save(client);
        return null;
    }

    @Override
    public String delete(Integer id) {
        clientRepository.deleteById(id);
        return "delete id: " + id;
    }
}
