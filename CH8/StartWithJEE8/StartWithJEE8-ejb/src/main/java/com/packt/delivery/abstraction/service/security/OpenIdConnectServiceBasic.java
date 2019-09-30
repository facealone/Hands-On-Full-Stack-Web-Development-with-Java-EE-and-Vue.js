package com.packt.delivery.abstraction.service.security;

import com.packt.delivery.abstraction.entity.Token;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class OpenIdConnectServiceBasic implements OpenIdConnectService {

    private final TokenValidationService tokenValidationService;
    private final Client client;
    private final String identityProviderUrl;

    public OpenIdConnectServiceBasic(TokenValidationService tokenValidationService, Client client, String identityProviderUrl) {
        this.tokenValidationService = tokenValidationService;
        this.client = client;
        this.identityProviderUrl = identityProviderUrl;
    }

    @Override
    public Token requestToken(String grantType, String code, String redirectUrl) {
        Form form = new Form()
                .param("grant_type", grantType)
                .param("code", code)
                .param("redirect_url", redirectUrl);

        Response response = client.target(identityProviderUrl)
                .path("token")
                .request(MediaType.APPLICATION_FORM_URLENCODED_TYPE)
                .accept(MediaType.APPLICATION_JSON_TYPE)
                .post(Entity.form(form));

        if (response.getStatus() != 200) {
            throw new IllegalStateException("The tokens couldn't be gotten " + response.readEntity(String.class));
        }

        Token token = response.readEntity(Token.class);

        if (!tokenValidationService.validate(token.getAccessToken())) {
            throw new IllegalStateException("The tokens was gotten but they are invalid" + response.readEntity(String.class));
        }

        return token;
    }

}
