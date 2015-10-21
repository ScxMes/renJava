/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Example1;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.SQLException;
/*
 *
 * @author Administrator
 */
public class Example10 {
    public static void main(String args[])
    {
        Connection con = null;
        Statement stmt;
        ResultSet rs;
        String url="jdbc:mysql://10.251.234.158:3306/shop";
        String name = "sa";
        String password = "sa";
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
           double n = 1;
           con = DriverManager.getConnection(url, name, password);
           con.setAutoCommit(false);
           stmt = con.createStatement();
           rs=stmt.executeQuery("select * from goods where number = 'A001'");
           rs.next();
           double priceone = rs.getDouble("price");
           System.out.println("事务操作之前A001的price:"+priceone);
           rs=stmt.executeQuery("select * from goods where number = 'B002'");
           rs.next();
           double pricetwo = rs.getDouble("price");
           System.out.println("事务操作之前B002的price:"+pricetwo);
           priceone = priceone - n;
           pricetwo = pricetwo + n;
           stmt.executeUpdate("update goods set price = "+priceone+" where number = 'A001'");
           stmt.executeUpdate("update goods set price = "+pricetwo+" where number = 'B002'");
           con.commit();
           con.setAutoCommit(true);
           rs=stmt.executeQuery("select * from goods where number = 'A001'");
           rs.next();
           priceone = rs.getDouble("price");
           System.out.println("事务操作之后A001的price:"+priceone);
           rs=stmt.executeQuery("select * from goods where number = 'B002'");
           rs.next();
           pricetwo = rs.getDouble("price");
           System.out.println("事务操作之后B002的price:"+pricetwo);
           con.close();
           
       }
       catch(SQLException e)
       {
           try
           {
               con.rollback();
           }
           catch(SQLException exp){}
           
           System.out.println(e);
           
       }
    }
    
}
