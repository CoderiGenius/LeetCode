package ThreeTwo;

import java.util.Stack;

public class Solution {

    static int max = 0;

    public int longestValidParentheses(String s) {

        max = 0;

        if(s==null || s.length()==0){
            return 0;
        }

//        for (int i = 0; i < s.length(); i++) {
//            helper(i,s);
//        }
        helper(0,s);

//        for (int i = s.length()-1; i >=0 ; i--) {
//            helper2(i,s);
//
//        }
        helper2(s.length()-1,s);

        return max;
    }

    private void helper(int start,String s){
        int length = 0;
        Stack<Character> stack = new Stack<>();

        Stack<Integer> integers = new Stack<>();

        for (int i = start; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c=='('){

               stack.push(c);
            }else {
                if(stack.isEmpty()){
                    length = 0;
                    integers.clear();
                }else {
                    stack.pop();
                    integers.push(2);
                }
            }
            if(stack.isEmpty()){
                while (!integers.isEmpty()){
                    length+=integers.pop();
                }
                max = Math.max(max,length);


            }
        }
//        while (!stack.isEmpty() && !integers.isEmpty()) {
//            integers.pop();
//            stack.pop();
//        }
//        while (!integers.isEmpty()){
//            length = length+integers.pop();
//        }

    }


    private void helper2(int i,String s){
        int length = 0;
        Stack<Character> stack = new Stack<>();
        Stack<Integer> integers = new Stack<>();

        for (; i >=0; i--) {
            char c = s.charAt(i);
            if(c==')'){

                stack.push(c);
            }else {
                if(stack.isEmpty()){
                    length = 0;
                    integers.clear();
                }else {
                    stack.pop();
                    integers.push(2);
                }
            }
            if(stack.isEmpty()){
                while (!integers.isEmpty()){
                    length+=integers.pop();
                }
                max = Math.max(max,length);


            }
        }
//        while (!stack.isEmpty() && !integers.isEmpty()) {
//            integers.pop();
//            stack.pop();
//        }
//        while (!integers.isEmpty()){
//            length = length+integers.pop();
//        }

    }

    public static void main(String[] args) {
     System.out.println(new Solution().longestValidParentheses(")()())"));
        System.out.println(new Solution().longestValidParentheses("()()())"));


    }
}
