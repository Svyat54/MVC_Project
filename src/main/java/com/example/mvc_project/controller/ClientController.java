package com.example.mvc_project.controller;

import com.example.mvc_project.model.dao.client.IClientDAO;
import com.example.mvc_project.model.entity.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping("/client")
public class ClientController {
    @Autowired
    private IClientDAO iClientDAO;

    @GetMapping("/all")
    public String getAll(Model model){
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
    public String addNewClient(Client client, RedirectAttributes ra){
        Client newClient = iClientDAO.save(client);
        ra.addFlashAttribute("goodMsg", "Client " + newClient + " added");
        //Редирект на всех клиентов
        return "redirect:/client/all";
    }

    @GetMapping("/delete/{id}")
    public String deleteById(@PathVariable("id") Integer id){
        iClientDAO.delete(id);
        return "redirect:/client/all";
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable("id") Integer id, Model model){
        Optional<Client> client = iClientDAO.findById(id);
        model.addAttribute("client", client);
        return "client/client-update";
    }
    @PostMapping("/update")
    public String updateCl(Client client){
        iClientDAO.update(client);
        return "redirect:/client/all";
    }

    @GetMapping("/detail/{id}")
    public String detail(@PathVariable("id") Integer id, Model model){
        Optional<Client> client = iClientDAO.findById(id);
        model.addAttribute("client", client);
        return "client/client-detail";
    }
}


