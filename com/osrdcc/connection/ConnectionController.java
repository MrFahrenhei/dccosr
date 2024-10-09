package com.osrdcc.connection;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.SQLException;
import java.sql.Connection;

public class ConnectionController {
    public Connection connect(){
        try {
            return getDataSource().getConnection();
        }catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }
    }
    private HikariDataSource getDataSource(){
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl("jdbc:mysql://108.167.188.252:3306/rotinc02_osrdcc_rpg");
        config.setUsername("rotinc02_beraldo");
        config.setPassword("4IQ!zGY3yoTvBn04^1Dntynez");
        config.setMaximumPoolSize(10);
       return new HikariDataSource(config);
    }
}
