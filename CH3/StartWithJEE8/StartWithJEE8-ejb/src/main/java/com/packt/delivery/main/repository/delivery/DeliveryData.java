/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.packt.delivery.main.repository.delivery;

import com.packt.delivery.main.repository.item.ItemData;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author daniel
 */
@Entity
@Table(name = "DELIVERY")
@NamedQueries({
    @NamedQuery(name = "DeliveryData.findAll", query = "SELECT d FROM DeliveryData d"),
    @NamedQuery(name = "DeliveryData.findById", query = "SELECT d FROM DeliveryData d WHERE d.id = :id"),
    @NamedQuery(name = "DeliveryData.findByAddress", query = "SELECT d FROM DeliveryData d WHERE d.address = :address"),
    @NamedQuery(name = "DeliveryData.findByPhone", query = "SELECT d FROM DeliveryData d WHERE d.phone = :phone"),
    @NamedQuery(name = "DeliveryData.findByTotal", query = "SELECT d FROM DeliveryData d WHERE d.total = :total"),
    @NamedQuery(name = "DeliveryData.findByFee", query = "SELECT d FROM DeliveryData d WHERE d.fee = :fee")})
public class DeliveryData implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "address")
    private String address;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "phone")
    private String phone;
    @Basic(optional = false)
    @NotNull
    @Column(name = "total")
    private int total;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fee")
    private int fee;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "delivery")
    private List<ItemData> itemList;

    public DeliveryData() {
    }

    public DeliveryData(Integer id) {
        this.id = id;
    }

    public DeliveryData(Integer id, String address, String phone, int total, int fee) {
        this.id = id;
        this.address = address;
        this.phone = phone;
        this.total = total;
        this.fee = fee;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getFee() {
        return fee;
    }

    public void setFee(int fee) {
        this.fee = fee;
    }

    public List<ItemData> getItemList() {
        return itemList;
    }

    public void setItemList(List<ItemData> itemList) {
        this.itemList = itemList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DeliveryData)) {
            return false;
        }
        DeliveryData other = (DeliveryData) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.packt.delivery.main.data.structure.Delivery[ id=" + id + " ]";
    }
    
}
