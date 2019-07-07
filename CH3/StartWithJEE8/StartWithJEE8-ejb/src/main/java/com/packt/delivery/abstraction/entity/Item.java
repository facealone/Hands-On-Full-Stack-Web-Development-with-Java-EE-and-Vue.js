package com.packt.delivery.abstraction.entity;

import java.io.Serializable;
import java.util.Objects;

public class Item implements Serializable {
    private final Integer id;
    private final int amount;

    public Item(Integer id, int amount) {
        this.id = id;
        this.amount = amount;
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
        final Item other = (Item) obj;
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
        return "Item{" + "id=" + id + ", amount=" + amount + '}';
    }

    
}
