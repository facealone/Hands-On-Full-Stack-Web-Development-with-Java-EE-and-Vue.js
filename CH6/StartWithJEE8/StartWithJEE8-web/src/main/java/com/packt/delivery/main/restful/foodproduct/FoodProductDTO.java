package com.packt.delivery.main.restful.foodproduct;

import com.packt.delivery.abstraction.entity.FoodProduct;
import java.io.Serializable;
import java.util.Objects;

public class FoodProductDTO implements Serializable {
    private final Integer id;
    private final String name;
    private final int price;
    private final String description;
    private final boolean active;
    private final String imageUrl;
    private final String foodService;

    public FoodProductDTO(Integer id, String name, int price, String description, boolean active, String imageUrl, String foodService) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.active = active;
        this.imageUrl = imageUrl;
        this.foodService = foodService;
    }
    
    public FoodProductDTO(FoodProduct foodProduct) {
        this.id = foodProduct.getId();
        this.name = foodProduct.getName();
        this.price = foodProduct.getPrice();
        this.description = foodProduct.getDescription();
        this.active = foodProduct.isActive();
        this.imageUrl = foodProduct.getImageUrl();
        this.foodService = foodProduct.getFoodService();
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public boolean isActive() {
        return active;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getFoodService() {
        return foodService;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.id);
        hash = 71 * hash + Objects.hashCode(this.name);
        hash = 71 * hash + this.price;
        hash = 71 * hash + Objects.hashCode(this.description);
        hash = 71 * hash + (this.active ? 1 : 0);
        hash = 71 * hash + Objects.hashCode(this.imageUrl);
        hash = 71 * hash + Objects.hashCode(this.foodService);
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
        final FoodProductDTO other = (FoodProductDTO) obj;
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
        if (!Objects.equals(this.foodService, other.foodService)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "FoodProductDTO{" + "id=" + id + ", name=" + name + ", price=" + price + ", description=" + description + ", active=" + active + ", imageUrl=" + imageUrl + ", foodService=" + foodService + '}';
    }

    
}
