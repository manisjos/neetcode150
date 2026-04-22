import java.util.Arrays;

public class LC455_AssignCookies {
    public static void main(String[] args) {
        int[] greedFactors = {1, 2, 3};
        int[] cookieSizes = {1, 1};
        System.out.println("Min Radius: " + findContentChildren(greedFactors, cookieSizes));
    }

    static int findContentChildren(int[] greedFactors, int[] cookieSizes) {
        // Sort both arrays to apply greedy strategy
        Arrays.sort(greedFactors);
        Arrays.sort(cookieSizes);

        int childIndex = 0;
        int cookieIndex = 0;

        // try to satisfy each child one by one
        while (childIndex < greedFactors.length && cookieIndex < cookieSizes.length) {

            // if current cookie can satisfy current child
            if (cookieSizes[cookieIndex] >= greedFactors[childIndex]) {
                childIndex++; // child satisfied, move to the next child
            }
            cookieIndex++; // always move to the next cookies irrespectively
        }
        return childIndex;
    }
}
