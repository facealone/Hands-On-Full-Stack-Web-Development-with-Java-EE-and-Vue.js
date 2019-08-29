package com.packt.delivery.main.repository.foodservice;

import com.packt.delivery.abstraction.entity.FoodService;
import com.packt.delivery.abstraction.entity.User;
import com.packt.delivery.abstraction.repository.FoodServiceRepository;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.persistence.EntityManager;

public class FoodServiceRepositoryJPA implements FoodServiceRepository {

    private final EntityManager entityManager;

    public FoodServiceRepositoryJPA(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    
    @Override
    public FoodService save(FoodService foodService) {
        FoodServiceData foodServiceData = convertFoodServiceToFoodServiceData(foodService);

        entityManager.persist(foodServiceData);

        return foodService;
    }

    @Override
    public FoodService update(FoodService foodService) {
        FoodServiceData foodServiceData = convertFoodServiceToFoodServiceData(foodService);

        entityManager.merge(foodServiceData);

        return foodService;
    }

    @Override
    public List<FoodService> getAll() {
        return entityManager.createNamedQuery("FoodServiceData.findAll", FoodServiceData.class)
                .getResultList()
                .stream()
                .map(this::convertFoodServiceDataToFoodService)
                .collect(Collectors.toList());
    }
    

    @Override
    public List<FoodService> getByFoodType(String foodType) {
        return entityManager.createNamedQuery("FoodServiceData.findByFoodType", FoodServiceData.class)
                .setParameter("foodType", foodType)
                .getResultList()
                .stream()
                .map(this::convertFoodServiceDataToFoodService)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<FoodService> getById(String email) {
        return Optional.ofNullable(entityManager.find(FoodServiceData.class, email))
                .map(this::convertFoodServiceDataToFoodService);
    }
    
    @Override
    public Optional<FoodService> getByEmailAndPassword(String email, String password) {
        return entityManager.createNamedQuery("FoodServiceData.findByEmailAndPassword", FoodServiceData.class)
                .setParameter("email", email)
                .setParameter("password", password)
                .getResultList()
                .stream()
                .map(this::convertFoodServiceDataToFoodService)
                .findFirst();
    }
    
    private FoodService convertFoodServiceDataToFoodService(FoodServiceData foodServiceData) {
        User user = new User(foodServiceData.getUserData().getEmail(), foodServiceData.getUserData().getPassword());
        
        return new FoodService(foodServiceData.getEmail(), foodServiceData.getName(), foodServiceData.getAddress(), foodServiceData.getFoodType(), foodServiceData.getDeliveryFee(), foodServiceData.getActive(), user, Collections.emptyList());
    }
    
    private FoodServiceData convertFoodServiceToFoodServiceData(FoodService foodService) {
        FoodServiceData foodServiceData = new FoodServiceData();
        foodServiceData.setActive(foodService.getActive());
        foodServiceData.setAddress(foodService.getAddress());
        foodServiceData.setDeliveryFee(foodService.getDeliveryFee());
        foodServiceData.setEmail(foodService.getEmail());
        foodServiceData.setFoodType(foodService.getFoodType());
        foodServiceData.setName(foodService.getName());
        foodServiceData.setUserData(new UserData(foodService.getUser().getEmail(), foodService.getUser().getPassword()));
        return foodServiceData;
    }
}
