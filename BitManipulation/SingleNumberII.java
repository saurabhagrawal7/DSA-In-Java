import java.util.HashMap;

public class SingleNumberII {
    public int singleNumber(int[] nums) {
        int result = 0;

        for (int k = 0; k <= 31; k++) {

            int countZeros = 0;
            int countOnes = 0;

            // check kth bit of every number
            for (int num : nums) {
                if ((num & (1 << k)) == 0) {
                    countZeros++;
                } else {
                    countOnes++;
                }
            }

            if (countOnes % 3 == 1) {
                result = (result | (1 << k));
            }
        }

        return result;
    }
}
