package com.example.mvc_project.model.dao.item;

import com.example.mvc_project.model.entity.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DbItemDAO implements IItemDAO{
    @Autowired
    private ItemRepository itemRepository;
    @Override
    public List<Item> findAll() {
        return (List<Item>) itemRepository.findAll();
    }

    @Override
    public Optional<Item> findById(Integer id) {
        return itemRepository.findById(id);
    }

    @Override
    public Item save(Item item) {
        return itemRepository.save(item);
    }

    @Override
    public Item update(Item item) {
        return null;
    }

    @Override
    public String delete(Integer id) {
        itemRepository.deleteById(id);
        return "delete id: " + id;
    }
}
