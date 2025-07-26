public class HouseRobber {
    private int helper(int ind, int[] nums) {

        if (ind >= nums.length)
            return 0;

        // rob the house at ind
        int rob = nums[ind] + helper(ind + 2, nums);

        // dont rob the house
        int dontrob = helper(ind + 1, nums);

        return Math.max(rob, dontrob);
    }

    public int rob(int[] nums) {
        return helper(0, nums);
    }
}
