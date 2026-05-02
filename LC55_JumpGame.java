public class LC55_JumpGame {
    public static void main(String[] args) {
        int[] arr = {2, 3, 1, 1, 4};
        int[] arr2 = {3, 2, 1, 0, 4};

        System.out.println("Can reach -> " + canJump(arr));
        System.out.println("Can reach diff array -> " + canJump(arr2));
    }

    private static boolean canJump(int[] arr) {
        int maxReach = 0;
        for (int i = 0; i < arr.length; i++) {
            // if curr index is unreachable
            if (i > maxReach) {
                return false;
            }
            // update farthest reachable index
            maxReach = Math.max(maxReach, i + arr[i]);

            // early exit the checks, if we can already reach end
            if(maxReach>=arr.length-1){
                return true;
            }
        }
        return true; // this executes in [2,0,0], [1,1,1,1] kind of cases.
    }
}
