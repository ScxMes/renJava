/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Example1;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

/**
 *
 * @author Administrator
 */
public class Example3 {
     public static void  main(String [] args)
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
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
            ResultSet resultSet = stmt.executeQuery( "select * from goods" );
            resultSet.last();
            int rows = resultSet.getRow();
            System.out.println("goods表共有"+rows+"条记录");
            resultSet.afterLast();
            System.out.println("倒序输出goods表中的记录");
            while(resultSet.previous())
            {
                String id = resultSet.getString(1);
               String number = resultSet.getString(2);
               String name = resultSet.getString(3);
               Date date = resultSet.getDate("madetime");
               double price = resultSet.getDouble("price");
               System.out.printf("%-4s", id);
               System.out.printf("%-4s", number);
               System.out.printf("%-6s", name);
               System.out.printf("%-15s", date.toString());
               System.out.printf("%6s\n", price);
            }
            con.close();
        }
        catch(SQLException e)
        {
            System.out.println(e);
        }
    }
}
