package com.github.hcsp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MainTest {
    @Test
    public void linkedListTest() {
        LinkedListNode l = Main.createDoublyLinkedList();
        Assertions.assertEquals(1, l.value);
        Assertions.assertEquals(2, l.next.value);
        Assertions.assertEquals(3, l.next.next.value);
        Assertions.assertEquals(null, l.next.next.next);
        Assertions.assertTrue(l.next.prev == l);
        Assertions.assertTrue(l.next.next.prev == l.next);
    }
}
