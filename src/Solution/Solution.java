package Solution;

import java.util.*;

public class Solution {

    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> list = new LinkedList<>();
        if(nums==null ||nums.length<3){
            return list;
        }

        Arrays.sort(nums);

       
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i <nums.length-1; i++) {
            while(i>0 && nums[i-1]==nums[i]){
                i++;
            }
            int left = i+1;
            int right = nums.length-1;
            while(left<right){
                int sum = nums[i] + nums[left] +  nums[right];
                if(sum>0){
                    while (right>0){
                        if(nums[right]!=nums[right-1]){
                            right--;
                            break;
                        }else right--;
                    }
                }
                if(sum<0){
                    while (left<nums.length-1){
                        if(nums[left]!=nums[left+1]){
                            left++;
                            break;
                        }else left++;
                    }
                }
                if(sum==0){

                    List<Integer> list1 = new LinkedList<>();
                    list1.add(nums[left] );
                    list1.add(nums[i]);
                    list1.add(nums[right]);
                    list.add(list1);
                    while (left<right){
                        if(nums[left]!=nums[left+1]){
                            left++;
                            break;
                        }else left++;
                    }
                    while (right>left){
                        if(nums[right]!=nums[right-1]){
                            right--;
                            break;
                        }else right--;
                    }

                }

            }
        }

        return list;
    }

    public void helper(List<List<Integer>> list,Map<Integer,Integer> map,int left,int right,int[] nums){

        if(left>=right)return;


            if(nums[left]>0)return;

            int need = -(nums[left] + nums[right]);


            Integer integer = map.get(need);
            if(integer!=null){
                if(need==nums[left])integer--;
                if(need==nums[right])integer--;
                if(integer>0){
                    List<Integer> list1 = new LinkedList<>();
                    list1.add(nums[left]);
                    list1.add(need);
                    list1.add(nums[right]);

                    list.add(list1);
                }
            }


            if((-need)>0){
                while(right>0){
                    if(nums[right-1]!=nums[right]){
                        right--;
                        helper(list,map,left,right,nums);
                        //break;
                    }else {
                        right--;
                    }
                }
            }
            if((-need)<0){
                while(left<nums.length-1){
                    if(nums[left+1]!=nums[left]){
                        left++;
                       // break;
                        helper(list,map,left,right,nums);

                    }else {
                        left++;
                    }
                }
            }

            if((-need)==0){

                while(right>0){
                    if(nums[right-1]!=nums[right]){
                        right--;
                        helper(list,map,left,right,nums);
                        break;
                    }else {
                        right--;
                    }
                }

                while(left<nums.length-1){
                    if(nums[left+1]!=nums[left]){
                        left++;
                        helper(list,map,left,right,nums);
                        break;

                    }else {
                        left++;
                    }
                }
            }



    }



    public static void main(String[] args) {
        System.out.println(new Solution().threeSum(new int[]{-1,0,1,2,-1,-4}));
       // System.out.println(new SolutionOld().threeSum(new int[]{-2,0,1,1,2}));


    }
}
