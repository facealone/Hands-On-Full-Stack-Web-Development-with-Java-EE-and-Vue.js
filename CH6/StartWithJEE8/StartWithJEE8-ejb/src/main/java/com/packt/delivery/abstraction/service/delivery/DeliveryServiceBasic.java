
package com.packt.delivery.abstraction.service.delivery;

import com.packt.delivery.abstraction.entity.Delivery;
import com.packt.delivery.abstraction.repository.DeliveryRepository;
import java.util.List;

public class DeliveryServiceBasic implements DeliveryService{
   private final DeliveryRepository deliveryRepository;
   
   public DeliveryServiceBasic(DeliveryRepository deliveryRepository){
       this.deliveryRepository = deliveryRepository;
   }
   
   public List<Delivery> getByEmailAndState(String email, String state){
       return deliveryRepository.getByEmailAndState(email, state);
   }
}
