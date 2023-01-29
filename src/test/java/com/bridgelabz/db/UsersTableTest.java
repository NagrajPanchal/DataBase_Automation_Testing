//******************************************************
//Author Name : Nagraj Panchal
//Project     : Database Automation Testing : Users
//Date        : 29/01/2023
//******************************************************

package com.bridgelabz.db;

import org.testng.annotations.Test;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UsersTableTest extends BaseConnectionDriversVariablesTest
{
    @Test
    public static void getUsersData_Table_Successfully() throws SQLException {
        result = stmt.executeQuery("Select * from users");
        while (result.next())
        {
            Integer userId = result.getInt("u_id");
            String userName = result.getString("userName");
            String eMail = result.getString("E_Mail");
            System.out.println(userId+","+userName+","+eMail);
        }
    }

    @Test
    public static void insertDataInto_UsersTable_Successfully() throws SQLException {
        PreparedStatement pst = con.prepareStatement("INSERT into users values"+"(?,?,?)");
        pst.setInt(1,12);
        pst.setString(2,"Sudhakar");
        pst.setString(3,"Sudhakar@bridgelabz.com");
        pst.executeUpdate();
        System.out.println("\nInserted "+pst.getUpdateCount()+" row\n");
        getUsersData_Table_Successfully();
    }

    @Test
    public static void updateDataInto_UsersTable_Successfully() throws SQLException {
        PreparedStatement pst = con.prepareStatement("UPDATE users set userName = ? where u_id =?");
        pst.setString(1,"SudhakarSir");
        pst.setInt(2,12);
        pst.executeUpdate();
        System.out.println("\nUpdated "+pst.getUpdateCount()+" row\n");
    }

    @Test
    public static void deleteDataInto_UsersTable_Successfully() throws SQLException {
        PreparedStatement pst = con.prepareStatement("DELETE from users where u_id =?");
        pst.setInt(1,12);
        pst.executeUpdate();
        System.out.println("\nDeleted "+pst.getUpdateCount()+" row\n");
    }

}
