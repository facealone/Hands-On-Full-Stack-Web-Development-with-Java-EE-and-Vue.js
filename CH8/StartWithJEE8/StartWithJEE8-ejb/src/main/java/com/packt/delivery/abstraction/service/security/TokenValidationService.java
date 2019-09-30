
package com.packt.delivery.abstraction.service.security;

public interface TokenValidationService {
    boolean validate(String accessToken);
}
