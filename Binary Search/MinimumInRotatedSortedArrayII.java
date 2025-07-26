public class MinimumInRotatedSortedArrayII {
    public int findMin(int[] nums) {
        int start = 0, end = nums.length - 1, ans = Integer.MAX_VALUE, mid;

        while (start <= end) {
            mid = start + (end - start) / 2;

            if (nums[start] == nums[mid] && nums[mid] == nums[end]) {
                ans = Math.min(ans, nums[start]);
                start++;
                end--;
                continue;
            }

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
