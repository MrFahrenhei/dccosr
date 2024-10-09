package com.dccosr.main;
import com.ddcrpg.entity.Character;
import com.ddcrpg.entity.Occupation;
import com.ddcrpg.entity.Weapons;
import com.ddcrpg.entity.Warrior;

public class Main {
    public static void main(String[] args) {
        Weapons staff = new Weapons("Staff", "1d4", "", 5);
        Occupation alchemist = new Occupation(1, "Alchemist", staff, "Oil, flask", 1);
        Character hero = new Warrior("Takito",18, 14, 18, 16, 11, 10);
        hero.setOccupation(alchemist);
        System.out.println(hero);
//        System.out.println(hero.score());
    }
}
