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
import java.sql.Statement;
import com.sun.rowset.CachedRowSetImpl;
import java.sql.SQLException;
/**
 *
 * @author Administrator
 */
public class CachedQuery {
    String tablename;
    String SQL;
    CachedRowSetImpl rowSet;
    public CachedQuery()
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
        tablename=s.trim();
    }
    public void setSQL(String SQL)
    {
        this.SQL=SQL.trim();
    }
    
    public void inputQueryResult()
    {
        Connection con;
        Statement stmt;
        ResultSet rs;
        try
        {
           String uri="jdbc:mysql://10.251.234.158:3306/shop";
           String name = "sa";
           String password = "sa";
           con = DriverManager.getConnection(uri,name ,password);
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
           stmt=con.createStatement();
           rs=stmt.executeQuery(SQL);
           rowSet = new CachedRowSetImpl();
           rowSet.populate(rs);
           con.close();
           while(rowSet.next())
           {
               for(int i=1;i<=numberfilds;i++)
               {
                   System.out.print(" "+rowSet.getString(i)+" ");
               }
               System.out.println("");
           }
           
        }
        catch(SQLException e)
        {
            System.out.println("请输入正确的表名"+e);
        }
    }
}
