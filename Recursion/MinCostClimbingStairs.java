// NOTE: In this problem we need to reach at top floor & not n-1th step

public class MinCostClimbingStairs {
    private int helper(int ind, int[] cost) {
        if (ind >= cost.length) {
            return 0;
        }

        return cost[ind] + Math.min(helper(ind + 1, cost), helper(ind + 2, cost));
    }

    public int minCostClimbingStairs(int[] cost) {
        return Math.min(helper(0, cost), helper(1, cost));
    }

    private int helper2(int ind, int[] cost) {
        if (ind < 0) {
            return 0;
        }

        return cost[ind] + Math.min(helper(ind - 1, cost), helper(ind - 2, cost));
    }

    public int minCostClimbingStairs2(int[] cost) {
        int n = cost.length;
        return Math.min(helper2(n - 1, cost), helper2(n - 2, cost));
    }
}
