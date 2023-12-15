package com.example.md1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Database {

    public static Connection connectDB(){

        try{


            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connect = DriverManager.getConnection("jdbc:mysql://localhost/university", "root","");
            return connect;
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
