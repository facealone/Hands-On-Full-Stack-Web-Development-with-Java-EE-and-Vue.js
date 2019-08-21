
package com.packt.delivery.main.restful.delivery;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.packt.delivery.abstraction.entity.Delivery;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class DeliveryDTO {
    private final Integer id;
    private final String address;
    private final String phone;
    private final int total;
    private final int fee;
    private final String email;
    private final String state;
    private final List<ItemDTO> itemList;

    @JsonCreator
    public DeliveryDTO(@JsonProperty("id") Integer id, @JsonProperty("address") String address, @JsonProperty("phone") String phone, @JsonProperty("total") int total, @JsonProperty("fee") int fee, @JsonProperty("email") String email, @JsonProperty("state") String state, @JsonProperty("itemList") List<ItemDTO> itemList) {
        this.id = id;
        this.address = address;
        this.phone = phone;
        this.total = total;
        this.fee = fee;
        this.email = email;
        this.state = state;
        this.itemList = itemList;
    }
    
    public DeliveryDTO(Delivery delivery){
        this.id = delivery.getId();
        this.address = delivery.getAddress();
        this.phone = delivery.getPhone();
        this.total = delivery.getTotal();
        this.fee = delivery.getFee();
        this.email = delivery.getEmail();
        this.state = delivery.getState();
        this.itemList = delivery.getItemList()
                .stream()
                .map(i -> new ItemDTO(i))
                .collect(Collectors.toList());
    }

    public Integer getId() {
        return id;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public int getTotal() {
        return total;
    }

    public int getFee() {
        return fee;
    }

    public String getEmail() {
        return email;
    }

    public String getState() {
        return state;
    }

    public List<ItemDTO> getItemList() {
        return itemList;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + Objects.hashCode(this.id);
        hash = 59 * hash + Objects.hashCode(this.address);
        hash = 59 * hash + Objects.hashCode(this.phone);
        hash = 59 * hash + this.total;
        hash = 59 * hash + this.fee;
        hash = 59 * hash + Objects.hashCode(this.email);
        hash = 59 * hash + Objects.hashCode(this.state);
        hash = 59 * hash + Objects.hashCode(this.itemList);
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
        final DeliveryDTO other = (DeliveryDTO) obj;
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
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.state, other.state)) {
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
        return "DeliveryDTO{" + "id=" + id + ", address=" + address + ", phone=" + phone + ", total=" + total + ", fee=" + fee + ", email=" + email + ", state=" + state + ", itemList=" + itemList + '}';
    }

}
