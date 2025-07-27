import java.util.*;

// Application of Pascal Triangle is nCr calculation

public class PascalTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
            List<Integer> currRow = new ArrayList<>(i + 1); // each row has i+1 cols
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    currRow.add(1);
                } else {
                    int val = ans.get(i - 1).get(j - 1) + ans.get(i - 1).get(j);
                    currRow.add(val);
                }
            }

            ans.add(currRow);
        }

        return ans;
    }
}
