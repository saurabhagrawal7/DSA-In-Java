public class MinDaysMakeMBouquets {
     private int canMakeBouquets(int[] bloomDay, int k, int day) {
        int total = 0, cnt = 0;

        for(int i = 0; i < bloomDay.length; i++) {
            if(bloomDay[i] <= day) {
                cnt++;
                if(cnt == k) {
                    total++;
                    cnt = 0;
                }
            } else {
                cnt = 0;
            }
            
        }

        return total;
    }

    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
        if(m*k > n) return -1;
        int low = 1, high = 0;

        for(int i = 0; i < n; i++) {
            if(bloomDay[i] > high) {
                high = bloomDay[i];                
            }
        }

        int ans = -1;

        while(low <= high) {
            int mid = low + (high - low) / 2;
            if(canMakeBouquets(bloomDay, k, mid) >= m) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;

    }
}