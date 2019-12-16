package com.packt.delivery.main.restful;

import com.amazonaws.services.s3.AmazonS3;
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
import com.packt.delivery.abstraction.service.security.OpenIdConnectService;
import com.packt.delivery.abstraction.service.security.OpenIdConnectServiceBasic;
import com.packt.delivery.abstraction.service.security.TokenValidationService;
import com.packt.delivery.main.AWSEnvironment;
import com.packt.delivery.main.Infrastructure;
import com.packt.delivery.main.storage.disk.DiskStorageService;
import com.packt.delivery.main.storage.s3.S3StorageService;
import java.util.Optional;
import java.util.Properties;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.enterprise.inject.Produces;
import javax.ws.rs.client.Client;

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
    public StorageService getDiskStorageService(Properties properties) {
        return new DiskStorageService(properties.getProperty("STORAGE_PATH"));
    }
    
    @Produces
    @AWSEnvironment
    public StorageService getS3StorageService(Properties properties, AmazonS3 s3Client) {
        return new S3StorageService(properties.getProperty("IMAGES_S3_REGION"), properties.getProperty("IMAGES_S3_BUCKET"), s3Client);
    }
    
    @Produces
    public OpenIdConnectService getOpenIdConnectService(TokenValidationService tokenValidationService, Client client, Properties properties) {
        return new OpenIdConnectServiceBasic(tokenValidationService, client, properties.getProperty("SSO_TOKEN_URL"), properties.getProperty("SSO_CLIENT_ID"), properties.getProperty("SSO_CLIENT_SECRET"), properties.getProperty("SSO_CLAIM_ID_NAME"));
    }
}
