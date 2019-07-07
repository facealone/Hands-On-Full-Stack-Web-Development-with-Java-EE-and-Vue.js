package com.packt.delivery.abstraction.entity;

import java.io.Serializable;
import java.util.Objects;

public class User implements Serializable {
    private final String email;
    private final String password;
    private final FoodService foodService;

    public User(String email, String password, FoodService foodService) {
        this.email = email;
        this.password = password;
        this.foodService = foodService;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public FoodService getFoodService() {
        return foodService;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + Objects.hashCode(this.email);
        hash = 13 * hash + Objects.hashCode(this.password);
        hash = 13 * hash + Objects.hashCode(this.foodService);
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
        final User other = (User) obj;
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.password, other.password)) {
            return false;
        }
        if (!Objects.equals(this.foodService, other.foodService)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "User{" + "email=" + email + ", password=" + password + ", foodService=" + foodService + '}';
    }

    
}
