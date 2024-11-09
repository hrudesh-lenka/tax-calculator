package com.hrudesh.taxcalculator.dao;

import java.util.Optional;

public interface DAO<T> {

    T save(T t);

    Optional<T> get(Long id);
}
