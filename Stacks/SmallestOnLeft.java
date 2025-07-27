import java.util.Arrays;
import java.util.Stack;

public class SmallestOnLeft {
    public int[] leftSmaller(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        Stack<Integer> st = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {

            while (!st.isEmpty() && arr[i] < arr[st.peek()]) {
                ans[st.peek()] = arr[i];
                st.pop();

            }

            st.push(i);
        }

        return ans;
    }

}
