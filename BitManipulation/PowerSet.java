import java.util.ArrayList;

public class PowerSet {
    public static void main(String[] args) {
        int n = 3;
        int[] nums = { 1, 2, 3 };
        int subsets = 1 << n;

        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        for (int num = 0; num < subsets; num++) {
            ArrayList<Integer> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if ((num & (1 << i)) != 0) {
                    // it means it is a set bit
                    list.add(nums[i]);
                }
            }
            ans.add(list);
        }

        System.out.println(ans);
    }
}
