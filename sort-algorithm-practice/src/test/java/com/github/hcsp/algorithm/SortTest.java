package com.github.hcsp.algorithm;

import java.util.Arrays;
import java.util.Random;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SortTest {
    int[] randomArray = new int[10];

    {
        Random r = new Random();
        for (int i = 0; i < 10; i++) {
            randomArray[i] = r.nextInt(10);
        }
    }

    @Test
    public void sort1Test() {
        int[] copy = Arrays.copyOf(randomArray, 10);
        Arrays.sort(copy);

        System.out.println("Before: " + Arrays.toString(randomArray));
        Sort.sort1(randomArray);
        System.out.println("After: " + Arrays.toString(randomArray));
        Assertions.assertArrayEquals(copy, randomArray);
    }

    @Test
    public void sort2Test() {
        int[] copy = Arrays.copyOf(randomArray, 10);
        Arrays.sort(copy);

        System.out.println("Before: " + Arrays.toString(randomArray));
        Sort.sort2(randomArray);
        System.out.println("After: " + Arrays.toString(randomArray));
        Assertions.assertArrayEquals(copy, randomArray);
    }
}
