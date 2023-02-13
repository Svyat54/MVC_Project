package com.example.mvc_project.controller;

import com.example.mvc_project.model.dao.item.IItemDAO;
import com.example.mvc_project.model.dao.order.IOrderDAO;
import com.example.mvc_project.model.dao.ordersItem.IOrdersItemDAO;
import com.example.mvc_project.model.entity.Item;
import com.example.mvc_project.model.entity.Order;
import com.example.mvc_project.model.entity.OrdersItem;
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
@RequestMapping("/ordersItem")
public class OrdersItemController {
    @Autowired
    private IOrdersItemDAO iOrdersItemDAO;
    @Autowired
    private IItemDAO iItemDAO;
    @Autowired
    private IOrderDAO iOrderDAO;

    @GetMapping("/all")
    public String getAll(Model model){
        model.addAttribute("ordersItem", iOrdersItemDAO.findAll());
        return "ordersItem/ordersItem-list";
    }

    @GetMapping("/add")
    public String getAdd(Model model){
        OrdersItem ordersItem = new OrdersItem();
        List<Item> items = iItemDAO.findAll();
        List<Order> orders = iOrderDAO.findAll();
        model.addAttribute("ordersItem", ordersItem);
        model.addAttribute("items", items);
        model.addAttribute("orders", orders);
        return "ordersItem/ordersItem-form";
    }

    @PostMapping("/add")
    public String add(OrdersItem ordersItem, RedirectAttributes ra){
        iOrdersItemDAO.save(ordersItem);
        ra.addFlashAttribute("goodMsg", "OrdersItem " + ordersItem + " added");
        return "redirect:/ordersItem/all";
    }

    @GetMapping("/delete/{id}")
    public String deleteById(@PathVariable("id") Integer id){
        iOrdersItemDAO.delete(id);
        return "redirect:/ordersItem/all";
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable("id") Integer id, Model model){
        Optional<OrdersItem> ordersItem = iOrdersItemDAO.findById(id);
        List<Item> items = iItemDAO.findAll();
        List<Order> orders = iOrderDAO.findAll();
        model.addAttribute("ordersItem", ordersItem);
        model.addAttribute("items", items);
        model.addAttribute("orders", orders);
        return "ordersItem/ordersItem-update";
    }

    @PostMapping("/update")
    public String updateOI(OrdersItem ordersItem){
        iOrdersItemDAO.update(ordersItem);
        return "redirect:/ordersItem/all";
    }

    @GetMapping("/detail/{id}")
    public String detail(@PathVariable("id") Integer id, Model model){
        Optional<OrdersItem> ordersItem = iOrdersItemDAO.findById(id);
        model.addAttribute("ordersItem", ordersItem);
        return "ordersItem/ordersItem-detail";
    }
}
