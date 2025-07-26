// nth root of m means kisi no. of n times multiply karke uska 
// result m ana chaiye

public class NthRootOfM {

    private int checkNthRoot(int i, int n) {
        int ans = 1;
        for (int j = 0; j < n; j++) {
            ans = ans * i;
        }

        return ans;
    }

    public int nthRoot(int n, int m) {
        int low = 0, high = m;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (checkNthRoot(mid, n) == m) {
                return mid;
            }

            if (checkNthRoot(mid, n) > m) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }

        }

        return -1;
    }
}