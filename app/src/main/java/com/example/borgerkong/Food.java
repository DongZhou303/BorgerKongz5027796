package com.example.borgerkong;

import java.io.Serializable;

public class Food {
    private double price;
    private String name;
    private String intro;
    private int Rid;
    private int num;

    public Food(String name, String intro, int num, int Rid, double price){
        this.name = name;
        this.intro = intro;
        this.num = num;
        this.Rid = Rid;
        this.price = price;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public int getRid() {
        return Rid;
    }

    public void setRid(int rid) {
        Rid = rid;
    }
}
