package algorithm;

import java.util.Stack;

public class ReversePolish {
    // https://leetcode.com/problems/evaluate-reverse-polish-notation/
    // 利用栈先进后出的特性

    public static void main(String[] args){
        String[] array = new String[] {"4", "13", "5", "/", "+"};
        int result = evalRPN(array);
        System.out.println(result);
    }

    public static int evalRPN(String[] tokens) {
        if(tokens == null || tokens.length == 0){
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        for(String s : tokens){
            if(s.equals("+")){
                int b = stack.pop();
                int a = stack.pop();
                stack.push(a + b);
            }
            else if(s.equals("-")){
                int b = stack.pop();
                int a = stack.pop();
                stack.push(a - b);
            }
            else if(s.equals("*")){
                int b = stack.pop();
                int a = stack.pop();
                stack.push(a * b);
            }
            else if(s.equals("/")){
                int b = stack.pop();
                int a = stack.pop();
                stack.push(a / b);
            }
            else{
                stack.push(Integer.parseInt(s));
            }
        }
        return stack.pop();
    }
}
