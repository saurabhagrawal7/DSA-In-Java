import java.util.*;

public class PascalTriangleII {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> prev = new ArrayList<>();

        for (int i = 0; i < rowIndex + 1; i++) {
            List<Integer> curr = new ArrayList<>(i + 1); // each row has i+1 cols
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    curr.add(1);
                } else {
                    int val = prev.get(j - 1) + prev.get(j);
                    curr.add(val);
                }
            }

            prev = curr;
        }

        return prev;
    }
}
