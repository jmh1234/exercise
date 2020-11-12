package com.github.hcsp.algorithm;

import java.util.Arrays;

public class Sort {
    public static void main(String[] args) {
        int[] array1 = new int[]{4, 8, 1, 7, 4, 0, 5, 8, 7, 5, 9, 6, 4, 0};
        int[] array2 = new int[]{4, 8, 1, 7, 4, 0, 5, 8, 7, 5, 9, 6, 4, 0};
        sort1(array1);
        sort2(array2);

        System.out.println(Arrays.toString(array1));
        System.out.println(Arrays.toString(array2));
    }

    // 排序算法1
    // 按照从小到大排序
    public static void sort1(int[] array) {
//        Arrays.sort(array);
        for (int i = 0; i < array.length - 1; i++) {
            int minValue = array[i];
            int minSerial = i;
            for (int j = i; j < array.length; j++) {
                if (minValue > array[j]) {
                    minValue = array[j];
                    minSerial = j;
                }
            }
            int mid = array[i];
            array[i] = minValue;
            array[minSerial] = mid;
        }
    }

    // 排序算法2
    // 按照从小到大排序
    public static void sort2(int[] array) {
        // 冒泡
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int min = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = min;
                }
            }
        }
    }
}
