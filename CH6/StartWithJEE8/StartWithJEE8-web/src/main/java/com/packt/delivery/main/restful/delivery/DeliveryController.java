
package com.packt.delivery.main.restful.delivery;

import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("deliveries")
public interface DeliveryController {
    @GET    
    @Path("{email}")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    List<DeliveryDTO> getByEmailAndState(@PathParam("email") String email, @QueryParam("state") String state);  
    //String getByEmailAndState();
}
