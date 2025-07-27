public class ConvertToBinary {

    static String convertToBinary(int x) {
        String res = "";
        while (x != 1) {
            if (x % 2 == 1) {
                res += "1";
            } else {
                res += "0";
            }
            x /= 2;
        }
        res += "1";
        String ans = "";
        for (int i = res.length() - 1; i >= 0; i--) {
            ans += res.charAt(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(convertToBinary(10));
    }
}
