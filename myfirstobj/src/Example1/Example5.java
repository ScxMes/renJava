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
public class Example5 {
    public static void main(String args[])
    {
        Query query = new Query();
        String tablename = "goods";
        query.setTableName(tablename);
        String SQL = "select * from "+tablename+" order by name";
        query.setSQL(SQL);
        System.out.println(tablename+"表记录按商品名称排序");
        query.inputQueryResult();
        SQL="select * from "+ tablename+" order by price";
        query.setSQL(SQL);
        System.out.println(tablename+"表记录按商品价格排序");
        query.inputQueryResult();
    }
    
}
