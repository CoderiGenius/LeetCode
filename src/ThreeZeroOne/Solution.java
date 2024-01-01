package ThreeZeroOne;

import java.util.*;

/**
 * @author CoderiGenius
 * @version 2021/4/7 5:50 下午
 */
public class Solution {
    int left = 0;
    int right = 0;
    public List<String> removeInvalidParentheses(String s) {

        left=0;
        right=0;
        Set<String> list = new HashSet<>();
        if(s.length()==0)return new ArrayList<>(list);
        helper2(s);
        helper(s,0,list,0,new StringBuilder());
        //System.out.println(list);
        helper3(list);
        if(list.size()>1){
           Iterator<String> iterator = list.iterator();
           while (iterator.hasNext()){
               String i = iterator.next();
               if(i.contains("(") || i.contains(")")){

               }else {
                   iterator.remove();
               }
           }
        }
        return new ArrayList<>(list);
    }

    private void helper2(String s){
        String[] strings = s.split("");
        for (String s2 :
                strings) {
            if(")".equals(s2)){
                right++;
            }else if("(".equals(s2)){
                left++;
            }
        }
    }

    private void helper(String s,int current,Set<String> list,int currentNum,StringBuilder stringBuilder){
        if(s.length()==current){
            //if(stringBuilder.toString().length()==s.length())return;
            list.add(stringBuilder.toString());
            return;
        }

        if(left<right){
            //右括号可以有不要的情况
            if(s.charAt(current)=='('){
                //左括号必须要
                left--;
                helper(s,current+1,list,currentNum+1,stringBuilder.append(s.charAt(current)));
                if(stringBuilder.length()>0)stringBuilder.delete(stringBuilder.length()-1,stringBuilder.length());

            }else if(s.charAt(current)==')'){
                //右括号可以有不要的情况
                //要
                right--;
                if(currentNum>0)
                helper(s,current+1,list,currentNum-1,stringBuilder.append(s.charAt(current)));
                //System.out.println(stringBuilder.toString());
                currentNum++;
                if(stringBuilder.length()>0)stringBuilder.delete(stringBuilder.length()-1,stringBuilder.length());
                //System.out.println(stringBuilder.toString());
                //不要
                helper(s,current+1,list,currentNum,stringBuilder);
               // if(stringBuilder.length()>0)stringBuilder.delete(stringBuilder.length()-1,stringBuilder.length());


            }else {
                //其他字符
                helper(s,current+1,list,currentNum,stringBuilder.append(s.charAt(current)));
                if(stringBuilder.length()>0)stringBuilder.delete(stringBuilder.length()-1,stringBuilder.length());

            }

        }else if(left>right){
            //左括号可以有不要的情况
            if(s.charAt(current)==')'){
                //you括号必须要
                right--;
                if(currentNum>0) {
                    helper(s, current + 1, list, currentNum - 1, stringBuilder.append(s.charAt(current)));
                    if (stringBuilder.length() > 0)
                        stringBuilder.delete(stringBuilder.length() - 1, stringBuilder.length());
                }
            }else if(s.charAt(current)=='('){
                //右括号可以有不要的情况
                //要
                left--;
                helper(s,current+1,list,currentNum+1,stringBuilder.append(s.charAt(current)));
                currentNum--;
                //System.out.println(stringBuilder.toString());
                if(stringBuilder.length()>0)stringBuilder.delete(stringBuilder.length()-1,stringBuilder.length());
                //System.out.println(stringBuilder.toString());

                //不要
                helper(s,current+1,list,currentNum,stringBuilder);
                //if(stringBuilder.length()>0)stringBuilder.delete(stringBuilder.length()-1,stringBuilder.length());


            }else {
                //其他字符
                helper(s,current+1,list,currentNum,stringBuilder.append(s.charAt(current)));
                if(stringBuilder.length()>0)stringBuilder.delete(stringBuilder.length()-1,stringBuilder.length());

            }
        }else {
            //左右都必须要

                if(s.charAt(current)=='(') {
                    helper(s, current + 1, list, currentNum + 1, stringBuilder.append(s.charAt(current)));
                    currentNum--;
                }
                if(s.charAt(current)==')' && currentNum>0){
                    helper(s, current + 1, list,currentNum-1, stringBuilder.append(s.charAt(current)));
                    currentNum++;
                }
                if(s.charAt(current)!='(' && s.charAt(current)!=')') {
                    helper(s, current + 1, list,currentNum, stringBuilder.append(s.charAt(current)));
                }else {
                    helper(s, current + 1, list,currentNum, stringBuilder);

                }
                if (stringBuilder.length() > 0)
                    stringBuilder.delete(stringBuilder.length() - 1, stringBuilder.length());


        }
    }

    private void helper3(Set<String> set){
        Iterator<String> iterator = set.iterator();
        Set<String> newSet = new HashSet<>();
        while (iterator.hasNext()){
            String s = iterator.next();
            if(! check(s)){
                iterator.remove();
                newSet.add(s.replaceAll("\\)","").replaceAll("\\(",""));
            }
        }
        set.addAll(newSet);

    }
    private boolean check(String s){
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)=='('){
                stack.add('(');
            }else if(s.charAt(i)==')'){
                if(!stack.isEmpty() && stack.peek()=='(')stack.pop();
                else return false;
            }else {

            }
        }
        return stack.isEmpty();

    }

    public static void main(String[] args) {
//        System.out.println(new SolutionOld().removeInvalidParentheses("()())()"));
//        System.out.println(new SolutionOld().removeInvalidParentheses(")(f"));
        System.out.println(new Solution().removeInvalidParentheses(")()("));

        System.out.println(new Solution().removeInvalidParentheses("(a)())()"));

    }
}
