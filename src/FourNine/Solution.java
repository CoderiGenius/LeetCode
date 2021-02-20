package FourNine;

import java.util.*;

public class Solution {

    public List<List<String>> groupAnagrams(String[] strs) {

        List<List<String>> list = new LinkedList<>();

        if(strs==null || strs.length==0){
            return list;
        }
        Map<String,List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            String returnString = helper(strs[i]);
            List<String> strings = map.get(returnString);
            if(strings==null){
                strings = new LinkedList<>();
                strings.add(strs[i]);
                map.put(returnString,strings);
            }else {
                strings.add(strs[i]);
            }
        }

        list.addAll(map.values());
        return list;
    }

    private String helper(String s){
        PriorityQueue<Character> priorityQueue = new PriorityQueue<>();



        for (int i = 0; i < s.length(); i++) {
            priorityQueue.add(s.charAt(i));
        }
        StringBuilder stringBuilder = new StringBuilder();
        while (!priorityQueue.isEmpty()) {
            stringBuilder.append(priorityQueue.poll());
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().helper("zzaa"));
    }
}
