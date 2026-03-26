import java.util.HashMap;
import java.util.Map;

public class IsPermutation {
    public static void main(String[] args) {
        String s1 = "oidbcaf";
        String s2 = "abc";
        System.out.println("Is Permutation: " + isPerm(s1, s2));
    }

    static boolean isPerm(String s, String p) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : p.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int matched = 0, left = 0;
        for (int right = 0; right < s.length(); right++) {
            char r = s.charAt(right);
            if (map.containsKey(r)) {
                map.put(r, map.get(r) - 1);
                if (map.get(r) == 0) {
                    matched++;
                }

                if (matched == map.size()) {
                    return true;
                }

                if (right >= p.length() - 1) {
                    char l = s.charAt(left);
                    left++;

                    if (map.containsKey(l)) {
                        if (map.get(l) == 0) {
                            matched--;
                        }
                        map.put(l, map.get(l) + 1);
                    }
                }
            }
        }
        return false;
    }
}
