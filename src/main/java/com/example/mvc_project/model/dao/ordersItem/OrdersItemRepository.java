package com.example.mvc_project.model.dao.ordersItem;

import com.example.mvc_project.model.entity.OrdersItem;
import org.springframework.data.repository.CrudRepository;

public interface OrdersItemRepository extends CrudRepository<OrdersItem, Integer> {
}
