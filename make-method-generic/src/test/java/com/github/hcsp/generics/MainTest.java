package com.github.hcsp.generics;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MainTest {
    @Test
    public static void main(String[] args) {
        Assertions.assertTrue(Main.inAscOrder(1, 2, 3));
        Assertions.assertTrue(Main.inAscOrder(1L, 2L, 3L));
        Assertions.assertTrue(Main.inAscOrder(1d, 2d, 3d));
    }
}
