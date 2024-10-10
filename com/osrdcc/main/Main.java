package com.osrdcc.main;
import com.osrdcc.controllers.OccupationDAO;
import com.osrdcc.controllers.OccupationData;
import com.osrdcc.entity.Character;
import com.osrdcc.entity.Occupation;
import com.osrdcc.entity.Weapons;
import com.osrdcc.entity.Warrior;
import com.osrdcc.connection.ConnectionController;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
//        Weapons staff = new Weapons("Staff", "1d4", "", 5);
        Occupation alchemist = new Occupation(new OccupationData(1, "Alchemist", "staff", "Oil, flask"));
//        Character hero = new Warrior("Takito",18, 14, 18, 16, 11, 10);
//        System.out.println(hero);
        try(Connection conn = ConnectionController.connect()){
            System.out.println("Connection established successfully!");
            OccupationDAO occupationDAO = new OccupationDAO(conn);
            occupationDAO.insert(alchemist);
        }catch (SQLException e) {
            System.err.println("Connection failed: " + e.getMessage());
        }
    }
}
