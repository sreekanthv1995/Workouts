package tree;

public class BST {

    Node root;
    static class Node {
        int value;
        Node left;
        Node right;

        Node(int value){
            this.value = value;
        }
    }
    public BST(int value){
      root = new Node(value);
    }

    public void insert(int value){
        recursiveInsert(root,value);
    }

    public Node recursiveInsert(Node root,int value){
        if (root == null){
            root = new Node(value);
            return root;
        }
        if (value > root.value){
            root.right = recursiveInsert(root.right,value);
        }else {
            root.left = recursiveInsert(root.left,value);
        }
        return root;
    }


}

class Main {
    public static void main(String[] args) {
        BST bst = new BST(10);
        bst.insert(5);
        bst.insert(20);
        System.out.println(bst.root.value);
        System.out.println(bst.root.left.value);
        System.out.println(bst.root.right.value);
    }
}