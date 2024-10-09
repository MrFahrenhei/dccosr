package com.osrdcc.controllers;

import com.osrdcc.connection.ConnectionController;

import java.sql.Connection;

public class Service {
    private ConnectionController connection;
    public void InsertItems(){
        Connection conn = connection.connect();
        new DAO(conn).insertItem();

    }
}
