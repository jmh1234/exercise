package com.github.hcsp;

public class Main {
    public static void main(String[] args) {
        // Complete createDoublyLinkedList() method to make the program output "3,2,1"
        // 补全createDoublyLinkedList()使得程序输出"3,2,1"
        LinkedListNode head = createDoublyLinkedList();
        LinkedListNode tail = head.next.next;
        System.out.println("" + tail.value + "," + tail.prev.value + "," + tail.prev.prev.value);
    }

    // Create a doubly linked list: 1 ⇋ 2 ⇋ 3 and return the head node
    // 创建一个这样的双向链表：1 ⇋ 2 ⇋ 3 并返回头节点
    public static LinkedListNode createDoublyLinkedList() {
        LinkedListNode node1 = new LinkedListNode();
        LinkedListNode node2 = new LinkedListNode();
        LinkedListNode node3 = new LinkedListNode();
        node1.value = 1;
        node2.value = 2;
        node3.value = 3;

        node1.next = node2;
        node2.prev = node1;
        node2.next = node3;
        node3.prev = node2;
        return node1;
    }
}
