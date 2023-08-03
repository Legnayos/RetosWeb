package com.retos.segundociclo.Entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table (name = "gadgets")
public class Gadget implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(unique = true, name= "brand")
    private String brand;

    @NotNull
    @Column(unique = true, name= "category")
    private String category;

    @NotNull
    @Column(unique = true, name= "name")
    private String name;

    @NotNull
    @Column(unique = true, name= "description")
    private String description;

    @NotNull
    @Column(unique = true, name= "price")
    private Float price;

    @NotNull
    @Column(unique = true, name= "availability")
    private Boolean availability;

    @NotNull
    @Column(unique = true, name= "quantity")
    private Long quantity;

    @NotNull
    @Column(unique = true, name= "photography")
    private String photography;

    public Gadget() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
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

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Boolean getAvailability() {
        return availability;
    }

    public void setAvailability(Boolean availability) {
        this.availability = availability;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public String getPhotography() {
        return photography;
    }

    public void setPhotography(String photography) {
        this.photography = photography;
    }

    
}



    
    
    