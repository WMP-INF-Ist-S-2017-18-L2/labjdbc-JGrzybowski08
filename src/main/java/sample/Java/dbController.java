package sample.Java;

import java.sql.*;
import java.util.*;

public class dbController {


    public Connection Connect() throws SQLException
    {
        System.out.println("-------- PostgreSQL "
                + "JDBC Connection Testing ------------");

        try {

            Class.forName("org.postgresql.Driver");

        } catch (ClassNotFoundException e) {

            System.out.println("Where is your PostgreSQL JDBC Driver? "
                    + "Include in your library path!");
            e.printStackTrace();


        }

        System.out.println("PostgreSQL JDBC Driver Registered!");


        Connection conn = null;
try {
    String url = "jdbc:postgresql://localhost:5432/postgres?user=postgres&password=root&ssl=false";
    conn = DriverManager.getConnection(url);

} catch (Exception e){
    System.out.println("Failed to create JDBC db connection " + e.toString() + e.getMessage());
}
        return conn;
}

}
