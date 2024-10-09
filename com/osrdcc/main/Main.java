package com.osrdcc.main;
import com.osrdcc.entity.Character;
import com.osrdcc.entity.Occupation;
import com.osrdcc.entity.Weapons;
import com.osrdcc.entity.Warrior;
import com.osrdcc.connection.ConnectionController;

import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        Weapons staff = new Weapons("Staff", "1d4", "", 5);
        Occupation alchemist = new Occupation(1, "Alchemist", staff, "Oil, flask", 1);
        Character hero = new Warrior("Takito",18, 14, 18, 16, 11, 10);
        hero.setOccupation(alchemist);
        System.out.println(hero);
        try (Connection conn = ConnectionController.connect()) {
            if (conn != null) {
                System.out.println("connectado ao taiago!");
            } else {
                System.out.println("Não foi!.");
            }
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
