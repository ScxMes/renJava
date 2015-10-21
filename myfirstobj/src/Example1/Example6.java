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
public class Example6 {//运行结果有问题
    public static void main(String args[])
    {
        Query query = new Query();
        String tablename = "goods";
        query.setTableName(tablename);
        String SQL= "select * from " +tablename+ " where name like '%[T宝]%'";
        query.setSQL(SQL);
        System.out.println(tablename+"表中商品名称中含有T或宝的记录");
        query.inputQueryResult();
        
        
    }
    
}
