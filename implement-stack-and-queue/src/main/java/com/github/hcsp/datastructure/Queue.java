package com.github.hcsp.datastructure;

public class Queue {
    private Integer[] array;
    private int length = 1;
    private int size = 0;
    private int serial = -1;

    public Queue() {
        this.array = new Integer[length];
    }

    // 将一个元素添加到队列尾部
    public void add(int value) {
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

    // 将一个元素从队列头部移走
    public int remove() {
        serial++;
        return array[serial];
    }
}
