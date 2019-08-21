
package com.packt.delivery.main.restful.delivery;

import com.packt.delivery.abstraction.service.delivery.DeliveryService;
import java.util.List;
import java.util.stream.Collectors;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;

@Stateless
@LocalBean
//@Path("deliveries")
public class DeliveryControllerBasic implements DeliveryController{
    @Inject
    private DeliveryService deliveryService;
 
    /*@GET    
    @Path("{email}")*/
    public List<DeliveryDTO> getByEmailAndState(String email, String state) {
        return deliveryService.getByEmailAndState(email, state)
                .stream()
                .map(d -> new DeliveryDTO(d))
                .collect(Collectors.toList());
    }
    
    public String getByEmailAndState(){
        return "hola";
    }
}
