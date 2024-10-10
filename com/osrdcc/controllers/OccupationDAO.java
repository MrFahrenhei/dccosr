package com.osrdcc.controllers;

import com.osrdcc.entity.Occupation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OccupationDAO {
    private final Connection conn;
    public OccupationDAO(Connection conn) {
        this.conn = conn;
    }
    public List<Occupation> listar(){
        String sql = "SELECT * FROM occupation";
        List<Occupation> lista = new ArrayList<>();
        try{
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet result = stmt.executeQuery();
            while (result.next()) {
                Integer occupationId = result.getInt(1);
                Integer roll = result.getInt(2);
                String occupation_name = result.getString(3);
                String trained_weapong = result.getString(4);
                String trade_goods = result.getString(5);
                OccupationData occupationData = new OccupationData(roll, occupation_name, trained_weapong, trade_goods);
                Occupation occupation = new Occupation(occupationData);
                lista.add(occupation);
            }
            result.close();
            stmt.close();
            conn.close();
        }catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
        return lista;
    }
    public boolean insert(Occupation occupation) {
        String sql = "INSERT INTO `occupation`(roll, occupation, trained_weapon, trade_goods, dt_insert)" +
                "value (?, ?, ?, ?, now())";
        try{
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, occupation.getRoll());
            stmt.setString(2, occupation.getOccupation());
            stmt.setString(3, occupation.getTrained_weapon());
            stmt.setString(4, occupation.getTrade_goods());
            stmt.execute();
            return true;
        }catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }
    }
}
