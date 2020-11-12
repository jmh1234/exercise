package com.github.hcsp.generics;

public class Main {
    // 这里有四个结构、功能非常相似的方法，请尝试将其泛型化，以简化代码
    // 泛型化之后的方法签名应该如下所示：
    // public static boolean inAscOrder(T a, T b, T c)
    public static boolean inAscOrder1(int a, int b, int c) {
        return a <= b && b <= c;
    }

    public static boolean inAscOrder2(long a, long b, long c) {
        return a <= b && b <= c;
    }

    public static boolean inAscOrder3(double a, double b, double c) {
        return a <= b && b <= c;
    }

    public static <T extends Comparable<T>> boolean inAscOrder(T a, T b, T c) {
        return a.compareTo(b) <= 0 && b.compareTo(c) <= 0;
    }

    public static void main(String[] args) {
        System.out.println(inAscOrder1(1, 2, 3));
        System.out.println(inAscOrder2(1L, 2L, 3L));
        System.out.println(inAscOrder3(1d, 2d, 3d));
    }
}
