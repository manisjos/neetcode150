import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class radioActivePeaks {
    public static void main(String[] args) {
        List<Double> values = Arrays.asList(
                81.3, 80.3, 75.3, 80.3, 85.2,
                90.2, 95.2, 90.2, 89.1, 88.8
        );

        System.out.println("Count: " + countPeaks(values));

    }

    public static int countPeaks(List<Double> values) {
        int count = 0;
        final double EPS = 1e-9; // floating-point tolerance

        for (int i = 1; i < values.size() - 1; i++) {
            double prev = values.get(i - 1);
            double curr = values.get(i);
            double next = values.get(i + 1);

            // Top peak: at least 5 units higher than both neighbors
            if (curr - prev >= 5 - EPS && curr - next >= 5 - EPS) {
                count++;
            }
            // Bottom peak: at least 5 units lower than both neighbors
            else if (prev - curr >= 5 - EPS && next - curr >= 5 - EPS) {
                count++;
            }
        }

        return count;
    }

}
