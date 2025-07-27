import java.util.Stack;

public class GetMinAtPop {
    // Function to push all the elements into the stack.
    public static Stack<Integer> _push(int arr[], int n) {
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            if (i == 0)
                st.push(arr[i]);
            else
                st.push(Math.min(arr[i], st.peek()));
        }
        return st;
    }

    // Function to print minimum value in stack each time while popping.
    static void _getMinAtPop(Stack<Integer> s) {
        while (!s.isEmpty()) {
            System.out.print(s.pop() + " ");
        }
    }
}
