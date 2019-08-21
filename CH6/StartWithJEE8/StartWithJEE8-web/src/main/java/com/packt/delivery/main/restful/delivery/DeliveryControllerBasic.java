
package com.packt.delivery.main.restful.delivery;

import com.packt.delivery.abstraction.entity.Delivery;
import com.packt.delivery.abstraction.service.delivery.DeliveryService;
import java.util.List;
import java.util.stream.Collectors;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
@LocalBean
public class DeliveryControllerBasic implements DeliveryController{
    @Inject
    private DeliveryService deliveryService;
 
    @Override
    public List<DeliveryDTO> getByEmailAndState(String email, String state) {
        return deliveryService.getByEmailAndState(email, state)
                .stream()
                .map(d -> new DeliveryDTO(d))
                .collect(Collectors.toList());
    }

    @Override
    public DeliveryDTO request(DeliveryDTO delivery) {
        return new DeliveryDTO(deliveryService.request(delivery.toDelivery()));
    }
}
