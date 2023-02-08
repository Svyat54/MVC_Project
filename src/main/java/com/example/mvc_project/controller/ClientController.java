package com.example.mvc_project.controller;

import com.example.mvc_project.model.dao.client.IClientDAO;
import com.example.mvc_project.model.entity.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/client")
public class ClientController {
    @Autowired
    private IClientDAO iClientDAO;

    @GetMapping("/all")
    public String getAll(Model model){
//        List<Client> clients = iClientDAO.findAll();
//        model.addAttribute("all", clients);
        model.addAttribute("all", iClientDAO.findAll());
        return "client/client-list";
    }

    @GetMapping("/add")
    public String getAddForm(Model model){
        Client client = new Client(); // для привязке к форме
        model.addAttribute("client", client);
        return "client/client-form";
    }
    @PostMapping("/add")
    public String addNewClient(Client client){
        Client newClient = iClientDAO.save(client);
        //Редирект на всех клиентов
        return "redirect:/client/all";
    }
}


