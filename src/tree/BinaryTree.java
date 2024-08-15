package tree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
    Node root;
    static class Node {
        Node left;
        Node right;
        int value;
        Node(int value){
            this.value = value;
            left = null;
            right = null;
        }
    }
    public BinaryTree(int value){
        root = new Node(value);
    }

    public void insert(int val){
        if (root == null){
            root = new Node(val);
        }

        insertLevelOrder(root,val);
    }
    private void insertLevelOrder(Node root,int value){
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()){
            Node current = queue.poll();

            if (current.left == null){
                current.left = new Node(value);
                return;
            }else {
                queue.add(current.left);
            }

            if (current.right == null){
                current.right = new Node(value);
                return;
            }else {
                queue.add(current.right);
            }
        }
    }
}

class BinaryTreeMain {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree(10);

        binaryTree.insert(20);
        binaryTree.insert(5);

        System.out.println(binaryTree.root.value);
        System.out.println(binaryTree.root.left.value);
        System.out.println(binaryTree.root.right.value);
    }
}
