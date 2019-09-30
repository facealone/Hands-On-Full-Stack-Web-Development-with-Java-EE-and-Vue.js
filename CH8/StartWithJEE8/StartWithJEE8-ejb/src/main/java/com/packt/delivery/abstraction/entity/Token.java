
package com.packt.delivery.abstraction.entity;

import java.util.Objects;

public class Token {
    private final String idToken;
    private final String accessToken;
    private final String refreshToken;
    private final String expiresIn;

    public Token(String idToken, String accessToken, String refreshToken, String expiresIn) {
        this.idToken = idToken;
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
        this.expiresIn = expiresIn;
    }

    public String getIdToken() {
        return idToken;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public String getExpiresIn() {
        return expiresIn;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.idToken);
        hash = 79 * hash + Objects.hashCode(this.accessToken);
        hash = 79 * hash + Objects.hashCode(this.refreshToken);
        hash = 79 * hash + Objects.hashCode(this.expiresIn);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Token other = (Token) obj;
        if (!Objects.equals(this.idToken, other.idToken)) {
            return false;
        }
        if (!Objects.equals(this.accessToken, other.accessToken)) {
            return false;
        }
        if (!Objects.equals(this.refreshToken, other.refreshToken)) {
            return false;
        }
        if (!Objects.equals(this.expiresIn, other.expiresIn)) {
            return false;
        }
        return true;
    }
    
    
}
