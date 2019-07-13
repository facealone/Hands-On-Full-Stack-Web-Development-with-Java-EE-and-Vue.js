package com.packt.delivery.main.repository.foodproduct;

import com.packt.delivery.abstraction.entity.FoodProduct;
import com.packt.delivery.abstraction.repository.FoodProductRepository;
import com.packt.delivery.main.Infrastructure;
import java.util.List;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
@Local
@Infrastructure
public class FoodProductRepositoryEJB implements FoodProductRepository{
    @Inject
    private FoodProductRepositoryJPA foodProductRepositoryJPA;

    @Override
    public List<FoodProduct> getAll() {
        return foodProductRepositoryJPA.getAll();
    }

    @Override
    public FoodProduct save(FoodProduct foodProduct) {
        return foodProductRepositoryJPA.save(foodProduct);
    }

    @Override
    public FoodProduct update(FoodProduct foodProduct) {
        return foodProductRepositoryJPA.update(foodProduct);
    }

    @Override
    public List<FoodProduct> getByFoodService(String email) {
        return foodProductRepositoryJPA.getByFoodService(email);
    }
}
