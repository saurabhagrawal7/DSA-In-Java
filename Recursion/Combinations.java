import java.util.ArrayList;
import java.util.List;

public class Combinations {
    private void helper(List<List<Integer>> res, List<Integer> curr, int n, int k) {
        if (k == 0) {
            res.add(new ArrayList<>(curr));
            return;
        }

        if (n == 0)
            return;

        // take nth element
        curr.add(n);
        helper(res, curr, n - 1, k - 1);
        curr.remove(curr.size() - 1);
        // not take nth element
        helper(res, curr, n - 1, k);
    }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        helper(res, curr, n, k);
        return res;
    }
}