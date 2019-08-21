package com.packt.delivery.main.restful.delivery;

import com.packt.delivery.main.restful.foodproduct.FoodProductDTO;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import static org.assertj.core.api.Java6Assertions.assertThat;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.container.test.api.RunAsClient;
import org.jboss.arquillian.extension.rest.client.ArquillianResteasyResource;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.junit.InSequence;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(Arquillian.class)
public class DeliveryControllerBasicTest {

    @Deployment(testable = false)
    public static WebArchive createDeployment() {
        Path persistence = Paths.get("../StartWithJEE8-ejb/src/test/resources/META-INF/persistence.xml");
        Path deliveryData = Paths.get("../StartWithJEE8-ejb/src/test/resources/META-INF/deliverydata.sql");

        return ShrinkWrap.create(WebArchive.class)
                .addPackages(true, "com.packt.delivery")
                .addAsResource(persistence.toFile(), "META-INF/persistence.xml")
                .addAsResource(deliveryData.toFile(), "META-INF/data.sql");
    }

    @Test
    @RunAsClient
    @InSequence(1)
    public void getDeliveriesByEmailAndState_emailAndState_list(@ArquillianResteasyResource("api") /*WebTarget webTarget*/ DeliveryController deliveryController) throws IOException {
        FoodProductDTO foodProduct = new FoodProductDTO(1, "Pizza", 23500, "Pinaple Pizza", true, "imageUrl", "email1@email.com");
        ItemDTO item = new ItemDTO(1, 1, foodProduct);
        DeliveryDTO delivery = new DeliveryDTO(1, "Street 50", "555233564", 23600, 100, "email5@email.com", "PENDING", Arrays.asList(item));

        List<DeliveryDTO> deliveries = deliveryController.getByEmailAndState("email5@email.com", "PENDING");

        assertThat(deliveries).isEqualTo(Arrays.asList(delivery));
    }

}
