package com.bridgelabz.db;

import java.sql.*;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseConnectionDriversVariables
{
    public static String dbUrl = "jdbc:mysql://localhost:3306/CFP_216";
    public static String userName = "root";
    public static String password = "root";
    public static Connection con;
    public static Statement stmt;
    static ResultSet result;
    @BeforeTest
    public void getVariable_Values() throws SQLException {
        con = DriverManager.getConnection(dbUrl,userName,password);
        stmt = con.createStatement();
        System.out.println("Connection : "+con);
        System.out.println("Statement : "+stmt);
    }
    @AfterTest
    public static void closeConnection()
    {
        try {
            con.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
