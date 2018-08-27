package com.hand.dto;

import java.io.Serializable;

public class Address implements Serializable {
    private static final long serivalVersionUTD=1L;
    private Integer addressId;
    private String address;

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Address(Integer addressId, String address) {
        this.addressId = addressId;
        this.address = address;
    }

    public Address() {
    }

    @Override
    public String toString() {
        return "Address{" +
                "addressId=" + addressId +
                ", address='" + address + '\'' +
                '}';
    }
}
