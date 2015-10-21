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
import java.sql.PreparedStatement;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;
/**
 *
 * @author Administrator
 */
public class QueryTwo {
    String tablename;
    Object a[][];
    Connection con;
    Statement stmt;
    ResultSet rs;
    String url = "jdbc:mysql://10.251.234.158:3306/shop";
    String name = "sa";
    String password = "sa";
     public QueryTwo()
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
        tablename =s;
    }
     public Object[][] getRecord()
     {
         PreparedStatement pstmt;
         try
        {
            con = DriverManager.getConnection(url, name, password);
            DatabaseMetaData metadata = con.getMetaData();
            rs = metadata.getColumns(null, null, tablename, null);
            int numberfilds = 0;
            while(rs.next())
            {
                numberfilds++;
            }
            int n =getAmount();
            a = new Object[n][numberfilds];
            pstmt = con.prepareStatement("select * from "+tablename);
            rs=pstmt.executeQuery();
            int m = 0;
            while(rs.next())
            {
                for(int i=1;i<=numberfilds;i++)
                {
                    a[m][i-1] = rs.getString(i);
                }
                m++;
            }
            con.close();
            
        }
         catch(SQLException e)
         {
             System.out.println("请输入正确的表名"+e);
         }
         return a;
     }
     public int getAmount()
     {
         try
        {
            
            con = DriverManager.getConnection(url, name, password);
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery("select * from "+tablename);
            rs.last();
            int rows = rs.getRow();
            return rows;
        }
        catch(SQLException e)
        {
            System.out.println(e);
            return 0;
        }
     }
    
}
