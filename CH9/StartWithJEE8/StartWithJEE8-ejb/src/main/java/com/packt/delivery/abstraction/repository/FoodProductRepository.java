package com.packt.delivery.abstraction.repository;

import com.packt.delivery.abstraction.entity.FoodProduct;
import java.util.List;
import java.util.Optional;

public interface FoodProductRepository extends Repository<FoodProduct>{
    List<FoodProduct> getByFoodService(String foodService, Integer page, Integer pageSize);
    Optional<FoodProduct> getById(Integer id);
}
