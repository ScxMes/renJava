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
public class Example2 {
    public static void main(String args[])
    {
        Query query =new Query();
        String tablename = "goods";
        query.setTableName(tablename);
        query.setSQL("select * from "+tablename);
        query.inputQueryResult();
    }
}
