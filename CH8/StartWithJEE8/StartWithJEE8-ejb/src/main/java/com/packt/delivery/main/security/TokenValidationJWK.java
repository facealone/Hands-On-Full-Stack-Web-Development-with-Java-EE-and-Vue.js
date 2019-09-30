package com.packt.delivery.main.security;

import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.proc.JWTProcessor;
import com.packt.delivery.abstraction.service.security.TokenValidationService;

public class TokenValidationJWK implements TokenValidationService {

    private final JWTProcessor jwtProcessor;

    public TokenValidationJWK(JWTProcessor jwtProcessor) {
        this.jwtProcessor = jwtProcessor;
    }

    @Override
    public boolean validate(String accessToken) {
        try {
            JWTClaimsSet claimsSet = jwtProcessor.process(accessToken, null);
        } catch (Exception ex) {
            throw new IllegalStateException("Token validation fails", ex);
        }

        return true;
    }

}
