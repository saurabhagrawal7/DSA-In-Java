// same code for lower bound

public class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        int start = 0, end = nums.length - 1, ans = nums.length, mid;

        while (start <= end) {
            mid = start + (end - start) / 2;

            if (nums[mid] >= target) {
                ans = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return ans;
    }
}
