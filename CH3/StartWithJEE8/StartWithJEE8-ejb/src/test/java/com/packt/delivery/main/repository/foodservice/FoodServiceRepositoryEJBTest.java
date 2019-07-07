package com.packt.delivery.main.repository.foodservice;

import com.packt.delivery.abstraction.entity.FoodService;
import com.packt.delivery.abstraction.entity.User;
import com.packt.delivery.abstraction.repository.FoodServiceRepository;
import com.packt.delivery.main.Infrastructure;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javax.inject.Inject;
import static org.assertj.core.api.Assertions.assertThat;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.junit.InSequence;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;


@RunWith(Arquillian.class)
public class FoodServiceRepositoryEJBTest {
    
    @Inject
    @Infrastructure
    private FoodServiceRepository foodServiceRepository;

    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackages(true, "com.packt.delivery")
                .addAsResource("META-INF/persistence.xml")
                .addAsResource("META-INF/foodservicedata.sql", "META-INF/data.sql")
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }

    @Test
    @InSequence(1)
    public void getAll_basicData_same() {
        User user = new User("email1@email.com", "pass1");
        FoodService foodService = new FoodService("email1@email.com", "Pizzas 25", "Street 89", "PIZZA", 100, true, user, Collections.emptyList());
        
        List<FoodService> foodServices = foodServiceRepository.getAll();

        assertThat(foodServices).isEqualTo(Arrays.asList(foodService));
    }
    
    @Test
    @InSequence(2)
    public void save_new_getAll() {
        User user = new User("email1@email.com", "pass1");
        FoodService foodService = new FoodService("email1@email.com", "Pizzas 25", "Street 89", "PIZZA", 100, true, user, Collections.emptyList());
        
        User userExpected = new User("chicken@email.com", "pass2");
        FoodService foodServiceExpected = new FoodService("chicken@email.com", "Chicken Cool", "Street 898", "CHICKEN", 120, true, userExpected, Collections.emptyList());
        
        foodServiceExpected = foodServiceRepository.save(foodServiceExpected);
        
        List<FoodService> foodServices = foodServiceRepository.getAll();

        assertThat(foodServices).isEqualTo(Arrays.asList(foodService, foodServiceExpected));
    }
    
    @Test
    @InSequence(3)
    public void update_state_updated() {
        User user = new User("email1@email.com", "pass1");
        FoodService foodService = new FoodService("email1@email.com", "Pizzas 25", "Street 89", "PIZZA", 100, true, user, Collections.emptyList());
        
        User userExpected = new User("chicken@email.com", "pass2");
        FoodService foodServiceExpected = new FoodService("chicken@email.com", "Chicken Cool Other", "Street 898", "CHICKEN", 120, true, userExpected, Collections.emptyList());
         
        foodServiceExpected = foodServiceRepository.update(foodServiceExpected);
        
        List<FoodService> foodServices = foodServiceRepository.getAll();

        assertThat(foodServices).isEqualTo(Arrays.asList(foodService, foodServiceExpected));
    }
    
    @Test
    @InSequence(4)
    public void getDeliveriesByEmailAndState_emailAndState_list() {
        User user = new User("email1@email.com", "pass1");
        FoodService foodService = new FoodService("email1@email.com", "Pizzas 25", "Street 89", "PIZZA", 100, true, user, Collections.emptyList());
        
        List<FoodService> foodServices = foodServiceRepository.getFoodServicesByFoodType("PIZZA");

        assertThat(foodServices).isEqualTo(Arrays.asList(foodService));
    }
}
