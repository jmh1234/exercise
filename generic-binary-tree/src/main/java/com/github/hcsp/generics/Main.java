package com.github.hcsp.generics;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Main {
    static class IntBinaryTreeNode {
        int value;
        IntBinaryTreeNode left;
        IntBinaryTreeNode right;
    }

    static class StringBinaryTreeNode {
        String value;
        StringBinaryTreeNode left;
        StringBinaryTreeNode right;
    }

    static class DoubleBinaryTreeNode {
        double value;
        DoubleBinaryTreeNode left;
        DoubleBinaryTreeNode right;
    }

    // 你看，上面三种"二叉树节点"结构相似，内容重复，请将其泛型化，以节省代码
    static class BinaryTreeNode<T extends Number> {
        T value;
        BinaryTreeNode left;
        BinaryTreeNode right;
    }

    // 泛型化之后，请再编写一个算法，对二叉树进行中序遍历，返回中序遍历的结果
    public static <T extends Number> List<?> inorderTraversal(BinaryTreeNode<T> root) {
        List<Number> resultList = new ArrayList<>();
        Stack<BinaryTreeNode> stack = new Stack<>();
        BinaryTreeNode node = root;
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
        while (!stack.empty()) {
            BinaryTreeNode pop = stack.pop();
            if (pop.right != null) {
                stack.push(pop.right);
            }
            resultList.add(pop.value);
        }
        return resultList;
    }
}
