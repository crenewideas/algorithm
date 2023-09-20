package main.java.cn.pxl.capture02;

import java.util.Arrays;

/**
 * @description: 归并排序
 * @author: pxlngu
 * @date: 2023-09-20 20:51
 */
public class Demo01Partition {
    public static void main(String[] args) {
        int[] ints = {1, 2, 4, 9, 5, 8, 6, 3, 7};
        doSort(ints, 0, 8);
        System.out.println(Arrays.toString(ints));
    }

    /***
     * @Description:
     * @Param: [oneArray, lowIndex, midIndex, highIndex]
     * @return: int[]
     * @Author: pxlngu
     * @Date: 2023/9/20
     */
    public static void doSort(int[] oneArray, int lowIndex, int highIndex) {
        if (lowIndex < highIndex) {
            int midIndex = (lowIndex + highIndex) / 2;
            doSort(oneArray, lowIndex, midIndex);
            doSort(oneArray, midIndex + 1, highIndex);
            merge(oneArray, lowIndex, midIndex, highIndex);
        }
    }


    /***
     * @Description:
     * @Param: [oneArray, lowIndex, midIndex, highIndex] oneArray 需要保证 ： [lowIndexIndex,midIndex],[midIndex,highIndex] 区间内的数据是有序的！
     * @return: void
     * @Author: pxlngu
     * @Date: 2023/9/20
     */
    public static void merge(int[] oneArray, int lowIndex, int midIndex, int highIndex) {
        int[] tempArray = new int[highIndex - lowIndex + 1];
        int i = lowIndex;
        int j = midIndex + 1;
        int k = 0;
        //当某一个到达最大值后，下一次循环跳出。
        while (i <= midIndex && j <= highIndex) {
            if (oneArray[i] < oneArray[j]) {
                tempArray[k++] = oneArray[i++];
            } else {
                tempArray[k++] = oneArray[j++];
            }
        }
        //循环跳出后，剩余的部分添加到临时数组中。
        while (i <= midIndex) {
            tempArray[k++] = oneArray[i++];
        }
        //循环跳出后，剩余的部分添加到临时数组中。
        while (j <= highIndex) {
            tempArray[k++] = oneArray[j++];
        }
        //将临时数组中的元素放置到原始数组中
        k = 0;
        for (i = lowIndex; i <= highIndex; i++) {
            oneArray[i] = tempArray[k++];
        }
    }


}
