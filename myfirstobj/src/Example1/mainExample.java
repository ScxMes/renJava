/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Example1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Administrator
 */
public class mainExample {
    
    String url = "jdbc:mysql://10.251.234.158:3306/shop";
    String name = "sa";
    String password = "sa";
    Connection con;
    public void loaddrive()
    {
         try
       {
           Class.forName("com.mysql.jdbc.Driver");
       }
       
       catch(ClassNotFoundException e)
       {
           System.out.print(e);
       }
    }
    
    public void createconnectionandstatementobject()
    {
        try
        {
           con =  DriverManager.getConnection(url,name,password);
            Statement stmt = con.createStatement();
        }
        catch(SQLException e)
        {
            System.out.print(e);
        }
    }
    
   
        
    public static void main(String args[])
    {
        
        
    }
    
}
