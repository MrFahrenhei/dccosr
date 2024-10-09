package com.osrdcc.entity;

public class Occupation {
    private final int roll;
    private final String occupation;
    private final Weapons trained_weapon;
    private final String trade_goods;
    private final int quantity;
    public Occupation(int roll, String occupation, Weapons trained_weapon, String trade_goods, Integer quantity) {
        this.roll = roll;
        this.occupation = occupation;
        this.trained_weapon = trained_weapon;
        this.trade_goods = trade_goods;
        this.quantity = (quantity != null) ? quantity : 1;;
    }
    public String getOccupation() {
        return occupation;
    }
    public String getTrainedWeapon(){
       return trained_weapon.getWeapongName();
    }
}
