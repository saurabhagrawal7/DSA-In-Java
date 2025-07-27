/*
Approach
1. XOR will cancel out all numbers appearing twice, hence only xor of 2 numbers will be left
2. we know xor cancel out similar bits, hence will do xor of remaining 2 nos & check which bit is diff in both
3. will group them both accordingly
*/

public class SingleNumberIII {
    public int[] singleNumber(int[] nums) {
        long xor = 0;

        for (int num : nums)
            xor = xor ^ num;

        // mask -> right most set bit search
        long mask = (xor & (-xor));

        int groupa = 0;
        int groupb = 0;

        for (int num : nums) {
            if ((num & mask) != 0) {
                groupa ^= num;
            } else {
                groupb ^= num;
            }
        }

        return new int[] { groupa, groupb };
    }
}
