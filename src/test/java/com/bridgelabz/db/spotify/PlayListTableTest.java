//******************************************************
//Author Name : Nagraj Panchal
//Project     : Database Automation Testing : PlayList
//Date        : 29/01/2023
//******************************************************

package com.bridgelabz.db.spotify;

import com.bridgelabz.db.spotify.BaseConnectionDriversVariablesTest;
import org.testng.annotations.Test;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PlayListTableTest extends BaseConnectionDriversVariablesTest
{
    @Test
    public static void getPlayList_TableData_Successfully() throws SQLException {
        result = stmt.executeQuery("Select * from playlist");
        while (result.next())
        {
            Integer playListId = result.getInt(1);
            String playListName = result.getString("play_List_Name");
            String playListType = result.getString(3);
            Integer userIdFK = result.getInt(4);
            System.out.println(playListId+","+playListName+","+playListType+","+userIdFK);
        }
    }

    @Test
    public static void insertDataInto_PlayListTable_Successfully() throws SQLException {
        PreparedStatement pst = con.prepareStatement("INSERT into playlist values"+"(?,?,?,?)");
        pst.setInt(1,18);
        pst.setString(2,"Latest Songs");
        pst.setString(3,"Melody");
        pst.setInt(4,3);
        pst.executeUpdate();
        System.out.println("\nInserted "+pst.getUpdateCount()+" row\n");
        getPlayList_TableData_Successfully();
    }

    @Test
    public static void updateDataInto_PlayListTable_Successfully() throws SQLException {
        PreparedStatement pst = con.prepareStatement("UPDATE playlist set music_type = ? where p_id =?");
        pst.setString(1,"Melody");
        pst.setInt(2,17);
        pst.executeUpdate();
        System.out.println("\nUpdated "+pst.getUpdateCount()+" row\n");
        getPlayList_TableData_Successfully();
    }

    @Test
    public static void deleteDataInto_PlayListTable_Successfully() throws SQLException {
        PreparedStatement pst = con.prepareStatement("DELETE from playlist where p_id =?");
        pst.setInt(1,18);
        pst.executeUpdate();
        System.out.println("\nDeleted "+pst.getUpdateCount()+" row\n");
    }
}
