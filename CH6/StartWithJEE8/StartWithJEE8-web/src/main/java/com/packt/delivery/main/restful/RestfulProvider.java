package com.packt.delivery.main.restful;

import com.packt.delivery.abstraction.repository.DeliveryRepository;
import com.packt.delivery.abstraction.service.delivery.DeliveryService;
import com.packt.delivery.abstraction.service.delivery.DeliveryServiceBasic;
import com.packt.delivery.main.Infrastructure;
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
}
