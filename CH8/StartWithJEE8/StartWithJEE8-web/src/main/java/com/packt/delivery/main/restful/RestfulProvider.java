package com.packt.delivery.main.restful;

import com.packt.delivery.abstraction.repository.DeliveryRepository;
import com.packt.delivery.abstraction.repository.FoodProductRepository;
import com.packt.delivery.abstraction.repository.FoodServiceRepository;
import com.packt.delivery.abstraction.service.delivery.DeliveryService;
import com.packt.delivery.abstraction.service.delivery.DeliveryServiceBasic;
import com.packt.delivery.abstraction.service.file.StorageService;
import com.packt.delivery.abstraction.service.foodproduct.FoodProductService;
import com.packt.delivery.abstraction.service.foodproduct.FoodProductServiceBasic;
import com.packt.delivery.abstraction.service.foodservice.FoodServiceService;
import com.packt.delivery.abstraction.service.foodservice.FoodServiceServiceBasic;
import com.packt.delivery.main.Infrastructure;
import com.packt.delivery.main.storage.disk.DiskStorageService;
import java.util.Properties;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.enterprise.inject.Produces;

@Stateless
@LocalBean
public class RestfulProvider {

    @Produces
    public DeliveryService getDeliveryService(
            @Infrastructure DeliveryRepository deliveryRepository) {
        return new DeliveryServiceBasic(deliveryRepository);
    }
    
    @Produces
    public FoodProductService getFoodProductService(
            @Infrastructure FoodProductRepository foodProductRepository) {
        return new FoodProductServiceBasic(foodProductRepository);
    }
    
    @Produces
    public FoodServiceService getFoodServiceService(
            @Infrastructure FoodServiceRepository foodServiceRepository) {
        return new FoodServiceServiceBasic(foodServiceRepository);
    }
    
    @Produces
    public StorageService getStorageService(Properties properties) {
        return new DiskStorageService(properties.getProperty("STORAGE_PATH"));
    }
}
