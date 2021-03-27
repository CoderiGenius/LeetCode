package OneThreeSix;

import java.util.HashMap;
import java.util.Map;

/**
 * @author CoderiGenius
 * @version 2021/3/25 7:03 下午
 */
public class Solution {
    public int singleNumber(int[] nums) {

        if(nums.length==0)return 0;
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i])){
                map.remove(nums[i]);
            }else {
                map.put(nums[i],1);
            }
        }
        for (Integer i :
                map.keySet()) {
            return i;
        }
        return 0;
    }
}
