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

    public int minAddToMakeValidConstantSpace(String s) {
        int openCnt = 0, closeCnt = 0;
        for (Character ch : s.toCharArray()) {
            if (ch == '(') {
                ++openCnt;
            } else {
                if (openCnt > 0) {
                    --openCnt;
                } else {
                    ++closeCnt;
                }
            }
        }

        return openCnt + closeCnt;
    }
}