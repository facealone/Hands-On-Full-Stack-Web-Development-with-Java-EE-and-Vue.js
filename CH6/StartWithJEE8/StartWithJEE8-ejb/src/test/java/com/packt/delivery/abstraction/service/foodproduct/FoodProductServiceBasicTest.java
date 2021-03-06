
package com.packt.delivery.abstraction.service.foodproduct;

import com.packt.delivery.abstraction.entity.FoodProduct;
import com.packt.delivery.abstraction.repository.FoodProductRepository;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class FoodProductServiceBasicTest {
    @Mock
    private FoodProductRepository foodProductRepository;
    
    @InjectMocks
    private FoodProductServiceBasic foodProductServiceBasic;
    
    @Test
    public void getByFoodService_onlyActives_ok(){
        FoodProduct foodProduct1 = new FoodProduct(1, "Pizza", 23500, "Pinaple Pizza", true, "imageUrl", "email1@email.com");
        
        FoodProduct foodProduct2 = new FoodProduct(2, "Pizza", 23500, "Cheese Pizza Old", false, "imageUrl2", "email1@email.com");
        
        when(foodProductRepository.getByFoodService("email1@email.com")).thenReturn(Arrays.asList(foodProduct1, foodProduct2));
        
        List<FoodProduct> foodProducts = foodProductServiceBasic.getByFoodService("email1@email.com");
        
        assertThat(foodProducts).isEqualTo(Arrays.asList(foodProduct1));
    }
    
    @Test
    public void save_passThrough_ok(){
        FoodProduct foodProduct1 = new FoodProduct(1, "Pizza", 23500, "Pinaple Pizza", true, "imageUrl", "email1@email.com");
        
        when(foodProductRepository.save(foodProduct1)).thenReturn(foodProduct1);
        
        FoodProduct foodProduct = foodProductServiceBasic.save(foodProduct1);
        
        assertThat(foodProduct).isEqualTo(foodProduct1);
    }
    
    @Test
    public void update_passThrough_ok(){
        FoodProduct foodProduct1 = new FoodProduct(1, "Pizza", 23500, "Pinaple Pizza", true, "imageUrl", "email1@email.com");
        
        when(foodProductRepository.update(foodProduct1)).thenReturn(foodProduct1);
        
        FoodProduct foodProduct = foodProductServiceBasic.update(foodProduct1);
        
        assertThat(foodProduct).isEqualTo(foodProduct1);
    }
    
    @Test
    public void deActivate_toFalse_ok(){
        FoodProduct foodProduct1 = new FoodProduct(1, "Pizza", 23500, "Pinaple Pizza", true, "imageUrl", "email1@email.com");
        FoodProduct foodProductDeactivated = new FoodProduct(1, "Pizza", 23500, "Pinaple Pizza", false, "imageUrl", "email1@email.com");
        
        when(foodProductRepository.getById(1)).thenReturn(Optional.ofNullable(foodProduct1));
        when(foodProductRepository.update(foodProduct1)).thenReturn(foodProduct1);
        
        FoodProduct foodProduct = foodProductServiceBasic.deActivate(1);
        
        assertThat(foodProduct).isEqualTo(foodProductDeactivated);
    }
}
