package com.github.hcsp.datastructure;

public class Stack {
    private Integer[] array;
    private int length = 1;
    private int size = 0;

    public Stack() {
        this.array = new Integer[length];
    }

    // 将一个元素压入栈内
    public void push(int value) {
        if (length == size) {
            addRange();
        }
        array[size] = value;
        size++;
    }

    private void addRange() {
        int newLength = (int) (length * 1.5) + 1;
        Integer[] newArr = new Integer[newLength];
        for (int i = 0; i < array.length; i++) {
            newArr[i] = array[i];
        }
        array = newArr;
        length = newLength;
    }

    // 从栈顶弹出一个元素
    public int pop() {
        size--;
        return array[size];
    }
}
