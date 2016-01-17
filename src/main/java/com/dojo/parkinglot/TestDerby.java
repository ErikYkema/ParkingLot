package com.dojo.parkinglot;
import com.dojo.parkinglot.tools.Exceptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSetMetaData;


public class TestDerby
{
    private final static Logger LOG =
            LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    private static String dbURL = "jdbc:derby://localhost:1527/myDB;create=true;user=me;password=mine";
    private static String tableName = "restaurants";
    // jdbc Connection
    private static Connection conn = null;
    private static Statement stmt = null;

    public static void main(String[] args)
    {
        createConnection();
        createRestaurants();
        insertRestaurants(5, "LaVals", "Berkeley");
        selectRestaurants();
        shutdown();
    }

    private static void createConnection()
    {
        try
        {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver").newInstance();
            //Get a connection
            String protocol = "jdbc:derby:";
            conn = DriverManager.getConnection(protocol + "derbyDB;create=true", null);
        }
        catch (Exception except)
        {
            except.printStackTrace();
        }
    }

    private static void createRestaurants()
    {
        try
        {
            stmt = conn.createStatement();
            stmt.execute("create table RESTAURANTS (id int, restName VARCHAR(40), cityName VARCHAR(40))");
            stmt.close();
        }
        catch (Exception ex)
        {
            Exceptions.handle(ex, "X0Y32");
        }

        try
        {
            stmt = conn.createStatement();
            stmt.execute("delete FROM RESTAURANTS");
            stmt.close();
        }
        catch (Exception ex)
        {
            Exceptions.handle(ex);
        }
    }

    private static void insertRestaurants(int id, String restName, String cityName)
    {
        try
        {
            stmt = conn.createStatement();
            stmt.execute("insert into " + tableName + " values (" +
                    id + ",'" + restName + "','" + cityName +"')");
            stmt.close();
        }
        catch (SQLException sqlExcept)
        {
            sqlExcept.printStackTrace();
        }
    }

    private static void selectRestaurants()
    {
        try
        {
            stmt = conn.createStatement();
            ResultSet results = stmt.executeQuery("select * from " + tableName);
            ResultSetMetaData rsmd = results.getMetaData();
            int numberCols = rsmd.getColumnCount();
            for (int i=1; i<=numberCols; i++)
            {
                //print Column Names
                System.out.print(rsmd.getColumnLabel(i)+"\t\t");
            }

            System.out.println("\n-------------------------------------------------");

            while(results.next())
            {
                int id = results.getInt(1);
                String restName = results.getString(2);
                String cityName = results.getString(3);
                System.out.println(id + "\t\t" + restName + "\t\t" + cityName);
            }
            results.close();
            stmt.close();
        }
        catch (SQLException sqlExcept)
        {
            sqlExcept.printStackTrace();
        }
    }

    private static void shutdown()
    {
        try
        {
            if (stmt != null)
            {
                stmt.close();
            }
            if (conn != null)
            {
                DriverManager.getConnection(dbURL + ";shutdown=true");
                conn.close();
            }
        }
        catch (SQLException sqlExcept)
        {

        }

    }
}