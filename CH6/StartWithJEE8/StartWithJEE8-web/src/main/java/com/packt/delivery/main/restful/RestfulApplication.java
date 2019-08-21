package com.packt.delivery.main.restful;

import com.packt.delivery.main.restful.delivery.DeliveryController;
import java.util.HashSet;
import java.util.Set;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("api")
public class RestfulApplication extends Application {
    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> classes = new HashSet<>();
        classes.add(DeliveryController.class);
        return classes;
    }

}
