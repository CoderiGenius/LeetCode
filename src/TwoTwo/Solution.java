package TwoTwo;

import java.util.*;

public class Solution {

    public List<String> generateParenthesis(int n) {
        
        List<String> list = new LinkedList<>();
        if(n==0){
            return list;
        }
       helper(list,"",n,n);
        return list;

    }

    private void helper(List<String> list, String s, int left, int right){

      if(left<=0 && right<=0){
          list.add(s);
      }

      if(left>right)return;



      if(left>0)helper(list,s+"(",left-1,right);
        if(right>0)helper(list,s+")",left,right-1);


    }

    public static void main(String[] args) {
        System.out.println(new Solution().generateParenthesis(3));
    }
}
