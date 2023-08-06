package com.example.sqltestconnection.Entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
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
   @OneToMany(mappedBy = "tShirt", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Image> images = new ArrayList<>();
    private int previewImageId;
    private LocalDateTime dateOfCreated;

    public void addImageToTShirt(Image image){
        image.settShirt(this);
        images.add(image);
    }

    @PrePersist
    private void init(){
        dateOfCreated = LocalDateTime.now();
    }
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

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

    public int getPreviewImageId() {
        return previewImageId;
    }

    public void setPreviewImageId(int previewImageId) {
        this.previewImageId = previewImageId;
    }

    public LocalDateTime getDateOfCreated() {
        return dateOfCreated;
    }

    public void setDateOfCreated(LocalDateTime dateOfCreated) {
        this.dateOfCreated = dateOfCreated;
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