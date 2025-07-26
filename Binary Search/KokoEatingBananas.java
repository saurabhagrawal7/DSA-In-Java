public class KokoEatingBananas {

    private int caclulateEatingTime(int[] piles, int h) {
        int totalHrs = 0;
        for (int i = 0; i < piles.length; i++) {
            totalHrs += Math.ceil((double) piles[i] / h);
        }

        return totalHrs;
    }

    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;
        int low = 1, high = 0;
        for (int i = 0; i < n; i++) {
            if (piles[i] > high)
                high = piles[i];
        }
        int ans = Integer.MAX_VALUE;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (caclulateEatingTime(piles, mid) <= h) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }
}