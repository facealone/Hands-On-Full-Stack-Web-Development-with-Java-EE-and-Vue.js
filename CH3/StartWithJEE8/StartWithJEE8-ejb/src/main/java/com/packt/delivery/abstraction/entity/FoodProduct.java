package com.packt.delivery.abstraction.entity;

import java.io.Serializable;
import java.util.Objects;

public class FoodProduct implements Serializable {
    private final Integer id;
    private final String name;
    private final int price;
    private final String description;
    private final boolean active;
    private final String imageUrl;

    public FoodProduct(Integer id, String name, int price, String description, boolean active, String imageUrl) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.active = active;
        this.imageUrl = imageUrl;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + Objects.hashCode(this.id);
        hash = 29 * hash + Objects.hashCode(this.name);
        hash = 29 * hash + this.price;
        hash = 29 * hash + Objects.hashCode(this.description);
        hash = 29 * hash + (this.active ? 1 : 0);
        hash = 29 * hash + Objects.hashCode(this.imageUrl);
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
        final FoodProduct other = (FoodProduct) obj;
        if (this.price != other.price) {
            return false;
        }
        if (this.active != other.active) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        if (!Objects.equals(this.imageUrl, other.imageUrl)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "FoodProduct{" + "id=" + id + ", name=" + name + ", price=" + price + ", description=" + description + ", active=" + active + ", imageUrl=" + imageUrl + '}';
    }

    
}
