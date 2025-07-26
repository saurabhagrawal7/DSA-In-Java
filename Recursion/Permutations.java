import java.util.ArrayList;
import java.util.List;

public class Permutations {
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void helper(int ind, int[] nums, List<List<Integer>> res) {
        if (ind == nums.length) {
            List<Integer> temp = new ArrayList<>();
            for (int num : nums)
                temp.add(num);
            res.add(temp);
            return;
        }

        for (int i = ind; i < nums.length; i++) {
            swap(nums, ind, i);
            System.out.println("Swapping " + (ind + 1) + " with " + (i + 1));
            helper(ind + 1, nums, res);
            System.out.println("Swapping back " + (ind + 1) + " with " + (i + 1));
            swap(nums, ind, i);
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        helper(0, nums, res);
        return res;

    }
}