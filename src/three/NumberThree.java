package three;

import java.util.*;


/**
 * 滑动窗口来解决
 */

public class NumberThree {



    public int lengthOfLongestSubstring(String s) {

        Set<Character>  set = new HashSet<>();
        int bigest = 0;

       int i=0,j=0;
        while (i < s.length() && j < s.length()) {
            if(set.contains(s.charAt(j))){
                //System.out.println(strings[i]);
               set.remove(s.charAt(i));
               i++;
            }else {
                set.add(s.charAt(j));
                j++;
                //System.out.println(bigest);
                bigest = Math.max(bigest,j-i);
            }
        }
        return bigest;

    }

//    int helper(Map<String,String> map,List<String> list,String s,int returnInt){
//
//        map.clear();
//        list.clear();
//
//        String[] strings = s.split("");
//        System.out.println("size:"+strings.length);
//        int i;
//        for (i = 0; i < strings.length; i++) {
//
//            //System.out.println(strings.length);
//
//            if (map.get(strings[i]) != null) {
//                break;
//            }else {
//                if( ! "".equals(strings[i])) {
//                    list.add(strings[i]);
//                    map.put(strings[i], strings[i]);
//                }
//            }
//        }
//
//        if (i != strings.length) {
//            System.out.println(i);
//            System.out.println(list.size());
//            if(returnInt<list.size()){
//                returnInt = list.size();
//            }
//           return helper(map, list, s.substring(1), returnInt);
//        }else{
//            if(returnInt<list.size()){
//                returnInt = list.size();
//            }
//            return returnInt;
//
//        }
//
//    }


    public static void main(String[] args) {

        NumberThree numberThree = new NumberThree();
        System.out.println(numberThree.lengthOfLongestSubstring("abcabcbb"));
    }

}


