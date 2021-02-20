package eleven;

class Solution {
    int[][] f;
    public int maxArea(int[] height) {
        // f = new int[height.length][height.length];
        return find(0, height.length-1, height);
    }

    int find(int l, int r, int[] height) {
        if (l >= r) return 0;
        // if (f[l][r] > 0) return f[l][r];
        int minHeight = Math.min(height[l], height[r]);
        int current = minHeight * (r - l);

        int a = 0;
        if (height[l]<height[r]) a = find(l + 1, r, height);
        int b = 0;
        if (height[l]>=height[r]) b = find(l, r - 1, height);
        int max = Math.max(current, a);
        max = Math.max(max, b);
        // f[l][r] = max;
        return max;
    }
}
