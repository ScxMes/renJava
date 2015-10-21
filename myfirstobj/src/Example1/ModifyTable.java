/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Example1;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
//import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author Administrator
 */
public class ModifyTable {
    String SQL,message="";
    String url="jdbc:mysql://10.251.234.158:3306/shop";
    String name = "sa";
    String password = "sa";
    public ModifyTable()
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
    public String modifyRecord()
    {
        Connection con = null;
        Statement stmt = null;
        try
        {
            
            con = DriverManager.getConnection(url, name, password);
            stmt=con.createStatement();
            stmt.execute(SQL);
            message="操作成功";
            con.close();
        }
        catch(SQLException e)
        {
            message = e.toString();
        }
        return message;
    }
}
