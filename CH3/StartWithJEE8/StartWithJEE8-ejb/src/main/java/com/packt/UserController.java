/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.packt;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

/**
 *
 * @author daniel
 */
@Stateless
@LocalBean
@Path("users")
public class UserController {
    @Inject
    private NewSessionBean newSessionBean;
    @GET
    public List<User> allUsers() {
        return newSessionBean.allUsers();
    }
    
    @POST
    public User save(User user) {
        return newSessionBean.save(user);
    }
}
