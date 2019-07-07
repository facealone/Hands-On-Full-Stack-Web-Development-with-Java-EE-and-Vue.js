
package com.packt.delivery.main.repository.delivery;

import com.packt.delivery.abstraction.entity.Delivery;
import com.packt.delivery.abstraction.entity.FoodProduct;
import com.packt.delivery.abstraction.entity.Item;
import com.packt.delivery.abstraction.repository.DeliveryRepository;
import com.packt.delivery.main.Infrastructure;
import java.util.Arrays;
import java.util.List;
import javax.inject.Inject;
import static org.assertj.core.api.Assertions.assertThat;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.junit.InSequence;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(Arquillian.class)
public class DeliveryRepositoryEJBTest {
    
    @Inject
    @Infrastructure
    private DeliveryRepository deliveryRepository;

    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackages(true, "com.packt.delivery")
                .addAsResource("META-INF/persistence.xml")
                .addAsResource("META-INF/deliverydata.sql", "META-INF/data.sql")
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }

    @Test
    @InSequence(1)
    public void getAll_basicData_same() {
        FoodProduct foodProduct = new FoodProduct(1, "Pizza", 23500, "Pinaple Pizza", true, "imageUrl");
        Item item = new Item(1, 1, foodProduct);
        Delivery delivery = new Delivery(1, "Street 50", "555233564", 23600, 100, Arrays.asList(item));

        List<Delivery> deliveries = deliveryRepository.getAll();

        assertThat(deliveries).isEqualTo(Arrays.asList(delivery));
    }
    
    /*@Test
    @InSequence(2)
    public void save_new_getAll() {
        User daniel = new User("email1@email.com", "pass1", null);
        User hector = new User("email2@email.com", "pass2", null);
        User william = new User("email3@email.com", "pass3", null);

        william = deliveryRepository.save(william);
        
        List<User> users = deliveryRepository.getAll();
      
        assertThat(users).isEqualTo(Arrays.asList(daniel, hector, william));
    }
    
    @Test
    @InSequence(3)
    public void update_new_getAll() {
        User daniel = new User("email1@email.com", "pass1", null);
        User hector = new User("email2@email.com", "pass2", null);
        User william = new User("email3@email.com", "pass4", null);

        william = deliveryRepository.update(william);
        
        List<User> users = deliveryRepository.getAll();
      
        assertThat(users).isEqualTo(Arrays.asList(daniel, hector, william));
    }*/
}
