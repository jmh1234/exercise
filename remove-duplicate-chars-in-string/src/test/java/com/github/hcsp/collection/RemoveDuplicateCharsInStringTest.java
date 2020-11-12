package com.github.hcsp.collection;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RemoveDuplicateCharsInStringTest {
    @Test
    public void test() {
        Assertions.assertEquals(
                "cba", RemoveDuplicateCharsInString.removeDuplicateCharsInString("ccbbaa"));
        Assertions.assertEquals(
                "aple", RemoveDuplicateCharsInString.removeDuplicateCharsInString("apple"));
    }
}
