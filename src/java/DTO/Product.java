/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author hoang.nqm
 */
public class Product {

    private String productID, productName, image, categoryID, status, description;
    private int quantity;
    private float price;

    public Product(String productID, String productName, String image, String categoryID, String status, String description, int quantity, float price) {
        this.productID = productID;
        this.productName = productName;
        this.image = image;
        this.categoryID = categoryID;
        this.status = status;
        this.description = description;
        this.quantity = quantity;
        this.price = price;
    }

    public Product(String productID, String productName, String image, String description) {
        this.productID = productID;
        this.productName = productName;
        this.image = image;
        this.description = description;
    }

    public Product(String productID, String productName, String image, String status, String description) {
        this.productID = productID;
        this.productName = productName;
        this.image = image;
        this.status = status;
        this.description = description;
    }

  

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(String categoryID) {
        this.categoryID = categoryID;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

}
