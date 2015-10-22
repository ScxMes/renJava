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
import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * @author Administrator
 */
public class Example1 {
    
   public static void  main(String [] args)
   {
       String tableName,sql;
       String connUrl ="jdbc:mysql://10.251.234.121:3306/shop?"+"useUnicode=true&characterEncoding=UTF8";
       try
       {
           Class.forName("com.mysql.jdbc.Driver");
       }
       catch(ClassNotFoundException e)
       {
           System.out.println("驱动链接失败");
       }
        try
        {
            
            Connection con =  DriverManager.getConnection(connUrl,"admin","admin");
            Statement stmt = con.createStatement();
            tableName = "goods";
            sql = "create table " + tableName + " (id int,number text,name text,madetime datetime,price double) ENGINE=InnoDB DEFAULT CHARSET=utf8";
            int result = stmt.executeUpdate(sql);
            if(result != -1)
            {
                System.out.println("数据表创建成功");
                sql = "insert into " + tableName + " values('1','A001','宝马','1994-3-5','350000.00')";
                result = stmt.executeUpdate(sql);
                sql = "insert into " + tableName + " values('2','B002','奔驰','1996-9-8','360000.00')";
                result = stmt.executeUpdate(sql);
                ResultSet resultSet = stmt.executeQuery( "select * from "+tableName );
                String str="";
                while(resultSet.next())
                {
                    String temp = resultSet.getString("id") + " " + resultSet.getString("number") + " " +resultSet.getString("name")+ " " +resultSet.getString("madetime")+" "+resultSet.getString("price");
                    str += "\n" + temp;
                }
            
                System.out.print(str);
                
            }
            
        }catch(SQLException e)
        {
            
            System.out.println("操作失败");
        }
   }
 }
