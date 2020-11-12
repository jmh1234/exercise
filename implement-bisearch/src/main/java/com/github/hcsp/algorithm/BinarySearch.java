package com.github.hcsp.algorithm;

public class BinarySearch {
    public static void main(String[] args) {
        System.out.println(binarySearch(new String[]{"aaa", "ccc", "fff", "yyy", "zzz"}, "bbb"));
        System.out.println(binarySearch(new String[]{"aaa", "ccc", "fff", "yyy", "zzz"}, "yyy"));
    }

    // 给定一个按照字符串升序升序排好序的用户数组，寻找目标字符串的位置，返回其索引值
    // 如果未找到，返回-1
    // 我们鼓励你使用递归和非递归两种方式
    public static int binarySearch(String[] strings, String target) {
        // 调用api方法
        // return Collections.binarySearch(Arrays.asList(strings), target) < 0 ? -1 : Collections.binarySearch(Arrays.asList(strings), target);
        // 非递归(二分查找)
        int start = 0;
        int end = strings.length - 1;
        while (true) {
            if (strings[start].equals(target)) {
                return start;
            }
            if (strings[end].equals(target)) {
                return end;
            }
            if (strings[start].compareTo(target) > 0 || strings[end].compareTo(target) < 0) {
                return -1;
            }
            int mid = (start + end) / 2;
            if (strings[mid].compareTo(target) < 0) {
                start = mid + 1;
            } else if (strings[mid].compareTo(target) > 0) {
                end = mid - 1;
            } else {
                return mid;
            }
        }
        // 递归循环查找
        /*for (int i = 0; i < strings.length; i++) {
            if (strings[i].equals(target)) {
                return i;
            }
        }
        return -1;*/
    }
}
