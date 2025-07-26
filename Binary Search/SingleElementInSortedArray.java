// (even, odd) -> left half & element is on right half
// (odd, even) -> right half & element is on left half

public class SingleElementInSortedArray {
    public int singleNonDuplicate(int[] nums) {
        int n = nums.length;

        // try to eliminate conditional cases
        if(nums.length == 1) return nums[0];
        if(nums[0] != nums[1]) return nums[0];
        if(nums[n-1] != nums[n-2]) return nums[n-1];
        
        int low = 1, high = n-2, mid;
        
        while(low <= high) {
            mid = low + (high - low) / 2;

            // check whether element at mid is single element
            if(nums[mid] != nums[mid-1] && nums[mid] != nums[mid+1]) {
                return nums[mid];
            } 

            // standing on left half of single element
            // hence element will be on right half
            if( (mid % 2 == 0  && nums[mid] == nums[mid + 1]) ||  (mid % 2 == 1  && nums[mid] == nums[mid - 1]) ) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;
        
    }
}