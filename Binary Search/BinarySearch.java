public class BinarySearch {
    public int search(int[] nums, int target) {
        int start = 0, end = nums.length - 1, mid;

        while (start <= end) {
            mid = start + (end - start) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return -1;
    }
}

// max value of int in java is 2 ^ 31 - 1
// if we do start + end / 2, it can overflow because if start is 2 ^ 31 - 1 and
// end is 2 ^ 31 - 1,
// then start + end = 2 ^ 32 - 2 which exceeds the max value of int

// 32/2^0 = 32 -> 1 step
// 32/2^1 = 16 -> 1 step
// 32/2^2 = 8 -> 1 step
// 32/2^3 = 4 -> 1 step
// 32/2^4 = 2 -> 1 step
// 32/2^5 = 1 -> 1 step

// In total, we took 6 steps to find the target

// Imagine if array size is 32, then TC is O(log base 2(n)) 
// i.e. log base 2(2^5)
// 5 x log base 2(2) => powe comes ahead 
// 5 x 1 => 5
// So, TC is O(log n)