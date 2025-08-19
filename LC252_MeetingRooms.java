import java.util.Arrays;
import java.util.Comparator;

public class LC252_MeetingRooms {
    public static void main(String[] args) {
        int[][] input = {{5, 8}, {9, 15}};
        int[][] intervals1 = {{0, 30}, {5, 10}, {15, 20}};
        System.out.println(canAttendMeetings(input));
        System.out.println(canAttendMeetings(intervals1));
    }

    private static boolean canAttendMeetings(int[][] input) {
        int len = input.length;
        Arrays.sort(input, Comparator.comparingInt(a -> a[0]));
        for (int i = 1; i < len; i++) {
            if (input[i][0] < input[i - 1][1]) {
                return false;
            }
        }
        return true;
    }
}
