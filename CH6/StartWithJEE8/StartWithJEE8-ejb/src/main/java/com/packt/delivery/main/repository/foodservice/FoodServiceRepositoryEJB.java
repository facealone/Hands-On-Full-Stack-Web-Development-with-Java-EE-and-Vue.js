package com.packt.delivery.main.repository.foodservice;

import com.packt.delivery.abstraction.entity.FoodService;
import com.packt.delivery.abstraction.repository.FoodServiceRepository;
import com.packt.delivery.main.Infrastructure;
import java.util.List;
import java.util.Optional;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
@Local
@Infrastructure
public class FoodServiceRepositoryEJB implements FoodServiceRepository{
    @Inject
    private FoodServiceRepositoryJPA foodServiceRepositoryJPA;

    @Override
    public List<FoodService> getAll() {
        return foodServiceRepositoryJPA.getAll();
    }

    @Override
    public FoodService save(FoodService foodService) {
        return foodServiceRepositoryJPA.save(foodService);
    }

    @Override
    public FoodService update(FoodService foodService) {
        return foodServiceRepositoryJPA.update(foodService);
    }

    @Override
    public List<FoodService> getByFoodType(String foodType) {
        return foodServiceRepositoryJPA.getByFoodType(foodType);
    }

    @Override
    public Optional<FoodService> getById(String email) {
        return foodServiceRepositoryJPA.getById(email);
    }
}
