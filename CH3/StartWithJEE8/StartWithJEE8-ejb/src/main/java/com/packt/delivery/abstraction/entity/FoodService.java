package com.packt.delivery.abstraction.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class FoodService implements Serializable {

    private final String email;
    private final String name;
    private final String address;
    private final String foodType;
    private final String active;
    private final List<FoodProduct> foodProductList;

    public FoodService(String email, String name, String address, String foodType, String active, List<FoodProduct> foodProductList) {
        this.email = email;
        this.name = name;
        this.address = address;
        this.foodType = foodType;
        this.active = active;
        this.foodProductList = foodProductList;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.email);
        hash = 89 * hash + Objects.hashCode(this.name);
        hash = 89 * hash + Objects.hashCode(this.address);
        hash = 89 * hash + Objects.hashCode(this.foodType);
        hash = 89 * hash + Objects.hashCode(this.active);
        hash = 89 * hash + Objects.hashCode(this.foodProductList);
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
        final FoodService other = (FoodService) obj;
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.address, other.address)) {
            return false;
        }
        if (!Objects.equals(this.foodType, other.foodType)) {
            return false;
        }
        if (!Objects.equals(this.active, other.active)) {
            return false;
        }
        if (!Objects.equals(this.foodProductList, other.foodProductList)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "FoodService{" + "email=" + email + ", name=" + name + ", address=" + address + ", foodType=" + foodType + ", active=" + active + ", foodProductList=" + foodProductList + '}';
    }

    
}
