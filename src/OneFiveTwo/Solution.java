package OneFiveTwo;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author CoderiGenius
 * @version 2021/3/29 1:29 下午
 */
class Solution {
    public int maxProduct(int[] nums) {



        List<Integer> list = new LinkedList<>();


        if(nums.length==0)return 0;

        int max = nums[0];


         list.add(nums[0] );


        for(int i=1;i<nums.length;i++){

            List<Integer> list2 = new LinkedList<>();
            list2.add(list.get(0)*nums[i]);
            list2.add(list.get(list.size()-1)*nums[i]);
            list2.add(nums[i] );
            Collections.sort(list2);
            list = list2;

            max = Math.max(list2.get(list2.size()-1),max);

            //System.out.println(max);
        }
        // if(max==Integer.MIN_VALUE){
        //     return dp[nums.length-1];
        // }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maxProduct(new int []{-2,3,-4}));
        System.out.println(new Solution().maxProduct(new int []{2,3,-2,4}));
        System.out.println(new Solution().maxProduct(new int []{-1,-2,-9,-6}));


    }
}