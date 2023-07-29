package com.example.sqltestconnection;

import jakarta.persistence.*;


//@Entity
//@Table(name = "images")
//public class Image {
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private int id;
//
//    @Lob
//    @Column(name = "photo")
//    private byte[] photo;
//    @ManyToOne
//    @JoinColumn(name = "tshirt_id", referencedColumnName = "id")
//    private TShirt tShirt;
//
//    public Image() {
//
//    }
//
//    public Image(int id, byte[] photo) {
//        this.id = id;
//        this.photo = photo;
//    }
//
//    public byte[] getPhoto() {
//        return photo;
//    }
//
//    public TShirt getTShirt() {
//        return tShirt;
//    }
//
//    public void setTShirt(TShirt tShirt) {
//        this.tShirt = tShirt;
//    }
//
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public void setPhoto(byte[] photo) {
//        this.photo = photo;
//    }
//
//
//}
