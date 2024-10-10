package com.osrdcc.entity;

import com.osrdcc.controllers.OccupationData;

public class Occupation {
    private final int roll;
    private final String occupation;
    private final String trained_weapon;
    private final String trade_goods;
    public Occupation(OccupationData data) {
        this.roll = data.roll();
        this.occupation = data.occupation_name();
        this.trained_weapon = data.trained_weapon();
        this.trade_goods = data.trade_goods();
    }

    public int getRoll() {
        return roll;
    }

    public String getOccupation() {
        return occupation;
    }

    public String getTrained_weapon() {
        return trained_weapon;
    }

    public String getTrade_goods() {
        return trade_goods;
    }
    //    public String getOccupation() {
//        return occupation;
//    }
//    public String getTrainedWeapon(){
//       return trained_weapon.getWeapongName();
//    }
}
