/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Example1;

//import com.mysql.jdbc.Connection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;

/**
 *
 * @author Administrator
 */
public class Example1 {
    
   public static void  main(String [] args)
   {
       
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con =  DriverManager.getConnection("jdbc:mysql://asd123asd.mysql.rds.aliyuncs.com:3306/shop","mydb","asd123asd");
            Statement stmt = con.createStatement();
            ResultSet resultSet = stmt.executeQuery( "select * from goods" );
            String str="";
            while(resultSet.next())
            {
                String temp = resultSet.getString("id") + " " + resultSet.getString("number") + " " +resultSet.getString("name")+ " " +resultSet.getString("madetime")+" "+resultSet.getString("price");
                str += "\n" + temp;
            }
            
            System.out.print(str);
        }catch(Exception e)
        {
            
            
        }
   }
 
    
}
