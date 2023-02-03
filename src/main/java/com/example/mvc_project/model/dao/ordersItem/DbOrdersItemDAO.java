package com.example.mvc_project.model.dao.ordersItem;

import com.example.mvc_project.model.entity.OrdersItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DbOrdersItemDAO implements IOrdersItemDAO{
    @Autowired
    private OrdersItemRepository ordersItemRepository;
    @Override
    public List<OrdersItem> findAll() {
        return (List<OrdersItem>) ordersItemRepository.findAll();
    }

    @Override
    public Optional<OrdersItem> findById(Integer id) {
        return ordersItemRepository.findById(id);
    }

    @Override
    public OrdersItem save(OrdersItem ordersItem) {
        return ordersItemRepository.save(ordersItem);
    }

    @Override
    public OrdersItem update(OrdersItem ordersItem) {
        return null;
    }

    @Override
    public String delete(Integer id) {
        ordersItemRepository.deleteById(id);
        return "delete id: " + id;
    }
}
