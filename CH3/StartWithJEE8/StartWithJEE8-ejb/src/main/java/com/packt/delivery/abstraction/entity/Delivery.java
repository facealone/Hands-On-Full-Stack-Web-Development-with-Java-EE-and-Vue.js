package com.packt.delivery.abstraction.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class Delivery implements Serializable {
    private final Integer id;
    private final String address;
    private final String phone;
    private final int total;
    private final int fee;
    private final List<Item> itemList;

    public Delivery(Integer id, String address, String phone, int total, int fee, List<Item> itemList) {
        this.id = id;
        this.address = address;
        this.phone = phone;
        this.total = total;
        this.fee = fee;
        this.itemList = itemList;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.id);
        hash = 37 * hash + Objects.hashCode(this.address);
        hash = 37 * hash + Objects.hashCode(this.phone);
        hash = 37 * hash + this.total;
        hash = 37 * hash + this.fee;
        hash = 37 * hash + Objects.hashCode(this.itemList);
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
        final Delivery other = (Delivery) obj;
        if (this.total != other.total) {
            return false;
        }
        if (this.fee != other.fee) {
            return false;
        }
        if (!Objects.equals(this.address, other.address)) {
            return false;
        }
        if (!Objects.equals(this.phone, other.phone)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.itemList, other.itemList)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Delivery{" + "id=" + id + ", address=" + address + ", phone=" + phone + ", total=" + total + ", fee=" + fee + ", itemList=" + itemList + '}';
    }

}
