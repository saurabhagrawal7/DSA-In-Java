public class DivideTwoIntegers {
    public int divide(int dividend, int divisor) {
        if (dividend == divisor)
            return 1;

        boolean sign = true; // +ve
        if (dividend >= 0 && divisor < 0)
            sign = false;
        if (dividend < 0 && divisor > 0)
            sign = false;
        long n = Math.abs((long) dividend);
        long d = Math.abs((long) divisor);
        long quotient = 0;
        while (n >= d) {
            int cnt = 0;
            // below will be d * 2 ^ cnt+1
            while (n >= (d << (cnt + 1))) {
                cnt += 1;
            }
            quotient += (1 << cnt);
            n -= (d << cnt);
        }

        if (quotient == (1 << 31) && sign) {
            return Integer.MAX_VALUE;
        }
        if (quotient == (1 << 31) && !sign) {
            return Integer.MIN_VALUE;
        }

        return sign ? (int) quotient : (int) -quotient;
    }
}
