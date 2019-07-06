/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.packt;

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

/**
 *
 * @author daniel
 */
@RunWith(Arquillian.class)
public class UserControllerTest {
    
    @Inject
    private UserController userController;

    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addClasses(UserController.class, User.class, NewSessionBean.class, Provider.class)
                .addAsResource("META-INF/persistence.xml")
                .addAsResource("META-INF/data.sql")
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }

    @Test
    public void getAllUsers() {
        User daniel = new User();
        daniel.setId(1);
        daniel.setName("daniel");
        
        User hector = new User();
        hector.setId(2);
        hector.setName("hector");
        
        List<User> users = userController.allUsers();
         
        assertThat(users).isEqualTo(Arrays.asList(daniel, hector));

    }
}
