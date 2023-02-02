package com.example.mvc_project.model.dao.item;

import com.example.mvc_project.model.entity.Item;
import org.springframework.data.repository.CrudRepository;

public interface ItemRepository extends CrudRepository<Item, Integer> {
}
