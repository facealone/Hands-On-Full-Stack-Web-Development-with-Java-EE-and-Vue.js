package com.packt.delivery.main.repository;

import com.packt.delivery.main.repository.delivery.DeliveryRepositoryJPA;
import com.packt.delivery.main.repository.user.UserRepositoryJPA;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
    public UserRepositoryJPA getUserRepositoryJPA(EntityManager entityManager) {
        return new UserRepositoryJPA(entityManager);
    }
    
    @Produces
    public DeliveryRepositoryJPA getDeliveryRepositoryJPA(EntityManager entityManager) {
        return new DeliveryRepositoryJPA(entityManager);
    }
}
