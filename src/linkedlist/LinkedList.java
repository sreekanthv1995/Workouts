package linkedlist;

import java.util.HashSet;
import java.util.Set;

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

    public Node removeFirst(){
        if (length == 0) return null;
        Node temp = head;
        head = head.next;
        temp.next = null;
        length--;
        if (length == 0)
            tail = null;
        return temp;
    }
    public Node removeLast(){
        Node temp = head;
        Node prev = head;

        while (temp.next != null){
            prev = temp;
            temp = temp.next;
        }
        tail = prev;
        tail.next = null;
        length--;
        if (length == 0){
            head = null;
            tail = null;
        }
        return temp;
    }

    public Node get(int index){
        if (index < 0 && index >= length) return null;
        Node temp = head;
        for (int i = 0; i < index; i++){
            temp = temp.next;
        }
        return temp;
    }

    public boolean set(int index,int value){
        Node temp = get(index);
        if (temp != null){
            temp.value = value;
            return true;
        }
        return false;
    }

    public void insert(int index, int value){
        if (index < 0 || index > length) return;
        if (index == 0){
            addFirst(value);
            return;
        }
        if (index == length){
            addLast(value);
            return;
        }

        Node temp = get(index -1);
        Node newNode = new Node(value);
        newNode.next = temp.next;
        temp.next = newNode;
        length++;
    }

    public Node remove(int index){
        if (index < 0 || index >= length) return null;
        if (index == 0) return removeFirst();
        if (index == length-1) return removeFirst();

        Node prev = get(index-1);
        Node temp = prev.next;
        prev.next = temp.next;
        temp.next = null;
        length--;
        return temp;
    }

    public Node findMiddle(){
        Node fast = head;
        Node slow = head;

        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    public void reverse(){
        Node temp = head;
        head = tail;
        tail = temp;

        Node after;
        Node before = null;

        for (int i = 0; i < length; i++){
            after = temp.next;
            temp.next = before;
            before = temp;
            temp = after;
        }
    }
    public void reverseBetween(int begin, int end) {

        Node prev = null;
        Node curr = head;
        for (int i = 0; i < begin; i++) {
            prev = curr;
            curr = curr.next;
        }
        Node beforeBegin = prev;
        Node beginNode = curr;
        Node after = null;
        Node prevNode = null;
        for (int i = begin; i <= end; i++) {
            after = curr.next;
            curr.next = prevNode;
            prevNode = curr;
            curr = after;
        }
        if (beforeBegin != null) {
            beforeBegin.next = prevNode;
        } else {
            head = prevNode;
        }
        beginNode.next = curr;
        if (curr == null) {
            tail = beginNode;
        }
    }

    public boolean hasLoop(){
        Node fast = head;
        Node slow = head;

        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast){
                return true;
            }
        }
        return false;
    }

    public void removeDuplicate(){
        Set<Integer>set=new HashSet<>();
        Node current = head;
        Node prev = null;

        while (current != null){
            if (set.contains(current.value)){
                prev.next = current.next;
            }else {
                set.add(current.value);
                prev = current;
            }
            current = current.next;
        }
        System.out.println(set);
    }
}

class Main {
    public static void main(String[] args) {

        LinkedList list = new LinkedList(10);
        list.addLast(20);
        list.addLast(30);
        list.addLast(60);
        list.addLast(50);
        list.addLast(60);
        list.addLast(60);
        list.addLast(70);
        list.addLast(10);
        list.addLast(80);
        list.addLast(20);
        list.addLast(20);
        list.print();
        System.out.println();
        System.out.println(list.hasLoop());
        list.removeDuplicate();
        list.print();

    }
}
