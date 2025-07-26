public class SqrtX {
    public int mySqrt(int x) {
        int start = 1, end = x, ans = 0, mid;
        if (x < 1)
            return 0;
        while (start <= end) {
            mid = start + (end - start) / 2;

            if (mid == x / mid) {
                ans = mid;
                break;
            } else if (mid > x / mid) {
                end = mid - 1;
            } else {
                ans = mid;
                start = mid + 1;
            }
        }

        return ans;
    }
}

// 4*4 == 16 can we written as 4 = 16/4, thats why we are using mid == x/mid
