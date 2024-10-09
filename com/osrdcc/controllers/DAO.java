package com.osrdcc.controllers;

import java.sql.Connection;

public class DAO {
    private Connection conn;
    DAO(Connection conn){
        this.conn = conn;
    }
}
