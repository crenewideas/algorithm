package main.java.cn.pxl.component;

import java.util.Scanner;

public class ScannerUtil {

    public static int[] multIntArray(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入整数的个数：");
        int n = scanner.nextInt();
        int[] numbers = new int[n];
        System.out.println("请输入" + n + "个整数：");
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
        }
        return numbers;
    }

}
