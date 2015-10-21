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
/**
 *
 * @author Administrator
 */
public class Example11 {
    public static void main(String args[])
    {
        Connection con = null;
        Statement stmt;
        ResultSet rs;
        String url="jdbc:mysql://10.251.234.158:3306/shop";
        String name = "sa";
        String password = "sa";
        String sqlarray[] = new String[4];
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
           double n = 500;
           con = DriverManager.getConnection(url, name, password);
           con.setAutoCommit(false);
           stmt = con.createStatement();
           sqlarray[0] = "update goods set price = 5555 where number = 'A001'";
           sqlarray[1] = "update goods set name = 'haierTV' where number = 'A001'";
           sqlarray[2] = "update goods set price = '8765' where number = 'B002'";
           sqlarray[3] = "insert into goods values ('9','A777','北京电视机','2010-12-20',3976)";
           stmt.addBatch(sqlarray[0]);
           stmt.addBatch(sqlarray[1]);
           stmt.addBatch(sqlarray[2]);
           stmt.addBatch(sqlarray[3]);
           int [] number = stmt.executeBatch();
           con.commit();
           System.out.println("共有"+number.length+"条SQL语句被执行");
           
           stmt.clearBatch();
           for(int i = 0;i<number.length;i++)
               System.out.println(number[i]);
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
