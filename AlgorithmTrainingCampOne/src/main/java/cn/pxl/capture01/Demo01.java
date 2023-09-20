package main.java.cn.pxl.capture01;

import java.util.Scanner;

import static main.java.cn.pxl.component.ScannerUtil.*;

public class Demo01 {
    public static void main(String[] args) {
//        demo02_2();
//        demo1_38_2(4, 4);
//        demo1_39(20, 30, 31);
//        demo1_40(20, 30, 31);
        demo1_41_2(4);
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

    //1_38 现在有 n 盏灯，编号为 1～n ，开始时所有的灯都是关的，编号为1的人走过来，把编号是1的倍数的灯开关按下（开的关
    //上，关的打开），编号为2的人把编号是2的倍数的灯开关按下，编号为3的人又把编号是3的倍数的灯开关按下……直到第k 个人为止。
    //给定n 和k （0<n ,k ≤1000），输出哪几盏灯是开着的
    //输入 n 个整数，倒序输出所有整数。
    public static void demo1_38(int n, int k) {
        int[] arrays = new int[n];
        for (int i = 0; i < n; i++) {
            arrays[n - 1] = 0;
        }
        for (int i = 0; i < k; i++) {
            //初始index值
            int originIndexCount = i + 1;
            int indexCount = i + 1;
            while (indexCount <= n) {
                if (indexCount % originIndexCount == 0) {
                    arrays[indexCount - 1] = arrays[indexCount - 1] == 0 ? 1 : 0;
                }
                indexCount++;
            }
        }
        for (int i = 0; i < n; i++) {
            if (arrays[i] == 1) {
                System.out.println(i + 1);
            }
        }
    }

    public static void demo1_38_2(int n, int k) {
        int[] arrays = new int[n];
        for (int i = 0; i < n; i++) {
            arrays[n - 1] = 0;
        }
        for (int i = 1; i <= k; i++) {
            for (int j = 1; j <= n; j++) {
                //第i个人操作第j盏灯
                if (j % i == 0) {
                    arrays[j - 1] = arrays[j - 1] == 0 ? 1 : 0;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (arrays[i] == 1) {
                System.out.println(i + 1);
            }
        }
    }

    //训练1-39： 输入n 个学生的成绩（整数）并将其存入数组中，
    //求其总成绩和平均成绩（浮点数）。
    public static void demo1_39(int... values) {
        int length = values.length;

        int sumValue = 0;
        for (int value : values) {
            sumValue += value;
        }
        double avarageValue = sumValue / length;
        System.out.println("sum=" + sumValue);
        System.out.println("avarage=" + avarageValue);
    }

    //训练1-40： 输入n 个学生的成绩并将其存入数组中，求其最低
    //分和最高分。
    public static void demo1_40(int... values) {
        int length = values.length;
        int maxValue = Integer.MIN_VALUE;
        int minValue = Integer.MAX_VALUE;
        for (int value : values) {
            if (value > maxValue) {
                maxValue = value;
            }
            if (value < minValue) {
                minValue = value;
            }
        }
        System.out.println("minValue=" + minValue);
        System.out.println("maxValue=" + maxValue);
    }

    //训练1-42： 蛇形填数，输入一个整数n ，按照蛇形填写 n × n
    //的矩阵。
    public static void demo1_41(int n) {
        int[][] doubleArray = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int i1 = 0; i1 < n; i1++) {
                doubleArray[i][i1] = 0;
            }
        }
        int total = doubleArray[0][0] = 1;
        int x = 0;
        int y = 0;
        int finalValue = n*n;
        while (total < finalValue){
            while (x + 1 < n && doubleArray[x + 1][y] == 0 ) {
                doubleArray[++x][y] = ++total;
            }
            while (y + 1 < n && doubleArray[x][y + 1] == 0 ) {
                doubleArray[x][++y] = ++total;
            }
            while (x > 0 && doubleArray[x - 1][y] == 0 ) {
                doubleArray[--x][y] = ++total;
            }
            while (y > 0 && doubleArray[x][y -1] == 0 ) {
                doubleArray[x][--y] = ++total;
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.println();
            for (int i1 = 0; i1 < n; i1++) {
                System.out.print(doubleArray[i][i1]);
            }
        }
        System.out.println();
    }

    //训练1-42： 蛇形填数，输入一个整数n ，按照蛇形填写 n × n
    //的矩阵。
    public static void demo1_41_2(int n) {
        int[][] doubleArray = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int i1 = 0; i1 < n; i1++) {
                doubleArray[i][i1] = 0;
            }
        }
        int total = doubleArray[0][0] = 1;
        int x = 0;
        int y = 0;
        int finalValue = n*n;
        while (total < finalValue){
            while (x + 1 < n && doubleArray[y][x + 1] == 0 ) {
                doubleArray[y][++x] = ++total;
            }
            while (y + 1 < n && doubleArray[y + 1][x] == 0 ) {
                doubleArray[++y][x] = ++total;
            }
            while (x > 0 && doubleArray[y][x - 1] == 0 ) {
                doubleArray[y][--x] = ++total;
            }
            while (y > 0 && doubleArray[y -1][x] == 0 ) {
                doubleArray[--y][x] = ++total;
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.println();
            for (int i1 = 0; i1 < n; i1++) {
                String str = String.valueOf(doubleArray[i][i1]);
                if(str.length() ==1){
                    str = str + "  ";
                }
                if(str.length() ==2){
                    str = str + " ";
                }
                System.out.print(str);
            }
        }
        System.out.println();
    }
}
