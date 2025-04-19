package Assignment_9;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection 
{
    public static Connection getConnection() throws Exception 
    {
        String url = "jdbc:mysql://localhost:3306/studentdb";
        String username = "root";
        String password = "Simba20042013";  //change this accordingly
        Class.forName("com.mysql.cj.jdbc.Driver");
        
        return DriverManager.getConnection(url, username, password);
    }
}
