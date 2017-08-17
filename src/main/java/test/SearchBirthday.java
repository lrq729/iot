package test;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.text.SimpleDateFormat;


public class SearchBirthday {

    private static  String URL = "jdbc:sqlserver://192.168.99.159:1433;databaseName=ekito6";
    private static  String USER = "sa";
    private static  String PASSWORD = "kitodatabase";
    public static void main(String args[]) throws Exception {

        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        Connection con = DriverManager.getConnection(URL,USER,PASSWORD);
        Statement statement = con.createStatement();
        ResultSet rSet = statement.executeQuery("SELECT Name,BirthDate from hrstaffinfo");

        SimpleDateFormat sdf = new SimpleDateFormat("MM-dd");
        String D = sdf.format(new Date());

        List L = new ArrayList();

        while (rSet.next()) {
            String n = rSet.getString("Name");
            String str = rSet.getString("BirthDate");
            if (str != null &&  n != null) {
                String d = str.substring(5,10);
                if (d.equals(D)){
                    L.add(n);
                }
            }
        }
        System.out.println(L);
    }
}


