package com.github.hcsp.datastructure;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StackQueueTest {
    List<Integer> numbers = IntStream.range(0, 10).boxed().collect(Collectors.toList());

    @Test
    public void stackTest() {
        Stack stack = new Stack();
        numbers.forEach(stack::push);
        Collections.reverse(numbers);
        Assertions.assertEquals(
                numbers,
                IntStream.range(0, 10).mapToObj(i -> stack.pop()).collect(Collectors.toList()));
    }

    @Test
    public void queueTest() {
        Queue queue = new Queue();
        numbers.forEach(queue::add);
        Assertions.assertEquals(
                numbers,
                IntStream.range(0, 10).mapToObj(i -> queue.remove()).collect(Collectors.toList()));
    }
}
