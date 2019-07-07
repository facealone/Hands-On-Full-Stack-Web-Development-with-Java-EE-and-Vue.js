package com.packt.delivery.main.respository.user;

import com.packt.delivery.abstraction.entity.User;
import com.packt.delivery.abstraction.repository.UserRepository;
import com.packt.delivery.main.repository.Infrastructure;
import com.packt.delivery.main.repository.user.UserRepositoryEJB;
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
    public void getAllUsers() {
        User daniel = new User("email1@email.com", "pass1", null);
        User hector = new User("email2@email.com", "pass2", null);

        List<User> users = userRepository.getAll();

        assertThat(users).isEqualTo(Arrays.asList(daniel, hector));

    }
}
