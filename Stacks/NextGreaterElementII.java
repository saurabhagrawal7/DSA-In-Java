import java.util.ArrayList;
import java.util.Stack;

public class NextGreaterElementII {
    public ArrayList<Integer> nextLargerElement(int[] arr) {
        int n = arr.length;
        ArrayList<Integer> ans = new ArrayList<>();
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++)
            ans.add(-1);

        for (int i = 0; i < 2 * n; i++) {

            while (!st.isEmpty() && arr[i % n] > arr[st.peek()]) {
                ans.set(st.peek(), arr[i % n]);
                st.pop();
            }

            st.push(i % n);
        }

        return ans;
    }
}