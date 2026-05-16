public class minMeetings {
    public static void main(String[] args) {
        int start[] = {2, 9, 6};
        int end[] = {4, 12, 10};
        System.out.println("Min : " + minMeetsNaive(start, end));
    }

    static int minMeetsNaive(int start[], int end[]) {
        int n = start.length;
        int room = 1, res = 1;
        for (int i = 0; i < n; i++) {
            room = 1;
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    if (start[i] >= start[j] && end[j] > start[i]) {
                        // 2>9 && 12>2
                        // 2 >10 && 10>2
                        room++;
                    }
                }
            }
            res = Math.max(res, room);
        }
        return res;
    }
}
