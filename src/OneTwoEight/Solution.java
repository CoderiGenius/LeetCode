package OneTwoEight;

import TransferWise.Main;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * @author CoderiGenius
 * @version 2021/3/25 6:29 下午
 */
public class Solution {
    public int longestConsecutive(int[] nums) {

        int max = 0;
        if(nums.length==0){
            return max;
        }

        Set<Integer> set = new HashSet<>();

        for (int i :
                nums) {
            set.add(i);
        }
        Integer[] newNums = set.toArray(new Integer[]{0});
        Arrays.sort(newNums);
        int lastOne = newNums[0];
        int currentLongest = 1;
        for (int i = 1; i < newNums.length; i++) {
            if(newNums[i]-1==lastOne){
                currentLongest++;
            }
            else {
                max = Math.max(max,currentLongest);
                currentLongest=1;
            }
            lastOne = newNums[i];

        }
        max = Math.max(max,currentLongest);

        return max;

    }

    public static void main(String[] args) {
        //System.out.println(new Solution().longestConsecutive(new int[]{4,0,-4,-2,2,5,2,0,-8,-8,-8,-8,-1,7,4,5,5,-4,6,6,-3}));
        System.out.println(new Solution().longestConsecutive(new int[]{100,200,1,2,3,4}));

    }
}
