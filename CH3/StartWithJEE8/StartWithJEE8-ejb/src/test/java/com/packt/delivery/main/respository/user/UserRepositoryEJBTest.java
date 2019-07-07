package com.packt.delivery.main.respository.user;

import com.packt.delivery.abstraction.entity.User;
import com.packt.delivery.abstraction.repository.UserRepository;
import com.packt.delivery.main.Infrastructure;
import java.util.Arrays;
import java.util.List;
import javax.inject.Inject;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.assertj.core.api.Assertions.*;
import org.jboss.arquillian.junit.InSequence;

@RunWith(Arquillian.class)
public class UserRepositoryEJBTest {

    @Inject
    @Infrastructure
    private UserRepository userRepository;

    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackages(true, "com.packt.delivery")
                .addAsResource("META-INF/persistence.xml")
                .addAsResource("META-INF/data.sql")
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }

    @Test
    @InSequence(1)
    public void getAll_basicData_same() {
        User daniel = new User("email1@email.com", "pass1", null);
        User hector = new User("email2@email.com", "pass2", null);

        List<User> users = userRepository.getAll();

        assertThat(users).isEqualTo(Arrays.asList(daniel, hector));
    }
    
    @Test
    @InSequence(2)
    public void save_new_getAll() {
        User daniel = new User("email1@email.com", "pass1", null);
        User hector = new User("email2@email.com", "pass2", null);
        User william = new User("email3@email.com", "pass3", null);

        william = userRepository.save(william);
        
        List<User> users = userRepository.getAll();
      
        assertThat(users).isEqualTo(Arrays.asList(daniel, hector, william));
    }
    
    @Test
    @InSequence(3)
    public void update_new_getAll() {
        User daniel = new User("email1@email.com", "pass1", null);
        User hector = new User("email2@email.com", "pass2", null);
        User william = new User("email3@email.com", "pass4", null);

        william = userRepository.update(william);
        
        List<User> users = userRepository.getAll();
      
        assertThat(users).isEqualTo(Arrays.asList(daniel, hector, william));
    }
}
