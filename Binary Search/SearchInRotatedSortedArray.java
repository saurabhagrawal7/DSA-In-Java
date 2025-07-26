public class SearchInRotatedSortedArray {
    public int search(int[] arr, int k) {
        int n = arr.length;
        int low = 0, high = n - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == k)
                return mid;
            
            // Handle duplicates    
            // if (arr[low] == arr[mid] && arr[mid] == arr[high]) {
            //     low++;
            //     high--;
            //     continue;
            // }

            // Check if the left half is sorted
            if (arr[low] <= arr[mid]) {
                if (k >= arr[low] && k < arr[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            // If the left half is not sorted, then the right half must be sorted
            else {
                if (k > arr[mid] && k <= arr[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }

        return -1;
    }
}
