// IMP & Hard Problem
// HW - try 0 - n

// TC - O(2^n)
// SC - O(n)

public class DecodeWays {
    private int helper(String s, int ind) {
        if (ind <= 0)
            return 1;

        int res = 0;

        // single digit as a char
        // 0 is not a valid single character as A has to start from 1
        if (s.charAt(ind) != '0')
            res += helper(s, ind - 1);

        // double digits as a char
        // ind, ind - 1 => double digit no should be between 1 and 26
        if ((s.charAt(ind - 1) == '1') || (s.charAt(ind - 1) == '2' && s.charAt(ind) >= '0' && s.charAt(ind) <= '6'))
            res += helper(s, ind - 2);

        return res;
    }

    public int numDecodings(String s) {
        if (s.charAt(0) == '0')
            return 0;
        return helper(s, s.length() - 1);
    }
}