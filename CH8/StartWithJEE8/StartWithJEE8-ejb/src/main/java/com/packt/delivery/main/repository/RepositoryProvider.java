package com.packt.delivery.main.repository;

import com.packt.delivery.main.Infrastructure;
import com.packt.delivery.main.repository.delivery.DeliveryRepositoryJPA;
import com.packt.delivery.main.repository.foodproduct.FoodProductRepositoryJPA;
import com.packt.delivery.main.repository.foodservice.FoodServiceRepositoryJPA;
import com.packt.delivery.main.security.foodservice.keycloak.KeyCloakFoodServiceRepository;
import java.util.Properties;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.client.Client;
import org.keycloak.admin.client.Keycloak;

@Stateless
@LocalBean
public class RepositoryProvider {

    @PersistenceContext
    private EntityManager em;

    @Produces
    public EntityManager getEntityManager() {
        return em;
    }

    @Produces
    public FoodServiceRepositoryJPA getFoodServiceRepositoryJPA(EntityManager entityManager) {
        return new FoodServiceRepositoryJPA(entityManager);
    }

    @Produces
    public DeliveryRepositoryJPA getDeliveryRepositoryJPA(EntityManager entityManager) {
        return new DeliveryRepositoryJPA(entityManager);
    }

    @Produces
    public FoodProductRepositoryJPA getFoodProductRepositoryJPA(EntityManager entityManager) {
        return new FoodProductRepositoryJPA(entityManager);
    }

    @Produces
    @Infrastructure
    public KeyCloakFoodServiceRepository getKeyCloakFoodServiceRepository(Properties properties) {
        Keycloak keycloak = Keycloak.getInstance(
                properties.getProperty("SSO_AUTH_URL"),
                "master",
                properties.getProperty("SSO_AUTH_USER"),
                properties.getProperty("SSO_AUTH_PASSWORD"),
                "admin-cli");
        
        return new KeyCloakFoodServiceRepository(keycloak, properties.getProperty("SSO_REALM"));
    }
}
