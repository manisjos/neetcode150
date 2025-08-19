import java.util.Arrays;
import java.util.HashMap;

public class LC853_CarFleet {
    public static void main(String[] args) {
        int target = 12;
        int[] positions = {10, 8, 0, 5, 3};
        int[] speed = {2, 4, 1, 1, 3};
        System.out.println("Car Fleet Count " + getFleetCount(target, positions, speed));
        System.out.println("Car Fleet Count " + getFleetCount1(target, positions, speed));
    }

    private static int getFleetCount1(int target, int[] positions, int[] speed) {
        // my way
        int carCount = positions.length;
        if(carCount==1 || carCount==2)
            return 1;
        int res[] = new int[carCount];
        for (int i = 0; i < carCount; i++) {
            int i1 = positions[i] + speed[i];
            res[i] = i1;
        }
        int fleetCount = 0;
        for (int i = 0; i < carCount - 1; i++) {
            if (res[i + 1] == res[i])
                fleetCount++;
            if (res[i] == 1) {
                fleetCount++;
            }
        }
        return fleetCount;
    }

    private static int getFleetCount(int target, int[] positions, int[] speed) {
        int n= positions.length;
        double[][] cars = new double[n][2];
        for (int i=0;i<n;i++){
            cars[i][0] = positions[i];
            cars[i][0] = (target-positions[i])/speed[i];
        }
        Arrays.sort(cars,(a,b)->Double.compare(b[0],a[0]));
        int count = 0;
        double prevTime = 0;
        for (double[] car: cars){
            if(car[1]>prevTime){
                count++;
                prevTime = car[1];
            }
        }
        return count;
    }
    private static int getFleetCount2(int target, int[] positions, int[] speed) {
        int carCount = positions.length;

        // Array to hold the indices of the cars
        Integer[] indices = new Integer[carCount];

        for (int i = 0; i < carCount; i++) {
            indices[i] = i;
        }

        // Sort the indices based on the positions of the cars in descending order
        Arrays.sort(indices, (a, b) -> positions[b] - positions[a]);
        int fleetCount = 0;
        // The time taken by the previous car to reach the target
        double prevTime = 0;

        for (int idx : indices) {
            double timeToReach = 1.0 * (target - positions[idx]);

            if (timeToReach > prevTime) {
                fleetCount++;
                prevTime = timeToReach;
            }
        }
        return fleetCount;
    }

}
