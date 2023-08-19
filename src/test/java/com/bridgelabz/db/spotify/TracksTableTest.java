//******************************************************
//Author Name : Nagraj Panchal
//Project     : Database Automation Testing : Tracks
//Date        : 29/01/2023
//******************************************************

package com.bridgelabz.db.spotify;

import com.bridgelabz.db.spotify.BaseConnectionDriversVariablesTest;
import org.testng.annotations.Test;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TracksTableTest extends BaseConnectionDriversVariablesTest
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
