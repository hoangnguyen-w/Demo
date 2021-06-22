/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fu.ex.entities;

/**
 *
 * @author ADMIN
 */
public class Product {
    private String id;
    private String name;
    private String description;
    private int quanlity;
    private double price;
    private String imgURL;

    public Product() {
    }

    public Product(String id, String name, String description, int quanlity, double price, String imgURL) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.quanlity = quanlity;
        this.price = price;
        this.imgURL = imgURL;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getQuanlity() {
        return quanlity;
    }

    public double getPrice() {
        return price;
    }

    public String getImgURL() {
        return imgURL;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setQuanlity(int quanlity) {
        this.quanlity = quanlity;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setImgURL(String imgURL) {
        this.imgURL = imgURL;
    }
    
    
}
