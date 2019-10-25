package com.example.borgerkong;

import java.util.ArrayList;
import java.util.List;

public class Data {
    private static List<Food> foods = new ArrayList<>();

    public static List<Food> getFoods() {
        return foods;
    }

    public static void setFoods(List<Food> foods) {
        Data.foods = foods;
    }
}
