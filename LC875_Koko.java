public class LC875_Koko {
    public static void main(String[] args) {
        int[] bananaPileArr = {3, 6, 7, 11};
        int hours = 8;
        System.out.println("Koko should eat at " + minEatingSpeed(bananaPileArr, hours) + " banana per hour");
    }

    public static int minEatingSpeed(int[] piles, int h) {
        int minSpeed = 1;
        int maxSpeed = 0;
        for (int pile : piles) {
            maxSpeed = Math.max(pile, maxSpeed);
        }

        while (minSpeed < maxSpeed) {
            int mid = minSpeed + (maxSpeed - minSpeed) / 2;
            if (canEatInTime(piles, h, mid))
                maxSpeed = mid;
            else
                minSpeed = mid + 1;
        }
        return minSpeed;
    }

    public static boolean canEatInTime(int[] piles, int h, int speed) {
        int hours = 0;
        for (int pile : piles)
            hours = hours + (int) Math.ceil((double) pile / speed);
        return hours <= h;
    }
}
