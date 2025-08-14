import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TOP_K_LC347 {
    public static void main(String[] args) {
        System.out.println((topKFrequent_Naive(new int[]{1,1,1,2,2,3},2)));
    }

    public static ArrayList<Integer> topKFrequent_Naive(int[] nums, int rank) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num: nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        ArrayList<int[]> freq = new ArrayList<>();
        for (Map.Entry<Integer,Integer> entry : map.entrySet()){
            freq.add(new int[]{entry.getKey(),entry.getValue()});
        }
        freq.sort(new Compare());
        ArrayList<Integer> res = new ArrayList<>();
        for (int i=0;i<rank;i++){
            res.add(freq.get(i)[0]);
        }
        return res;
    }

}
