package stack;

import java.util.Stack;

public class StackProblems {

    public static void main(String[] args) {

        System.out.println(validateParenthesis("{)}"));
    }

    public static boolean validateParenthesis(String parenthesis){

        Stack<Character> stack = new Stack<>();

        for (char p: parenthesis.toCharArray()){
            if (p == '{' || p == '(' || p == '['){
                stack.push(p);
            }else{
                if (p =='}'){
                    if(stack.isEmpty() || stack.pop() != '{'){
                        return false;
                    }
                }
                if (p == ')'){
                    if (stack.isEmpty() || stack.pop() != '('){
                        return false;
                    }
                }
                if (p == ']'){
                    if (stack.isEmpty() || stack.pop() != '['){
                        return false;
                    }
                }
            }
        }
        return stack.isEmpty();
    }
}
