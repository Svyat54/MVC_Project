package com.example.mvc_project.model.dao;

import java.util.List;
import java.util.Optional;

public interface IDaoBase<E> {
    List<E> findAll();
    Optional<E> findById(Integer id);
    E save(E e);
    E update(E e);
    String delete(Integer id);
}
