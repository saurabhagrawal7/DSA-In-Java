import java.util.*;

public class MinAddToMakeParenthesisValid {
    public int minAddToMakeValid(String s) {
        Stack<Character> st = new Stack<>();
        int ans = 0;
        for (Character ch : s.toCharArray()) {
            if (ch == '(') {
                ++ans;
                st.push(ch);
            } else {
                if (!st.isEmpty()) {
                    st.pop();
                    --ans;
                } else {
                    ++ans;
                }
            }
        }

        return ans;
    }
}