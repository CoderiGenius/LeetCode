package SevenSix;

import java.util.*;

public class Solution {

    static int min = Integer.MAX_VALUE;
    static int left = 0;
   static int right = 0;

    public String minWindow(String s, String t) {

         min = Integer.MAX_VALUE;
          left = 0;
          right = 0;

        Map <Character,List<Integer>> map = new HashMap<>();

        for (int i = 0; i < t.length(); i++) {
            List<Integer> list = new LinkedList<>();
            
            map.put(t.charAt(i),list);
        }

        for (int i = 0; i < s.length(); i++) {
            List<Integer> list = map.get(s.charAt(i));
            if(list!=null){
                list.add(i);
            }
        }
        //System.out.println(map);

        for (Character c :
                map.keySet()) {
            helper(map,c);
        }
    //System.out.println(left+" "+right);
    return s.substring(left,right+1);}

//    private void helper2(Map<Character,List<Integer>> map,List<Integer> list,Character character){
//        List<Integer> l = map.get(character);
//        Collections.sort(list);
//        int small = list.get(0);
//        for (Integer i :
//                l) {
//            if(i)
//        }
//    }


    private void helper(Map<Character,List<Integer>> map,Character character){
        List<Integer> list = map.get(character);

        A:for (Integer i :
                list) {
            int temp = Integer.MAX_VALUE;
            for (Character c :
                    map.keySet()) {
                if(!c.equals(character)){
                    List<Integer> l = map.get(c);
                   // Collections.sort(l);
                    if(l.get(l.size()-1)<i)continue A;
                    for (Integer integer :
                            l) {

                        if(integer>i){
                            if(temp==Integer.MAX_VALUE ||temp<integer)
                            temp=integer;

                            break;
                        }
                    }
                }
            }
            //System.out.println(i+":"+temp);
            if(min>(temp-i)){
                min = temp-i;
                left = i;
                right = temp;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().minWindow("A","A"));
    }

}
