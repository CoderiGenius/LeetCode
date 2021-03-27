package OneThreeNine;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author CoderiGenius
 * @version 2021/3/25 7:24 下午
 */
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {

        if(wordDict.isEmpty())return false;

        Map<String,Boolean> map = new HashMap<>();
        for (String string :
                wordDict) {
            map.put(string,true);
        }
        boolean[] dp = new boolean[s.length()];
        dp[0] = true;
        for (int i = 1; i < s.length(); i++) {
            for (int j = i-1; j >=0 ; j--) {
            dp[i] = dp[j] && check(s.substring(j,i),map);
            if(dp[i])break;
            }
        }
    return dp[s.length()-1];
    }

   private  boolean check(String s, Map<String,Boolean> map){
        return map.getOrDefault(s,false);
   }

    public static void main(String[] args) {
        List<String> list = new LinkedList<>();
        list.add("car");
        list.add("ca");
        list.add("rs");
        System.out.println(new Solution().wordBreak("cars",list));
    }
}
