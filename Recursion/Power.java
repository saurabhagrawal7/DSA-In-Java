public class Power {

    static int calculatePower(int x, int n) {
        if (n == 0)
            return 1;
        return x * calculatePower(x, n - 1);
    }

    static int calculatePower2(int x, int n) {
        if (n == 0)
            return 1;
        int temp = calculatePower2(x, n / 2);
        int ans = temp * temp;
        if (n % 2 == 1) {
            ans = ans * x;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(calculatePower2(2, 4));
    }
}
