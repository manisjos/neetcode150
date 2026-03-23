import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class ThreeCommonElements {
    public static void main(String[] args) {
        ArrayList<Integer> arr1 = new ArrayList<>(List.of(1, 5, 10, 20, 30));
        ArrayList<Integer> arr2 = new ArrayList<>(List.of(5, 20, 11, 22));
        ArrayList<Integer> arr3 = new ArrayList<>(List.of(1, 5, 20, 100));
        ArrayList<Integer> common = commonEleNaive(arr1, arr2, arr3);
        System.out.println("Common -> " + common.toString());


        int[] arr11 = {1, 5, 10, 20, 30};
        int[] arr22 = {5, 13, 15, 20};
        int[] arr33 = {5, 20};

        List<Integer> common1
                = commonEleOptimal(arr11, arr22, arr33);
        System.out.println("Common Optimal -> " + commonEleOptimal(arr11, arr22, arr33));

    }

    private static List<Integer> commonEleOptimal(int[] arr1, int[] arr2, int[] arr3) {
        int i = 0, j = 0, k = 0;
        List<Integer> common = new ArrayList<>();
        while (i < arr1.length && j < arr2.length && k < arr3.length) {
            if (arr1[i] == arr2[j] && arr2[j] == arr3[k]) {
                common.add(arr1[i]);
                i++;
                j++;
                k++;

                // handling the case when there are duplicates
                while (i < arr1.length && arr1[i] == arr1[i - 1])
                    i++;
                while (j < arr2.length && arr2[j] == arr2[j - 1])
                    j++;
                while (k < arr3.length && arr3[k] == arr3[k - 1])
                    k++;
            } else if (arr1[i] < arr2[j])
                i++;
            else if (arr2[j] < arr3[k])
                j++;
            else
                k++;
        }
        return common;
    }

    private static ArrayList<Integer> commonEleNaive(ArrayList<Integer> arr1, ArrayList<Integer> arr2, ArrayList<Integer> arr3) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int ele : arr1) {
            map.put(ele, 1);
        }
        for (int ele : arr2) {
            if (map.containsKey(ele) && map.get(ele) == 1) {
                map.put(ele, 2);
            }
        }
        for (int ele : arr3) {
            if (map.containsKey(ele) && map.get(ele) == 2) {
                map.put(ele, 3);
            }
        }
        ArrayList<Integer> commonEle = new ArrayList<>();
        for (int ele : map.keySet()) {
            if (map.get(ele) == 3) {
                commonEle.add(ele);
            }
        }
        return commonEle;
    }
}
