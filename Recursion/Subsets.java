import java.util.ArrayList;
import java.util.List;

public class Subsets {
    private void helper(int ind, int[] nums, List<List<Integer>> res, List<Integer> curr) {
        if (ind >= nums.length) {
            res.add(new ArrayList<>(curr));
            return;
        }

        // inc
        curr.add(nums[ind]);
        helper(ind + 1, nums, res, curr);
        curr.remove(curr.size() - 1);

        // exc
        helper(ind + 1, nums, res, curr);
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        helper(0, nums, res, curr);
        return res;
    }
}