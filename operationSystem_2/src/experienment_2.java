import java.util.Scanner;

import sourcefile.fcfs;
import sourcefile.scan;
import sourcefile.sstf;

public class experienment_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        while (true) {  // 无限循环，直到用户选择退出
            System.out.println("请输入当前磁头位置：");
            int start = sc.nextInt();
            
            System.out.println("请输入磁道的数目：");
            int num = sc.nextInt();
            
            System.out.println("请输入磁道访问请求序列：");
            int[] a = new int[num];
            for (int i = 0; i < num; i++) {
                a[i] = sc.nextInt();
            }
            
            System.out.println("调度算法：");
            System.out.println("1.先来先服务");
            System.out.println("2.最短寻道时间优先");
            System.out.println("3.电梯算法");
            System.out.println("请选择算法：");
            int choice = sc.nextInt();
            
            // 调度算法选择
            if (choice == 1) {
                fcfs i1 = new fcfs(a, num, start);
                i1.print();
            } else if (choice == 2) {
                sstf i2 = new sstf(a, num, start);
                i2.print();
            } else if (choice == 3) {
                System.out.println("请输入磁头移动的方向(左/右)：");
                int direction = sc.nextInt();
                scan i3 = new scan(a, num, start, direction);
                i3.print();
            } else {
                System.out.println("无效的选择，请重新选择算法！");
                continue;  // 如果用户输入无效的算法选择，则继续循环
            }
            
            // 提示用户是否继续
            System.out.println("\n是否继续进行新的磁盘调度实验？(y/n)：");
            String continueChoice = sc.next();
            if (continueChoice.equalsIgnoreCase("n")) {
                System.out.println("程序结束！");
                break;  // 用户选择退出，跳出循环，结束程序
            }
        }
        
        sc.close();  // 关闭Scanner
    }
}
