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
public class Example9 {
    public static void main(String args[])
    {
        AddRecord insertrecord = new AddRecord();
        String tablename = "goods";
        insertrecord.setTableName(tablename);
        insertrecord.setId(7);
        insertrecord.setNumber("D001");
        insertrecord.setName("联想电脑");
        insertrecord.setMageTime("2010-12-10");
        insertrecord.setPrice(7000);
        String backmess = insertrecord.addRecord();
        System.out.println(backmess);
    }
    
}
