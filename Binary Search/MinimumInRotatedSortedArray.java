public class MinimumInRotatedSortedArray {
    // sorted half may or may not have the answer, hence pick the minimum from sorted half and eliminate it
    public int findMin(int[] nums) {
        int start = 0, end = nums.length - 1, ans = Integer.MAX_VALUE, mid;

        while (start <= end) {
            mid = start + (end - start) / 2;

            if (nums[mid] >= nums[start]) {
                ans = Math.min(ans, nums[start]);
                start = mid + 1;
            } else {
                ans = Math.min(ans, nums[mid]);
                end = mid - 1;
            }
        }

        return ans;
    }
}
