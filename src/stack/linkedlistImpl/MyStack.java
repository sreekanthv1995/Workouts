package stack.linkedlistImpl;

public class MyStack {
    int height;
    Node top;
    static class Node {
        Node next;
        int value;

        Node(int value){
            this.value = value;
        }
    }
    public MyStack(int value){
        top = new Node(value);
        height = 1;
    }

    public void print(){
        Node temp = top;
        while (temp != null){
            System.out.print(temp.value+ " <-");
            temp = temp.next;
        }
    }

    public void push(int value){
        Node newNode = new Node(value);
        if (top == null){
            top = newNode;
        }else {
            newNode.next = top;
            top = newNode;
        }
        height++;
    }

    public Node pop(){
        if (height == 0) return null;
        Node temp = top;
        top = top.next;
        temp.next = null;
        height--;
        return temp;
    }
}

class Main {
    public static void main(String[] args) {

        MyStack myStack = new MyStack(10);
        myStack.push(20);
        myStack.push(30);

        myStack.print();
        System.out.println();
        System.out.println(myStack.pop().value);
    }
}
