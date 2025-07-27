public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int maxWater = 0;
        int lp = 0, rp = height.length - 1;

        while (lp < rp) {
            int w = rp - lp;
            int ht = Math.min(height[lp], height[rp]);
            int currWater = ht * w;
            maxWater = Math.max(maxWater, currWater);
            if (height[lp] < height[rp])
                lp++;
            else
                rp--;
        }

        return maxWater;
    }
}
