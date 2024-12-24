import java.util.Scanner;

import sourcefile.MemoryManager;

public class experienment_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("========== 初始化 ==========");
        System.out.println("请输入内存的大小：");
        int memorySize = sc.nextInt();

        // 动态分区管理器
        MemoryManager memoryManager = new MemoryManager(memorySize);

        while (true) {
            System.out.println("========== 菜单 ==========");
            System.out.println("1.显示分区分配情况");
            System.out.println("2.分配内存给进程");
            System.out.println("3.回收进程内存");
            System.out.println("0.退出程序");
            System.out.println("请输入你的选择：");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    memoryManager.showMemory();
                    break;
                case 2:
                    System.out.println("请输入进程的大小：");
                    int processSize = sc.nextInt();
                    System.out.println("请选择分配算法：");
                    System.out.println("1.最先适应法");
                    System.out.println("2.最佳适应法");
                    System.out.println("3.最坏适应法");
                    int algorithm = sc.nextInt();
                    memoryManager.allocate(processSize, algorithm);
                    break;
                case 3:
                    System.out.println("请输入要回收的进程号：");
                    int processId = sc.nextInt();
                    memoryManager.free(processId);
                    break;
                case 0:
                    System.out.println("退出成功!");
                    sc.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("无效的选择，请重新输入！");
            }
        }
    }
}
