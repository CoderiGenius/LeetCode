package FourOneSix;

/**
 * @author CoderiGenius
 * @version 2023/12/27 01:18
 */
class Solution {
    public boolean canPartition(int[] nums) {
        if (nums.length <= 1)
            return false;
        int total = 0;
        int target = -1;
        for (int i = 0; i < nums.length; i++) {
            total += nums[i];
        }
        if (total % 2 != 0)
            return false;
        else {
            target = total / 2;
        }
        int[] dp = new int[target + 1];
        // 定义状态转移方程， list代表当前
        for (int i = 0; i < nums.length; i++) {
            for (int j = target; j >= 1; j--) {

                int before = j-nums[i];

                // 如果当前数字可以直接满足j，或者之前dp本身就是true
                if (nums[i] == j) {
                    dp[j] = 1;
                } else if (dp[j] == 1) {
                    dp[j] = 1;
                }
                // 如果当前数字无法满足，但是期待数字减去当前数字的结果可以由前面的状态补充
                else if (before>=1 && dp[before]==1) {
                    dp[j] = 1;
                } else {
                    dp[j] = 0;
                }
                for (int k = 0; k <= target; k++) {
                    System.out.print( dp[k]+",");
                }
                System.out.println("");
                System.out.println("----");

            }
        }

        return dp[target] == 1;

    }

    public static void main(String[] args) {
        int[] nums = new int[4];
//        nums[0] = 1;
//        nums[1] = 5;
//        nums[2] = 11;
//        nums[3] = 5;

        nums[0] = 2;
        nums[1] = 2;
        nums[2] = 3;
        nums[3] = 5;

        Solution solution = new Solution();
        System.out.println(solution.canPartition(nums));
    }
}