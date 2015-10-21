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
public class Example7 {
    public static void main(String args[])
    {
        ModifyTable modify = new ModifyTable();
        String sql = "update goods set price = 3009 where name ='海尔电视机'";
        modify.setSQL(sql);
        String backmess=modify.modifyRecord();
        System.out.println(backmess);
        sql="insert into goods values ('5','A009','手机','2010-12-20','3976')";
        modify.setSQL(sql);
        backmess=modify.modifyRecord();
        System.out.println(backmess);
    }
    
}
