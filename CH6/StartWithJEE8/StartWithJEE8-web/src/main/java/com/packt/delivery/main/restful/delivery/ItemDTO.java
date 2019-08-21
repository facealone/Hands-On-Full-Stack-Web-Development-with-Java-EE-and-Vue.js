package com.packt.delivery.main.restful.delivery;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.packt.delivery.abstraction.entity.*;
import com.packt.delivery.main.restful.foodproduct.FoodProductDTO;
import java.io.Serializable;
import java.util.Objects;
import java.util.Optional;

public class ItemDTO implements Serializable {
    private final Integer id;
    private final int amount;
    private final FoodProductDTO foodProduct;

    @JsonCreator
    public ItemDTO(@JsonProperty("id") Integer id, @JsonProperty("amount") int amount, @JsonProperty("foodProduct") FoodProductDTO foodProduct) {
        this.id = id;
        this.amount = amount;
        this.foodProduct = foodProduct;
    }
    
    public ItemDTO(Item item){
        this.id = item.getId();
        this.amount = item.getAmount();
        this.foodProduct = Optional.ofNullable(item.getFoodProduct())
                .map(f -> new FoodProductDTO(f))
                .orElse(null);
    }

    public Integer getId() {
        return id;
    }

    public int getAmount() {
        return amount;
    }

    public FoodProductDTO getFoodProduct() {
        return foodProduct;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + Objects.hashCode(this.id);
        hash = 67 * hash + this.amount;
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
        final ItemDTO other = (ItemDTO) obj;
        if (this.amount != other.amount) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ItemDTO{" + "id=" + id + ", amount=" + amount + '}';
    }

    
}
