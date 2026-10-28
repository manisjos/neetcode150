public class LC42_TrappingWater {
    public static void main(String[] args) {
        int arr[] = {4, 2, 0, 3, 2, 5};
        System.out.println(trappedWater(arr));
        System.out.println(trappedWaterSimplest(arr));
        System.out.println(trappedWaterDPApproach(arr));
    }

    static int trappedWaterSimplest(int[] height) {
        int n = height.length;
        int ans = 0;
        int l = 0, r = n - 1;
        int lmax = 0, rmax = 0;

        while (l < r) {
            lmax = Math.max(lmax, height[l]);
            rmax = Math.max(rmax, height[r]);

            if (lmax < rmax) {
                ans += lmax - height[l];
                l++;
            } else {
                ans += rmax - height[r];
                r--;
            }
        }

        return ans;
    }

    static int trappedWaterDPApproach(int[] height) {
        if (height == null || height.length <= 2) {
            return 0;
        }

        int n = height.length;
        int lmax[] = new int[n];
        int rmax[] = new int[n];

        lmax[0] = height[0];
        for (int i = 1; i < n; i++) {
            lmax[i] = Math.max(lmax[i - 1], height[i]);
        }

        rmax[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rmax[i] = Math.max(rmax[i + 1], height[i]);
        }

        // calc trapper water
        int totalWater = 0;
        for (int i = 0; i < n; i++) {
            totalWater += Math.min(lmax[i], rmax[i]) - height[i];
        }

        return totalWater;
    }

    static int trappedWater(int[] height) {
        if (height == null || height.length <= 2) {
            return 0;
        }

        int left = 0;
        int right = height.length - 1;

        int leftMax = 0;
        int rightMax = 0;

        int totalWater = 0;

        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] >= leftMax) {
                    leftMax = height[left];
                } else {
                    totalWater += leftMax - height[left];
                }
                left++;
            } else {
                if (height[right] >= rightMax) {
                    rightMax = height[right];
                } else {
                    totalWater += rightMax - height[right];
                }
            }
        }
        return totalWater;
    }
}
