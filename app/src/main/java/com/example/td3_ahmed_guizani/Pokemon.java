package com.example.td3_ahmed_guizani;

import java.util.List;

public class Pokemon {
    private int id;
    private String num;
    private String name;
    private String img;
    private List<String> type;
    private String height;
    private String weight;
    private List<String> weaknesses;


    public int getId() {
        return id;
    }

    public String getNum() { return num; }

    public String getName() {
        return name;
    }

    public String getImg() {
        return img;
    }

    public List<String> getType() { return type; }

    public String getHeight() {
        return height;
    }

    public String getWeight() {
        return weight;
    }

    public List<String> getWeaknesses() { return weaknesses; }
}
