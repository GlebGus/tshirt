package com.example.sqltestconnection;

import jakarta.persistence.*;

import java.util.List;


@Entity
@Table(name = "tshirts")
public class TShirt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @Column(name = "description", columnDefinition = "text")
    private String description;
    private String size;
    private Double price;
    private boolean available;
//    @OneToMany(mappedBy = "tShirt", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
//private List<Image> images;
    public TShirt(int id, String name, String description, String size, Double price, boolean available) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.size = size;
        this.price = price;
        this.available = available;
    }

    public TShirt() {

    }


    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}