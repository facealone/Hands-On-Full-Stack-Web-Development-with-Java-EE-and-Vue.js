
package com.packt.delivery.abstraction.service.security;

import com.packt.delivery.abstraction.entity.Token;
import java.util.List;
import java.util.Map;

public interface OpenIdConnectService {
    Token requestToken(String grantType, String code, String redirectUrl);
}
