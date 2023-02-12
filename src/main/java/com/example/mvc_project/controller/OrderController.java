package com.example.mvc_project.controller;

import com.example.mvc_project.model.dao.client.IClientDAO;
import com.example.mvc_project.model.dao.order.IOrderDAO;
import com.example.mvc_project.model.entity.Client;
import com.example.mvc_project.model.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private IOrderDAO iOrderDAO;
    @Autowired
    private IClientDAO iClientDAO;

    @GetMapping("/all")
    public String getAll(Model model){
        model.addAttribute("orders", iOrderDAO.findAll());
        return "order/order-list";
    }

    @GetMapping("/add")
    public String getAdd(Model model){
        Order order = new Order();
        List<Client> clients= iClientDAO.findAll();
        model.addAttribute("order", order);
        model.addAttribute("clients", clients);
        return "order/order-form";
    }

    @PostMapping("/add")
    public String add(Order order, RedirectAttributes ra){
        iOrderDAO.save(order);
        ra.addFlashAttribute("goodMsg", "Order " + order + " added");
        return "redirect:/order/all";
    }

    @GetMapping("/delete/{id}")
    public String deleteById(@PathVariable("id") Integer id){
        iOrderDAO.delete(id);
        return "redirect:/order/all";
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable("id") Integer id, Model model){
        Optional<Order> order = iOrderDAO.findById(id);
        List<Client> clients = iClientDAO.findAll();
        model.addAttribute("order", order);
        model.addAttribute("clients", clients);
        return "order/order-update";
    }

    @PostMapping("/update")
    public String updateOr(Order order){
        iOrderDAO.update(order);
        return "redirect:/order/all";
    }

    @GetMapping("/detail/{id}")
    public String detail(@PathVariable("id") Integer id, Model model){
        Optional<Order> order = iOrderDAO.findById(id);
        model.addAttribute("order", order);
        return "order/order-detail";
    }
}
