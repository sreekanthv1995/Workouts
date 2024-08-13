package stack.arrayImp;

import java.util.Arrays;

public class MyStack {

    int[] stack = new int[10];
    int top;

    MyStack(){
        this.top = -1;
    }

    public void push(int data){
        if (top == stack.length-1){
            System.out.println("Stack is full");
        }else {
            stack[++top] = data;
        }
    }

    public int pop(){
        if (top >= 0){
            return stack[top--];
        }else {
            System.out.println("Stack is Empty");
            return -1;
        }
    }
}
class Main {
    public static void main(String[] args) {
        MyStack myStack = new MyStack();


        System.out.println(Arrays.toString(myStack.stack));
        myStack.push(40);
        myStack.push(50);
        myStack.push(60);
        myStack.push(70);
        myStack.push(80);
        myStack.push(90);
        myStack.push(100);
        myStack.push(110);
        myStack.push(120);
        myStack.push(130);
        System.out.println(myStack.pop());
        System.out.println(Arrays.toString(myStack.stack));
    }
}
