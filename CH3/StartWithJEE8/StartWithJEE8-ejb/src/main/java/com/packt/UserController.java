/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.packt;

import java.util.Collection;
import java.util.Collections;
import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 *
 * @author daniel
 */
@ApplicationScoped
@Path("users")
public class UserController {
    @GET
    public Collection<User> allUsers() {
        return Collections.emptyList();
    }
}
