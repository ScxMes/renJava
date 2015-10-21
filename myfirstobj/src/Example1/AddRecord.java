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
import java.sql.PreparedStatement;
/**
 *
 * @author Administrator
 */
public class AddRecord {
    String SQL,tablename;
    String url="jdbc:mysql://10.251.234.158:3306/shop";
    String username = "sa";
    String password = "sa";
    String number,name ="" ,madetime;
    int id;
    double price;
    public AddRecord()
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
    public void setTableName(String s)
    {
        tablename = s.trim();
    }
    public void setId(int n)
    {
        id=n;
    }
    public void setNumber(String s)
    {
        number = s.trim();
    }
    public void setName(String s)
    {
        name = s.trim();
    }
    public void setPrice(double n)
    {
        price =n;
    }
    public void setMageTime(String b)
    {
        madetime = b;
    }
    public String addRecord()
    {
        String str = "";
        Connection con;
        PreparedStatement stmt;
        ResultSet rs;
        try
        {
          
           con = DriverManager.getConnection(url,username ,password);
           String insertCondition = "insert into goods values (?,?,?,?,?)";
           stmt = con.prepareStatement(insertCondition);
           if(number.length()>0)
           {
               stmt.setInt(1,id);
               stmt.setString(2,number);
               stmt.setString(3,name);
               stmt.setString(4,madetime);
               stmt.setDouble(5, price);
               int m= stmt.executeUpdate();
               if(m!=0)
                   str = "对表中添加" +m+ "条记录成功";
               else 
                   str = "添加记录失败";
            }
            else
           {
               str="必须要有雇员号";
           }
           con.close();
        }
        catch(SQLException e)
        {
            str = "没有提供添加的数据或"+e;
            
        }
        return str;
    }
}
