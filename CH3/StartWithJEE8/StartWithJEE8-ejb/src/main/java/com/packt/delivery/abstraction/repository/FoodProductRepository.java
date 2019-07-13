package com.packt.delivery.abstraction.repository;

import com.packt.delivery.abstraction.entity.FoodProduct;
import java.util.List;

public interface FoodProductRepository extends Repository<FoodProduct>{
    List<FoodProduct> getByFoodService(String email);
}
