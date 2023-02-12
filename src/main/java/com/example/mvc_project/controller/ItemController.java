package com.example.mvc_project.controller;

import com.example.mvc_project.model.dao.item.IItemDAO;
import com.example.mvc_project.model.entity.Client;
import com.example.mvc_project.model.entity.Item;
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
@RequestMapping("/item")
public class ItemController {
    @Autowired
    private IItemDAO iItemDAO;

    @GetMapping("/all")
    public String getAll(Model model){
        model.addAttribute("all", iItemDAO.findAll());
        return "item/item-list";
    }

    @GetMapping("/add")
    public String getAddForm(Model model){
        Item item = new Item();
        model.addAttribute("item", item);
        return "item/item-form";
    }

    @PostMapping("/add")
    public String addNewItem(Item item, RedirectAttributes ra){
        Item newItem = iItemDAO.save(item);
        ra.addFlashAttribute("goodMsg", "Item " + newItem + " add");
        return "redirect:/item/all";
    }

    @GetMapping("/delete/{id}")
    public String deleteById(@PathVariable("id") Integer id){
        iItemDAO.delete(id);
        return "redirect:/item/all";
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable("id") Integer id, Model model){
        Optional<Item> item = iItemDAO.findById(id);
        model.addAttribute("item", item);
        return "item/item-update";
    }

    @PostMapping("/update")
    public String updateIt(Item item){
        iItemDAO.update(item);
        return "redirect:/item/all";
    }

    @GetMapping("/detail/{id}")
    public String detail(@PathVariable("id") Integer id, Model model){
        Optional<Item> item = iItemDAO.findById(id);
        model.addAttribute("item", item);
        return "item/item-detail";
    }
}
