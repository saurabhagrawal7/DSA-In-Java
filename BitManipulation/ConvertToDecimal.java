public class ConvertToDecimal {

    static int convertToDecimal(String x) {
        int len = x.length();
        int num = 0;
        int p2 = 1;

        for (int i = len - 1; i >= 0; i--) {
            if (x.charAt(i) == '1') {
                num = num + p2;
            }
            p2 = p2 * 2;
        }

        return num;
    }

    public static void main(String[] args) {
        System.out.println(convertToDecimal("1010"));
    }

}
