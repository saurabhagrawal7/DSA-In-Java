import java.util.ArrayList;
import java.util.Stack;

public class OnlineStockSpan {
    public ArrayList<Integer> calculateSpan(int[] arr) {
        int n = arr.length;
        ArrayList<Integer> ans = new ArrayList<>();
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++)
            ans.add(1);

        for (int i = n - 1; i >= 0; i--) {

            while (!st.isEmpty() && arr[i] > arr[st.peek()]) {
                ans.set(st.peek(), st.peek() - i);
                st.pop();
            }
            st.push(i);
        }

        while (!st.isEmpty()) {
            ans.set(st.peek(), st.peek() + 1);
            st.pop();
        }

        return ans;
    }
}
