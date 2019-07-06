/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.packt.delivery.main.data;

import com.packt.delivery.main.data.structure.UserData;
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
public class UserDAOEJBTest {
    
    @Inject
    private UserDAOEJB userDAOEJB;

    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage("com.packt.delivery.main.data")
                .addAsResource("META-INF/persistence.xml")
                .addAsResource("META-INF/data.sql")
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }

    @Test
    public void getAllUsers() {
        UserData daniel = new UserData();
        daniel.setEmail("email1@email.com");
        daniel.setPassword("pass1");
        
        UserData hector = new UserData();
        hector.setEmail("email2@email.com");
        hector.setPassword("pass2");
        
        List<UserData> users = userDAOEJB.allUsers();
         
        assertThat(users).isEqualTo(Arrays.asList(daniel, hector));

    }
}
