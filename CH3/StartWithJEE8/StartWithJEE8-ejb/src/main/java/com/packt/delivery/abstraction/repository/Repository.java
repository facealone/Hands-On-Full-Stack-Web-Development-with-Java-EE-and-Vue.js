package com.packt.delivery.abstraction.repository;

import java.util.List;

public interface Repository<T> {
    List<T> getAll();
    T save(T user);
    T update(T user);
}
