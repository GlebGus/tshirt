package com.example.tshirtShop;

import java.util.List;

public class Delivery {
    private String street;
    private String house;
    private String building;
    private String postcode;
    private String comment;
    public List<String> getAllStreets() {
      return null;  // здесь нужно реализовать логику получения списка всех улиц Минска
        // и вернуть его
    }
    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
