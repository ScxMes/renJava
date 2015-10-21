/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Example1;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author Administrator
 */
public class ReadExaminationParper {
    String tablename;
    Connection con;
    Statement stmt;
    ResultSet rs;
    String url = "jdbc:mysql://10.251.234.158:3306/shop";
    String name = "sa";
    String password = "sa";
    public ReadExaminationParper()
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
    public String[] getExamQuestion(int number)
    {
        String [] examinationpaper = new String [7];
        try
        {
            con = DriverManager.getConnection(url, name, password);
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery("select * from testForm");
            rs.absolute(number);
            examinationpaper[0] = rs.getString(1);
            examinationpaper[1] = rs.getString(2);
            examinationpaper[2] = rs.getString(3);
            examinationpaper[3] = rs.getString(4);
            examinationpaper[4] = rs.getString(5);
            examinationpaper[5] = rs.getString(6);
            examinationpaper[6] = rs.getString(7);
            con.close();
        }
        catch(SQLException e)
        {
            System.out.println("无法获得试题"+e);
        }
        return examinationpaper;
    }
    public void setTableName(String s)
    {
        tablename =s;
    }
}
