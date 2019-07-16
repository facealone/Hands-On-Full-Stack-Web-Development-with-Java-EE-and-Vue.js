package com.packt.delivery.abstraction.repository;

import com.packt.delivery.abstraction.entity.FoodService;
import java.util.List;

public interface FoodServiceRepository extends Repository<FoodService>{
    List<FoodService> getByFoodType(String foodType);
}
