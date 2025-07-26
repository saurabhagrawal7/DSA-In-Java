public class HouseRobber2 {
    private int helper(int ind, int[] nums, int n) {
        if (ind >= n)
            return 0;

        // rob the house at ind
        int rob = nums[ind] + helper(ind + 2, nums, n);

        // dont rob the house
        int dontrob = helper(ind + 1, nums, n);

        return Math.max(rob, dontrob);
    }

    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1)
            return nums[0];
        return Math.max(helper(0, nums, n - 1), helper(1, nums, n));
    }
}
