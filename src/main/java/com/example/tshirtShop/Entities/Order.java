package com.example.tshirtShop.Entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;
@ManyToOne
    private User user;
    @ManyToMany
    @JoinTable(name = "order_tshirts",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "tshirt_id"))
    private List<TShirt> tshirts;
     private String nameOfUser;
    private String postOffice;
    private String postalCode;
    private String phoneNumber;
    private OrderStatus orderStatus;
    public enum OrderStatus {
        PROCESSING,
        IN_TRANSIT,
        DELIVERED,
        CANCELED
    }

    public Order(int id, User user, List<TShirt> tshirts, String nameOfUser, String postOffice, String postalCode, String phoneNumber, OrderStatus orderStatus) {
        this.id = id;
        this.user = user;
        this.tshirts = tshirts;
        this.nameOfUser = nameOfUser;
        this.postOffice = postOffice;
        this.postalCode = postalCode;
        this.phoneNumber = phoneNumber;
        this.orderStatus = orderStatus;
    }

    public Order() {
    }

    public List<TShirt> getTshirts() {
        return tshirts;
    }

    public void setTshirts(List<TShirt> tshirts) {
        this.tshirts = tshirts;
    }

    public String getNameOfUser() {
        return nameOfUser;
    }

    public void setNameOfUser(String nameOfUser) {
        this.nameOfUser = nameOfUser;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getPostOffice() {
        return postOffice;
    }

    public void setPostOffice(String postOffice) {
        this.postOffice = postOffice;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
