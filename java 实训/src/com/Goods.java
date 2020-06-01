package com;
public class Goods {
    private int id;
    private String name;
    private int price;
    private int number;
    private int count;
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
    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    public int getNumber() {
        return number;
    }
    public void setNumber(int number) {
        this.number = number;
    }
    public int getCount() {
        return count=price*number;
    }
    public void setCount(int count) {
        this.count = count;
    }
}