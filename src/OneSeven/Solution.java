package OneSeven;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    public List<String> letterCombinations(String digits) {

        String[] letterMap = {
                " ",    //0
                "",     //1
                "abc",  //2
                "def",  //3
                "ghi",  //4
                "jkl",  //5
                "mno",  //6
                "pqrs", //7
                "tuv",  //8
                "wxyz"  //9
        };
        List<String> list = new ArrayList<>();

        helper(list,letterMap,digits,new StringBuilder(),0);
        return list;

    }

    private void helper(List<String> list,String[] letterMap,String left,StringBuilder current,Integer index){

        if(left==null ||"".equals(left)||index>=left.length()){
            return;
        }
        String button = left.charAt(index)+"";
        String buttonString = letterMap[Integer.parseInt(button)];
        String[] letter = buttonString.split("");
        for (String s :
                letter) {
            StringBuilder all = current.append(s);
           if(left.length()==(index+1)){

               list.add(all.toString());
           }
            helper(list,letterMap,left,all,index+1);
           current.deleteCharAt(current.length()-1);
        }

    }

    public static void main(String[] args) {
        System.out.println(new Solution().letterCombinations("23"));
    }
}
