import java.util.Comparator;

public class Compare implements Comparator<int[]> {
    @Override
    public int compare(int[] p1, int[] p2) {
        if(p1[1]==p2[1])
            return Integer.compare(p2[0],p1[0]);
        return Integer.compare(p2[1],p1[1]);
    }
}
