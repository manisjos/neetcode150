public class ContainerWater {
    public static void main(String[] args) {
        int height[] = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println("Max Water Capacity BruteForce: " + maxAreaBruteForce(height));
        System.out.println("Max Water Capacity: " + maxArea(height));
    }

    static int maxAreaBruteForce(int[] height) {
        int maxWater = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int width = j - i;
                int h = Math.min(height[i], height[j]);
                maxWater = Math.max(maxWater, width * h);
            }
        }
        return maxWater;
    }

    static int maxArea(int arr[]) {
        int left = 0;
        int right = arr.length - 1;
        int maxWater = 0;

        while (left < right) {
            int width = right - left;
            int currHeight = Math.min(arr[left], arr[right]);

            int currArea = width * currHeight;
            maxWater = Math.max(maxWater, currArea);


            if (arr[left] < arr[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxWater;
    }
}
