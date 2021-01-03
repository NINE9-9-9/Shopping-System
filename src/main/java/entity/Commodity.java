package main.java.entity;

import java.io.Serializable;

/**
 * @Author NINE. LIU
 * @Date 2020/10/16 16:30
 * @Version 1.0
 */
public class Commodity implements Serializable {

    private int id;
    private String name;
    private double price;
    private String type;
    private int amount;
    private String image;
    private String description;

    public Commodity() {}

    public Commodity(String name, double price, String type, int amount, String image, String description)
    {
        this.name=name;
        this.price=price;
        this.type = type;
        this.amount= amount;
        this.image=image;
        this.description = description;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
