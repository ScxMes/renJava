/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Example1;


import javax.swing.JTable; 
import javax.swing.JFrame;
import javax.swing.JScrollPane;


/**
 *
 * @author Administrator
 */
public class Example14 {
   public static void main(String args[])
   {
       JTable table;
       QueryTwo querytwo = new QueryTwo();
       querytwo.setTableName("goods");
       Object a[][]=querytwo.getRecord();
       int m = a[0].length;
       String b[] = new String [m];
       for(int i=0;i<m;i++)
       {
           b[i] = "字段"+(i+1);
       }
       table = new JTable(a,b);
       JFrame frame =new JFrame();
       frame.add(new JScrollPane(table));
       
       frame.setBounds(20,20,300,400);
       frame.setVisible(true);
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }
    
}
