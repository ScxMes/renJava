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
public class Example8 {
    public static void main(String args[])
    {
        PrepareQuery query = new PrepareQuery();
        String tablename = "goods";
        query.setTableName(tablename);
        String sql="select * from " + tablename;
        query.setSQL(sql);
        query.inputQueryResult();
    }
    
}
