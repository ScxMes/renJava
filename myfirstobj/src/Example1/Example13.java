/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Example1;
import java.util.Scanner;
/**
 *
 * @author Administrator
 */
public class Example13 {
    public static void main(String args[])
    {
        ReadExaminationParper reader;
        reader = new ReadExaminationParper();
        reader.setTableName("testForm");
        Scanner scan = new Scanner(System.in);
        int amount = reader.getAmount();
        if(amount==0)
        {
            System.out.printf("没有试题，无法考试");
            System.exit(0);
        }
        System.out.printf("试卷共有%d道题目\n",amount);
        System.out.printf("请输入题号:如 1,2...开始考试：");
        String timu[] = new String[7];
        while(scan.hasNextInt())
        {
            int number =scan.nextInt();
            String huiche = scan.nextLine();
            if(number>=1&&number<=amount)
            {
                timu = reader.getExamQuestion(number);
                for(int i=0;i<timu.length-1;i++)
                {
                    System.out.println(timu[i]);
                }
                System.out.printf("请输入选择答案:");
                String answer = scan.nextLine();
                if(answer.compareToIgnoreCase(timu[6])==0)
                    System.out.println("第"+number+"题做对了\t");
                else
                    System.out.println("第"+number+"题做错了\t");
                System.out.println("输入任意字母结束考试\t,输入题号继续考试");
            }
            else
            {
                System.out.printf("题号不合理\n");
                System.out.printf("输入任意字母结束考试，输入题号继续考试");
            }
                
        }
        
    }
    
}
