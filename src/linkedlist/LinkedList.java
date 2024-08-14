package linkedlist;

public class LinkedList {

    Node head;
    Node tail;
    int length;

    static class Node {
        int value;
        Node next;

        Node(int value){
            this.value = value;
        }
    }
    public LinkedList(int value){
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        length=1;
    }

    public void print(){
        Node temp = head;
        while (temp != null){
            System.out.print(temp.value+" ->");
            temp = temp.next;
        }
    }
    public void addFirst(int value){
        Node newNode = new Node(value);
        if (length == 0){
            head = newNode;
            tail = newNode;
        }else {
            newNode.next = head;
            head = newNode;
        }
        length++;
    }

    public void addLast(int value){
        Node newNode = new Node(value);
        if (length == 0){
            head = newNode;
            tail = newNode;
        }else {
            tail.next = newNode;
            tail = newNode;
        }
        length++;
    }
}

class Main {
    public static void main(String[] args) {

        LinkedList list = new LinkedList(10);
        list.addFirst(20);
        list.addFirst(30);
        list.addLast(40);
        list.addFirst(5);

        list.print();
        System.out.println();
        System.out.println(list.head.value);
        System.out.println(list.tail.value);
    }
}
