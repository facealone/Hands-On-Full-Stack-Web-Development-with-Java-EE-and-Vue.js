
package com.packt.delivery.main.restful.delivery;

import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;

//@Path("deliveries")
public interface DeliveryController {
    //@GET    
    //@Path("{email}")
    List<DeliveryDTO> getByEmailAndState(@PathParam("email") String email, @QueryParam("state") String state);    
}
