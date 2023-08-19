//******************************************************
//Author Name : Nagraj Panchal
//Project     : Database Automation Testing
//Date        : 29/01/2023
//******************************************************

package com.bridgelabz.db.spotify;

import com.bridgelabz.db.spotify.BaseConnectionDriversVariablesTest;
import org.testng.annotations.Test;

import java.sql.*;
public class DbAutomationTest extends BaseConnectionDriversVariablesTest
{
    @Test
    public void getTracks_TableData_Successfully() throws SQLException {
        result = stmt.executeQuery("Select * from tracks");
        while (result.next())
        {
            String trackId = result.getString(1);
            String trackName = result.getString(2);
            String trackDetails = result.getString(3);
            String playListId = result.getString(4);
            System.out.println(trackId+","+trackName+","+trackDetails+","+playListId);
        }
    }

    @Test
    public void getPlayList_TableData_Successfully() throws SQLException {
        result = stmt.executeQuery("Select * from playlist");
        while (result.next())
        {
            String playListId = result.getString(1);
            String playListName = result.getString("play_List_Name");
            String playListType = result.getString(3);
            String userIdFK = result.getString(4);
            System.out.println(playListId+","+playListName+","+playListType+","+userIdFK);
        }
    }

    @Test
    public static void getUser_TableData_Successfully() throws SQLException {
        result = stmt.executeQuery("Select * from users");
        while (result.next())
        {
            String userId = result.getString(1);
            String userName = result.getString("userName");
            String userEmail = result.getString(3);
            System.out.println(userId+","+userName+","+userEmail);
        }
    }

    @Test
    public static void insertDataInto_TracksTable_Successfully() throws SQLException {
        PreparedStatement pst = con.prepareStatement("INSERT into tracks values"+"(?,?,?,?)");
        pst.setInt(1,303);
        pst.setString(2,"E Shehera hai");
        pst.setString(3,"RAAZ");
        pst.setInt(4,6);
        pst.executeUpdate();
        System.out.println("\nInserted "+pst.getUpdateCount()+" row\n");
    }

    @Test
    public static void updateDataInto_TracksTable_Successfully() throws SQLException {
        PreparedStatement pst = con.prepareStatement("UPDATE tracks set track_Name = ? where t_id =?");
        pst.setString(1,"Main Agar Samane");
        pst.setInt(2,203);
        pst.executeUpdate();
        System.out.println("\nUpdated "+pst.getUpdateCount()+" row\n");
    }

    @Test
    public static void deleteDataInto_TracksTable_Successfully() throws SQLException {
        PreparedStatement pst = con.prepareStatement("DELETE from tracks where t_id =?");
        pst.setInt(1,303);
        pst.executeUpdate();
        System.out.println("\nDeleted "+pst.getUpdateCount()+" row\n");
    }


}
