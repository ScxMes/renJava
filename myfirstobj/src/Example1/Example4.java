/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Example1;

/**
 *
 * @author Administrator
 */
public class Example4 {
    public static void main(String args[])
    {
        Query query = new Query();
        String tablename = "goods";
        query.setTableName(tablename);
        String number = "A001";
        String SQL = "select * from " + tablename + " where number = '"+number+"'";//注意SQL语句中的空格情况
        query.setSQL(SQL);
        System.out.println(tablename+"表中商品号是"+number+"的记录");
        query.inputQueryResult();
        double max = 300000,min = 260000;
        SQL="select * from " + tablename + " where price >= "+min+" and price <= "+max;
        query.setSQL(SQL);
        System.out.println(tablename+"表中价格在"+min+"和"+max+"之间的记录");
        query.inputQueryResult();
    }
    
}
