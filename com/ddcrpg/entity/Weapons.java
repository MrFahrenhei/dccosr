package com.ddcrpg.entity;

public class Weapons {
    private final String name;
    private final String damage;
    private final String range;
    private int price;
    public Weapons(String name, String damage, String range, int price) {
        this.name = name;
        this.damage = damage;
        this.range = range;
        this.price = price;
    }
    public String getWeapongName(){
        return name;
    }
}
