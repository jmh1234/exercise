package com.github.hcsp.collection;

import java.util.HashSet;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PersonTest {
    @Test
    public void testEquals() {
        Assertions.assertEquals(new Person("1"), new Person("1"));
        Assertions.assertNotEquals(new Person("1"), new Person("2"));

        Person person = new Person("1");
        person.setAge(20);

        Assertions.assertEquals(person, new Person("1"));
    }

    @Test
    public void testContains() {
        Person person = new Person("1");
        HashSet<Person> set = new HashSet<>();
        set.add(person);

        Assertions.assertTrue(set.contains(person));
        person.setName("张三");
        Assertions.assertTrue(set.contains(person));
    }
}
