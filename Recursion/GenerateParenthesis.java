import java.util.*;

// TC - 2^2n - there are 2N places to be filled, everyone can be filled by open or close
// SC - 2n

public class GenerateParenthesis {
    void helper(int n, int open, int closed, List<String> res, String curr) {

        if (open + closed == 2 * n) {
            res.add(curr);
            return;
        }

        // Pick opening
        if (open < n)
            helper(n, open + 1, closed, res, curr + "(");

        // Pick closing
        if (open > closed)
            helper(n, open, closed + 1, res, curr + ")");

    }

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        helper(n, 0, 0, res, "");
        return res;
    }
}