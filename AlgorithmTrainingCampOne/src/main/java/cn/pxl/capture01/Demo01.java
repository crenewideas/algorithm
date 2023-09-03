package main.java.cn.pxl.capture01;

import java.util.Scanner;
import static main.java.cn.pxl.component.ScannerUtil.*;

public class Demo01 {
    public static void main(String[] args) {
        demo02_2();
    }

    //1-15
    public static void demo01() {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String next = scanner.next();
            Integer value = Integer.valueOf(next);
            int result = 1;
            for (Integer count = 1; count <= value; count++) {
                result = result * count;
            }
            System.out.println(result);
        }
    }

    //1-16
    public static void demo02_1() {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String next = scanner.next();
            Integer value = Integer.valueOf(next);
            System.out.println(FN(value));
        }
    }

    //1-16
    public static void demo02_2() {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String next = scanner.next();
            Integer value = Integer.valueOf(next);
            System.out.println(FN2(value));
        }
    }

    //1-32 输入 n 个整数，倒序输出所有整数。
    public static void demo1_32() {
        int[] arrays = multIntArray();

    }

    public static int FN(int n) {
        if (n == 1) return 1;
        if (n == 2) return 1;
        return FN(n - 1) + FN(n - 2);
    }

    public static long FN2(int n) {
        long[] array = new long[100];
        array[0] = 1;
        array[1] = 1;
        for (int i = 2; i < n; i++) {
            array[i] = array[i - 1] + array[i - 2];
        }
        return array[n - 1];
    }

}
