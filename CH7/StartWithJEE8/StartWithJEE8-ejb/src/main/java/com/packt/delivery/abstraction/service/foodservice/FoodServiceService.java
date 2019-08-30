
package com.packt.delivery.abstraction.service.foodservice;

import com.packt.delivery.abstraction.entity.FoodService;
import com.packt.delivery.abstraction.entity.User;
import java.util.List;
import java.util.Optional;

public interface FoodServiceService {
    Optional<FoodService> login(User user);
    FoodService save(FoodService foodService);
    FoodService update(FoodService foodService);
    FoodService deActivate(String email);
    List<FoodService> getByFoodType(String foodType, Integer page, Integer pageSize);
}
