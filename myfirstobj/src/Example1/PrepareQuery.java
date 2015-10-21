/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Example1;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
/**
 *
 * @author Administrator
 */
public class PrepareQuery {
    String SQL,tablename;
    String url="jdbc:mysql://10.251.234.158:3306/shop";
    String name = "sa";
    String password = "sa";
    public PrepareQuery()
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
    public void setSQL(String SQL)
    {
        this.SQL=SQL;
    }
    public void setTableName(String s)
    {
        tablename=s.trim();
    }
    
     public void inputQueryResult()
    {
        Connection con;
        PreparedStatement stmt;
        ResultSet rs;
        try
        {
          
           con = DriverManager.getConnection(url,name ,password);
           DatabaseMetaData metadata = con.getMetaData();
           ResultSet rs1 = metadata.getColumns(null,null,tablename,null);
           int numberfilds = 0;
           String str = "";
           while(rs1.next())
           {   //怎么无法输出表的字段信息
               numberfilds++;
               String temp=rs1.getString(1) + " " + rs1.getString(2) + " " + rs1.getString(3) + " " + rs1.getString(4);
               str += "\n" + temp;
           }
           System.out.println(str);
           stmt=con.prepareStatement(SQL);
           rs=stmt.executeQuery();
           while(rs.next())
           {
               for(int k=1;k<=numberfilds;k++)
               {
                   System.out.print(""+rs.getString(k)+"");
                   
               }
               System.out.println("");
           }
           con.close();
           
        }
        catch(SQLException e)
        {
            System.out.println("请输入正确的表名"+e);
        }
    }
    
}
