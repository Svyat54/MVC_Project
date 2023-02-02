package com.example.mvc_project.model.dao.order;

import com.example.mvc_project.model.entity.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Integer> {
}
