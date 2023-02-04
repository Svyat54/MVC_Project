package com.example.mvc_project.model.dao.order;

import com.example.mvc_project.model.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DbOrderDAO implements IOrderDAO{
    @Autowired
    private OrderRepository orderRepository;
    @Override
    public List<Order> findAll() {
        return (List<Order>) orderRepository.findAll();
    }

    @Override
    public Optional<Order> findById(Integer id) {
        return orderRepository.findById(id);
    }

    @Override
    public Order save(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public Order update(Order order) {
        if(orderRepository.findById(order.getId()).isPresent())
            return orderRepository.save(order);
        return null;
    }

    @Override
    public String delete(Integer id) {
        orderRepository.deleteById(id);
        return "delete id: " + id;
    }
}
