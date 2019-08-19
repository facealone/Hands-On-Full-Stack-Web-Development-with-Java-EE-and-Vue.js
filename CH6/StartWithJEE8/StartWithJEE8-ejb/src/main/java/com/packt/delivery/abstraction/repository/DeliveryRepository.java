package com.packt.delivery.abstraction.repository;

import com.packt.delivery.abstraction.entity.Delivery;
import java.util.List;

public interface DeliveryRepository extends Repository<Delivery>{
    List<Delivery> getByEmailAndState(String email, String state);
}
