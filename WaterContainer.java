public class WaterContainer {
    public static void main(String[] args) {
        int arr[] = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(checkMaxAreaBF(arr));
        System.out.println(checkMaxAreaOptimal(arr));
    }

    static int checkMaxAreaBF(int[] height) {
        int currMax = 0;

        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int width = j - i;
                int h = Math.min(height[i], height[j]);
                int area = width * h;
                currMax = Math.max(area, currMax);
            }
        }
        return currMax;
    }

    static int checkMaxAreaOptimal(int[] height) {
        int currMax = 0;
        int lp = 0;
        int n = height.length;
        int rp = n - 1;

        while (lp < rp) {
            int width = rp - lp;
            int h = Math.min(height[lp], height[rp]);
            int area = width * h;
            currMax = Math.max(area, currMax);

            if (height[lp] < height[rp]) {
                lp++;
            } else {
                rp--;
            }
        }
        return currMax;
    }
}
