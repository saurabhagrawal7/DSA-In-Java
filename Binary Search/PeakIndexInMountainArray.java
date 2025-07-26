public class PeakIndexInMountainArray {
    // assume -infinity is at the start and end of the array if the peak is at the start or end
    public int peakIndexInMountainArray(int[] nums) {
        int start = 1, end = nums.length - 2, mid, n = nums.length;
        if (nums[0] > nums[1])
            return 0;
        if (nums[n - 1] > nums[n - 2])
            return n - 1;

        while (start <= end) {
            mid = end + (start - end) / 2;

            // Peak element
            if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {
                return mid;
            }
            // Right side move
            else if (nums[mid] > nums[mid - 1]) {
                start = mid + 1;
            }
            // Left side move
            else {
                end = mid - 1;
            }
        }

        return -1;
    }
}
