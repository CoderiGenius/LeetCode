//package FiveThreeTwo;
//
//import java.util.*;
//
//class Solution {
//    public int findPairs(int[] nums, int k) {
//
//        if(nums.length==0 || nums.length==1){
//            return 0;
//        }
//       // List<List<Integer>> list = new ArrayList<>();
////        HashSet<Integer> set = new HashSet<Integer>();
////        for(int i=0;i<nums.length;i++){
////            set.add(nums[i]);
////        }
////       Integer[] nums = set.stream().toArray(Integer[]::new);
//        int returnInt = 0;
//        Map<Integer,Integer> map = new HashMap<>();
//
//        for(int i=0;i<nums.length;i++){
//            if(map.get(nums[i])!=null){
//
//                map.put(nums[i],map.get(nums[i])+1);
//            }else{
//                map.put(nums[i],1);
//            }
//        }
//
//        if(k!=0){
//            for (Integer i:map.keySet()
//                 ) {
//                if(map.get(k+nums[i])!=null){
//                    System.out.println("k:"+k+" i:"+nums[i]+" map:"+map.get(k+nums[i]));
//                    returnInt++;
//                }
//            }
//
//
//        }else{
//            for (Integer i:map.keySet()
//            ) {
//                if(map.get(k+nums[i])!=null && map.get(k+nums[i])>1){
//                    System.out.println("k:"+k+" i:"+nums[i]+" map:"+map.get(k+nums[i]));
//                    returnInt++;
//                }
//            }
//        }
//        return returnInt;
//    }
//
//    public static void main(String[] args) {
//        int[] nums = new int[]{6,2,9,3,9,6,7,7,6,4};
//        Solution solution = new Solution();
//        System.out.println(solution.findPairs(nums,3));
//
//
//        List<List<Integer>> list = new ArrayList();
//        if(nums.length<=2){
//            return list;
//        }
//       Map<Integer,Integer> map = new HashMap<>();
//
//        for (int num : nums) {
//            if (map.get(num) != null) {
//                Integer integer = map.get(num) + 1;
//                map.put(num, integer);
//            } else {
//                map.put(num, 1);
//            }
//        }
//
//        for (Integer i :
//                map.keySet()) {
//            if(map.get(i)>1 && map.get(-i - i)!=null){
//                List<Integer> l = new ArrayList<>();
//                l.add(i);
//                l.add(i);
//                l.add(-i-i);
//                list.add(l);
//            }else{
//               if( map.get(i)==1 && map.get(-i)!=null && map.get(0)!=null){
//                   List<Integer> l = new ArrayList<>();
//                   l.add(i);
//                   l.add(i);
//                   l.add(-i-i);
//                   list.add(l);
//               }
//            }
//        }
//
//        return list;
//
//
//    }
//}
