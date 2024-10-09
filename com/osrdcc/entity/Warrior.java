package com.osrdcc.entity;

import java.util.Random;

public class Warrior extends Character{
    Random random = new Random();
    public Warrior(String name, int strength, int agility, int stamina, int personality, int intelligence, int luck) {
        super(name, strength, agility, stamina, personality, intelligence, luck);
    }
    public int warriorDice() {
        return random.nextInt(12)+1;
    }
}
