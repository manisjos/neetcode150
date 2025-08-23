import java.lang.reflect.Array;
import java.util.Arrays;

public class LC41_MedianOfSortedArr {
    public static void main(String[] args) {
        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4};
        System.out.println("Median : " + findMedianSortedArrays(nums1, nums2));
        System.out.println("Log(m+n) approach - Median : " + findMedianSortedArraysEfficientWay(nums1, nums2));
    }

    public static double findMedianSortedArraysEfficientWay(int[] nums1, int[] nums2) {
        System.out.println("Doing the efficient way: log (m+n) cost via binary search");
        if (nums1.length > nums2.length) {
            return findMedianSortedArraysEfficientWay(nums2, nums1); // ensure nums1 is smaller
        }

        int m = nums1.length;
        int n = nums2.length;
        int totalLeft = (m + n + 1) / 2;

        int left = 0, right = m;

        while (left <= right) {
            int i = (left + right) / 2;
            int j = totalLeft - i;

            int nums1LeftMax = (i == 0) ? Integer.MIN_VALUE : nums1[i - 1];
            int nums1RightMin = (i == m) ? Integer.MAX_VALUE : nums1[i];

            int nums2LeftMax = (j == 0) ? Integer.MIN_VALUE : nums2[j - 1];
            int nums2RightMin = (j == n) ? Integer.MAX_VALUE : nums2[j];

            if (nums1LeftMax <= nums2RightMin && nums2LeftMax <= nums1RightMin) {
                if ((m + n) % 2 == 1) {
                    return Math.max(nums1LeftMax, nums2LeftMax);
                } else {
                    return (Math.max(nums1LeftMax, nums2LeftMax) +
                            Math.min(nums1RightMin, nums2RightMin)) / 2.0;
                }
            } else if (nums1LeftMax > nums2RightMin) {
                right = i - 1;
            } else {
                left = i + 1;
            }
        }

        throw new IllegalArgumentException("Input arrays are not sorted!");
    }

    public static double findMedianSortedArrays(int num1[], int[] num2) {
        int n = num1.length;
        int m = num2.length;
        int[] merged = new int[m + n];
        int k = 0;

        for (int i = 0; i < n; i++) {
            merged[k++] = num1[i];
        }
        for (int i = 0; i < m; i++) {
            merged[k++] = num2[i];
        }
        Arrays.sort(merged);
        int total = merged.length;
        if (total % 2 == 1) {
            return (double) merged[total / 2];
        } else {
            int middle1 = merged[total / 2 - 1];
            int middle2 = merged[total / 2];
            return ((double) middle1 + (double) middle2) / 2.0;
        }

    }
}
