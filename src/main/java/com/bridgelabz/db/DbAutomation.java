//******************************************************
//Author Name : Nagraj Panchal
//Project     : Database Automation
//Date        : 29/01/2023
//******************************************************

package com.bridgelabz.db;
import java.sql.*;

public class DbAutomation
{
    public static String dbUrl = "jdbc:mysql://localhost:3306/CFP_216";
    public static String userName = "root";
    public static String password = "root";
    public static String queryTracks = "Select * from tracks";
    public static Connection con;
    public static Statement stmt;
    static ResultSet result;

    public static void main(String[] args) throws SQLException
    {
        con = DriverManager.getConnection(dbUrl,userName,password);
        stmt = con.createStatement();
        System.out.println("Connection : "+con);
        System.out.println("Statement : "+stmt);
        System.out.println("<--- Before Insert Details into Tracks --->");
        printTracksTable();

        PreparedStatement pst = con.prepareStatement("INSERT into tracks values"+"(?,?,?,?)");
        pst.setInt(1,302);
        pst.setString(2,"Itana pyar hai");
        pst.setString(3,"RAAZ");
        pst.setInt(4,6);
        pst.executeUpdate();
        System.out.println("<--- After Inserted Details into Tracks --->");
        printTracksTable();

        PreparedStatement pstmt = con.prepareStatement("UPDATE tracks set track_Name = ? where t_id =?");
        pstmt.setString(1,"Jo Bhi Khasmei");
        pstmt.setInt(2,301);
        pstmt.executeUpdate();
        System.out.println("Updated "+pstmt.getUpdateCount()+" row");
        printTracksTable();


        PreparedStatement psmt = con.prepareStatement("DELETE from tracks where t_id =?");
        psmt.setInt(1,303);
        psmt.executeUpdate();
        System.out.println("Deleted "+psmt.getUpdateCount()+" row");


        con.close();
    }
    public static void printTracksTable() throws SQLException {
        result = stmt.executeQuery(queryTracks);
        while (result.next())
        {
            String trackId = result.getString(1);
            String trackName = result.getString(2);
            String trackDetails = result.getString(3);
            String playListId = result.getString(4);
            System.out.println(trackId+","+trackName+","+trackDetails+","+playListId);
        }
    }
    public static void printUserDetails() throws SQLException {
        result = stmt.executeQuery("Select * from users");
        while (result.next())
        {
            String userId = result.getString(1);
            String userName = result.getString("userName");
            String userEmail = result.getString(3);
            System.out.println(userId+","+userName+","+userEmail);
        }
    }
}
