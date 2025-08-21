public class LC11_ContainedWater {
    public static void main(String[] args) {
        int height[] = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println("Maximum Water Area Possible : "+maxArea(height));
    }

    public static int maxArea(int height[]) {
        int max = 0;
        int left = 0, right = height.length - 1;

        while (left < right) {
            int width = right - left;
            int area = Math.min(height[left], height[right]) * width;

            max = Math.max(area, max);

            if (height[left] <= height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return max;
    }
}
