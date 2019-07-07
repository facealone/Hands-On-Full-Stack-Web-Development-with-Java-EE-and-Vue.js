package com.packt.delivery.main.repository.delivery;

import com.packt.delivery.abstraction.entity.Delivery;
import com.packt.delivery.abstraction.repository.DeliveryRepository;
import com.packt.delivery.main.Infrastructure;
import java.util.List;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
@Local
@Infrastructure
public class DeliveryRepositoryEJB implements DeliveryRepository{
    @Inject
    private DeliveryRepositoryJPA deliveryRepositoryJPA;

    @Override
    public List<Delivery> getAll() {
        return deliveryRepositoryJPA.getAll();
    }

    @Override
    public Delivery save(Delivery delivery) {
        return deliveryRepositoryJPA.save(delivery);
    }

    @Override
    public Delivery update(Delivery delivery) {
        return deliveryRepositoryJPA.update(delivery);
    }
}
