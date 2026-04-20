import java.util.TreeSet;

public class LC475_Heaters_RedBlackTree {
    public static void main(String[] args) {
        int[] houses = {1, 2, 3, 4};
        int[] heaters = {1, 4};
        System.out.println("Min Radius: "+findRadius(houses, heaters));

    }

    static int findRadius(int[] houses, int[] heaters) {
        TreeSet<Integer> sortedHeaters = new TreeSet<>();
        for (int h : heaters) {
            sortedHeaters.add(h);
        }
        int maxRadius = 0;
        for (int house : houses) {
            Integer floor = sortedHeaters.floor(house);
            Integer ceiling = sortedHeaters.ceiling(house);

            int leftDistance = floor == null ? Integer.MAX_VALUE : house - floor;
            int rightDistance = ceiling == null ? Integer.MAX_VALUE : ceiling - house;

            int radius = Math.min(leftDistance, rightDistance);
            maxRadius = Math.max(maxRadius, radius);
        }

        return maxRadius;
    }
}
