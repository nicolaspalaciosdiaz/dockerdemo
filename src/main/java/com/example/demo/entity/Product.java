package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "product")
public class Product {

    // create id field
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    // create name filed
    @Column(name = "name")
    private String productName;

    // amount field
    @Column(name = "products_left")
    private int productsLeft;

    @Column(name = "description")
    private String description;
    @Column(name = "price")
    private float price;

    // constructor


    public Product() {
    }

    public Product(int id, String productName, int productsLeft, String description, float price) {
        this.id = id;
        this.productName = productName;
        this.productsLeft = productsLeft;
        this.description = description;
        this.price = price;
    }

    // getter  // setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getProductsLeft() {
        return productsLeft;
    }

    public void setProductsLeft(int productsLeft) {
        this.productsLeft = productsLeft;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    // @toString

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", productName='" + productName + '\'' +
                ", productsLeft='" + productsLeft + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                '}';
    }
}
