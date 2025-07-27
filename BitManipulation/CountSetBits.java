public class CountSetBits {

    public static void main(String[] args) {

        int n = 10;
        int cnt = 0;
        while (n > 1) {
            cnt += (n & 1);
            n = n >> 1;
        }
        if (n == 1)
            cnt++;
        System.out.println(cnt);
    }
}
