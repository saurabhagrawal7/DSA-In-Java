public class SquareOfSortedArrays {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int left = 0, right = n - 1;
        int posIndex = n - 1;
        int[] res = new int[n];

        while (posIndex >= 0) {
            if (Math.abs(nums[left]) > Math.abs(nums[right])) {
                res[posIndex] = nums[left] * nums[left];
                left++;
            } else {
                res[posIndex] = nums[right] * nums[right];
                right--;
            }
            posIndex--;
        }

        return res;
    }
}
