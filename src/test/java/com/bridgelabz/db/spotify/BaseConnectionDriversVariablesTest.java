//******************************************************
//Author Name : Nagraj Panchal
//Project     : Database Automation Testing Connection Drivers Variables
//Date        : 29/01/2023
//******************************************************

package com.bridgelabz.db.spotify;

import java.sql.*;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseConnectionDriversVariablesTest
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
        System.out.println("Connection Established : "+con);
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
