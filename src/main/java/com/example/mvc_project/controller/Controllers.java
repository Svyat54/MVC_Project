package com.example.mvc_project.controller;

import com.example.mvc_project.model.dao.client.DbClientDAO;
import com.example.mvc_project.model.entity.Client;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Controllers {

    @GetMapping("/")
    public String index(){
        return "index";
    }


}
