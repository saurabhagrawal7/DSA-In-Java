import java.util.ArrayList;
import java.util.Stack;

// Method 1
public class NextGreaterElement {
    public ArrayList<Integer> nextLargerElement(int[] arr) {
        int n = arr.length;
        ArrayList<Integer> ans = new ArrayList<>();
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++)
            ans.add(-1);

        for (int i = 0; i < n; i++) {

            while (!st.isEmpty() && arr[st.peek()] < arr[i]) {
                ans.set(st.peek(), arr[i]);
                st.pop();
            }

            st.push(i);
        }

        return ans;
    }

    // Method 2
    public ArrayList<Integer> nextLargerElementMeth2(int[] arr) {
        int n = arr.length;
        ArrayList<Integer> ans = new ArrayList<>();
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++)
            ans.add(-1);

        for (int i = n - 1; i >= 0; i--) {

            while (!st.isEmpty() && arr[st.peek()] <= arr[i]) {
                st.pop();
            }
            if (!st.isEmpty())
                ans.set(i, arr[st.peek()]);
            st.push(i);
        }

        return ans;
    }
}
