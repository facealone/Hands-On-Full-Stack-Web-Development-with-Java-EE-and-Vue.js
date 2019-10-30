
package com.packt.delivery.abstraction.service.security;

import com.packt.delivery.abstraction.entity.Token;

public interface OpenIdConnectService {
    Token requestToken(String grantType, String code, String redirectUrl);
}
