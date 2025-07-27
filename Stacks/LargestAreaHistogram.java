import java.util.Arrays;
import java.util.Stack;

public class LargestAreaHistogram {
    public int largestRectangleArea(int[] heights) {
        // Next smallest left
        // Next smallest right
        int n = heights.length;
        int[] Right = new int[n];
        int[] Left = new int[n];

        Stack<Integer> st = new Stack<>();

        // Next smallest right find karo
        Arrays.fill(Right, n);
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && heights[st.peek()] > heights[i]) {
                Right[st.peek()] = i;
                st.pop();
            }
            st.push(i);
        }

        // Stack ko empty karo
        while (!st.isEmpty())
            st.pop();

        // Next smallest left find karo
        Arrays.fill(Left, -1);
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && heights[i] < heights[st.peek()]) {
                Left[st.peek()] = i;
                st.pop();
            }
            st.push(i);
        }

        // Area ko calculate karo
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int ht = heights[i];
            int wt = Right[i] - Left[i] - 1;
            int area = ht * wt;
            ans = Math.max(ans, area);
        }

        return ans;
    }
}