public class TrappingRainWater {
    public int trap(int[] height) {
        int n = height.length;
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];
        leftMax[0] = 0; // for 0th index element there will be no max hence 0
        rightMax[n - 1] = 0;
        for (int i = 1; i < n; i++)
            leftMax[i] = Math.max(leftMax[i - 1], height[i - 1]);
        for (int i = n - 2; i >= 0; i--)
            rightMax[i] = Math.max(rightMax[i + 1], height[i + 1]);

        int water = 0;
        for (int i = 0; i < n; i++) {
            int minHeight = Math.min(leftMax[i], rightMax[i]);
            if (minHeight - height[i] >= 0)
                water += minHeight - height[i];
        }
        return water;
    }

    public int trapSpaceOptimized(int[] height) {
        // space optimized approach
        int n = height.length;
        // step 1: find building with largest height such that rightMax part wil be
        // sorted
        int rightMax = 0;
        int rightMaxIndex = 0;
        for (int i = 0; i < n; i++) {
            if (height[i] > rightMax) {
                rightMax = height[i];
                rightMaxIndex = i;
            }
        }
        int water = 0;
        int leftMax = 0;
        for (int i = 1; i < rightMaxIndex; i++) {
            leftMax = Math.max(leftMax, height[i - 1]);
            int minHeight = Math.min(leftMax, rightMax);
            if (minHeight - height[i] >= 0)
                water += minHeight - height[i];
        }
        leftMax = rightMax;
        rightMax = 0;
        for (int i = n - 2; i >= rightMaxIndex + 1; i--) {
            rightMax = Math.max(rightMax, height[i + 1]);
            int minHeight = Math.min(leftMax, rightMax);
            if (minHeight - height[i] >= 0)
                water += minHeight - height[i];
        }
        return water;
    }

    // most optimized approach - 2 pointers
    public int trap2Ptrs(int[] height) {
        int n = height.length;
        int ans = 0;
        int l = 0, r = n - 1;
        int lmax = 0, rmax = 0;

        while (l < r) {
            lmax = Math.max(lmax, height[l]);
            rmax = Math.max(rmax, height[r]);

            if (lmax < rmax) {
                ans += lmax - height[l];
                l++;
            } else {
                ans += rmax - height[r];
                r--;
            }
        }

        return ans;
    }
}
