package com.packt.delivery.main.restful.delivery;

import com.packt.delivery.main.restful.RestfulApplication;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.container.test.api.RunAsClient;
import org.jboss.arquillian.extension.rest.client.ArquillianResteasyResource;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.junit.InSequence;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;

@RunWith(Arquillian.class)
public class DeliveryControllerBasicTest {
    @Deployment(testable = false)
    public static WebArchive createDeployment() {
        Path p = Paths.get("../StartWithJEE8-ejb/src/test/resources/META-INF/persistence.xml");
        Path p1 = Paths.get("../StartWithJEE8-ejb/src/test/resources/META-INF/deliverydata.sql");
        WebArchive a = //ShrinkWrap.createFromZipFile(WebArchive.class, new File("/home/daniel/NetBeansProjects/webtest/target/webtest-1.0-SNAPSHOT.war"))
                ShrinkWrap.create(WebArchive.class)
                .addPackages(true, "com.packt.delivery")
                //.addClasses(DeliveryController.class, DeliveryControllerBasic.class, RestfulApplication.class)
                .addAsResource(p.toFile(), "META-INF/persistence.xml")
                .addAsResource(p1.toFile(), "META-INF/data.sql")
                //.addAsResource(p.toFile(), "persistence.sql")
                //.addAsResource(p1.toFile(), "data.sql")
                //.addAsWebInfResource("index.html")
                ;
        
        System.out.println(a.toString(true));
        
        return a;
    }

    @Test
    @RunAsClient
    @InSequence(1)
    public void getDeliveriesByEmailAndState_emailAndState_list(@ArquillianResteasyResource("api") /*WebTarget webTarget*/ DeliveryController deliveryController) throws IOException {
       //Response response = webTarget
        //.path("/deliveries/email@email.com?state=PENDING")
        //.path("deliveries")
        //.request(MediaType.APPLICATION_JSON)
        //.get();
//ObjectMapper objectMapper = new ObjectMapper();
      //  DeliveryDTO a = objectMapper.readValue("{}", DeliveryDTO.class);
//System.out.println(response.getStatusInfo());
System.out.println(deliveryController.getByEmailAndState("email5@email.com", "PENDING"));
        /*List<DeliveryDTO> deliveries = deliveryController.getByEmailAndState("email5@email.com", "PENDING");

        assertThat(deliveries).isEqualTo(Arrays.asList(delivery));*/
    }
    
}
