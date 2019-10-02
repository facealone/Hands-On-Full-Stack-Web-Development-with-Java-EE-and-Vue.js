package com.packt.delivery.main.restful.security;

import com.packt.delivery.abstraction.service.security.AuthorizationException;
import com.packt.delivery.abstraction.service.security.TokenValidationService;
import java.io.IOException;
import javax.inject.Inject;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.PreMatching;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.ext.Provider;

//@Provider
//@PreMatching
//@AuthorizationNeeded
public class AuthorizationFilter implements ContainerRequestFilter {
    @Inject
    private TokenValidationService tokenValidationService;
    
    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        String authorizationHeader = requestContext.getHeaderString(HttpHeaders.AUTHORIZATION);
 
        String token = authorizationHeader.substring("Bearer".length()).trim();
        
        if(!tokenValidationService.validate(token)){
            throw new AuthorizationException("Token validation fails");
        }
    }
}
