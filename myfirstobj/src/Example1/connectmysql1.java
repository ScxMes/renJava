/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Example1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.Date;
/**
 *
 * @author Administrator
 */
public class connectmysql1 {
    public  void  queryresult()
   {
       try
       {
           Class.forName("com.mysql.jdbc.Driver");
       }
       
       catch(ClassNotFoundException e)
       {
           System.out.print(e);
       }
      
        try
        {
            
            Connection con =  DriverManager.getConnection("jdbc:mysql://10.251.234.158:3306/shop","sa","sa");
            Statement stmt = con.createStatement();
            ResultSet resultSet = stmt.executeQuery( "select * from goods" );
            String str="";
            while(resultSet.next())
            {
                String temp = resultSet.getString("id") + " " + resultSet.getString("number") + " " +resultSet.getString("name")+ " " +resultSet.getString("madetime")+" "+resultSet.getString("price");
                str += "\n" + temp;
            }
            System.out.println(str);
            
            ResultSet rs = stmt.executeQuery( "select * from goods" );
            while(rs.next())
            {
               String id = rs.getString(1);
               String number = rs.getString(2);
               String name = rs.getString(3);
               Date date = rs.getDate("madetime");
               double price = rs.getDouble("price");
               System.out.printf("%-4s", id);
               System.out.printf("%-4s", number);
               System.out.printf("%-6s", name);
               System.out.printf("%-15s", date.toString());
               System.out.printf("%6s\n", price);
               
            }
        }catch(SQLException e)
        {
            System.out.println(e);
            
        }
   }
}
