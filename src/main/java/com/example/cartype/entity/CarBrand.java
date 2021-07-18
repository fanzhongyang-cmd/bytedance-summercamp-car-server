package com.example.cartype.entity;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class CarBrand {
//    public List<Integer> seriesList;
    private int id;
    private String name;
    private String icon;
    private String letter;

    public String getLetter() {
        return letter;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getIcon() {
        return icon;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    @Override
    public String toString() {
        return "CarBrand{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", icon='" + icon + '\'' +
                ", letter='" + letter + '\'' +
                '}';
    }
}
