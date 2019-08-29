package com.packt.delivery.abstraction.repository;

import com.packt.delivery.abstraction.entity.FoodService;
import java.util.List;
import java.util.Optional;

public interface FoodServiceRepository extends Repository<FoodService>{
    List<FoodService> getByFoodType(String foodType);
    Optional<FoodService> getById(String email);
    Optional<FoodService> getByEmailAndPassword(String email, String password);
}
