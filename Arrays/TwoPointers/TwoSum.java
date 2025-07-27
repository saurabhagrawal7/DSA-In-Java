import java.util.HashMap;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[] { i, j };
                }
            }
        }

        return new int[] { -1, -1 };
    }

    public int[] twoSumUsingMap(int[] nums, int target) {
        int n = nums.length;
        HashMap<Integer, Integer> mp = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int rem = target - nums[i];
            if (mp.containsKey(rem)) {
                return new int[] { i, mp.get(rem) };
            }
            mp.put(nums[i], i);
        }

        return new int[] { -1, -1 };
    }
}
