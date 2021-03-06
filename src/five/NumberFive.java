package five;

import java.util.*;


/**
 * 中心扩散方法
 */
public class NumberFive {


    public String longestPalindrome(String s) {

        if(s.length()<1)return "";
        if(s.length()==1)return s;

        int left = 0;
        int right;
        int centerLength = 0;
        String longestString = "";
        int longestStringLength = 0;
        for (int i = 0; i < s.length(); i++) {
            centerLength = countRight(i,s);

            System.out.println(centerLength);
            left = i-1;
            right = i + centerLength + 1;
            System.out.println(left+"："+right+":"+checkLeftAndRight(left, right, i, s));
            if (!checkLeftAndRight(left, right, i, s) && centerLength==0) {
                continue;
            }


            while (checkLeftAndRight(left, right, i, s)) {
                left = left-1;
                right = right+1;
            }
            if(longestStringLength<(right-left)){
                longestStringLength = right - left;
                longestString = s.substring(left+1,right);
            }
            i = i+centerLength;
        }
        if("".equals(longestString)){
            return s.charAt(0)+"";
        }
        return longestString;

    }

    public boolean checkLeftAndRight(int left, int right, int self, String s) {
        if(left<0 || right>=s.length()){
            return false;
        }
        return s.charAt(left)==s.charAt(right);
    }



    public int countRight(int self, String s) {
        int i = 0;
        int right = self + 1;
        while (right<s.length() && s.charAt(self)==s.charAt(right)){
            i++;
            right++;
        }
        return i;
    }

//    public String longestPalindrome(String s) {
//
//        if(s==null || s.length()<=1){
//            return s;
//        }
//        String longest = "";
//        for (int i = 0; i <s.length() ; i++) {
//            String string = helper(i,s);
//            if(longest.length()<string.length()){
//                longest = string;
//            }
//        }
//
//        return longest;
//
//    }
//
//    private String helper(int index,String s){
//        int init = index;
//        int toRight = 0;
//        int toLeft = 0;
//        while((index+toRight)<s.length()-1 && s.charAt(index+toRight)==s.charAt(index+toRight+1)){
//            toRight++;
//        }
//        while ((index-toLeft)>0 && s.charAt(index-toLeft)==s.charAt(index-toLeft-1)){
//            toLeft++;
//        }
//
//        while((index+toRight)<s.length()-1 && (index-toLeft)>0){
//            if(s.charAt((index+toRight+1))==s.charAt(index-toLeft-1)){
//                toLeft++;
//                toRight++;
//            }else break;
//        }
//
//        return s.substring(init-toLeft,init+toRight+1);
//
//    }



    public static void main(String[] args) {
        NumberFive numberFive = new NumberFive();
        System.out.println(numberFive.longestPalindrome("cbbabd"));
    }
}
