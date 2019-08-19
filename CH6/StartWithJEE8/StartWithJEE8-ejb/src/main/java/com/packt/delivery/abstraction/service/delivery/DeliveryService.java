
package com.packt.delivery.abstraction.service.delivery;

import com.packt.delivery.abstraction.entity.Delivery;
import java.util.List;

public interface DeliveryService {
    List<Delivery> getByEmailAndState(String email, String state);
    
}
