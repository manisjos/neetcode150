import java.util.Arrays;

public class LC3_ValidAnagram_LC217_EASY_Ones {
    public static void main(String[] args) {
        String string1="anagram", string2="nagaram";
        System.out.println("Are the strings Angram ? "+isTheseTwoAnagrams(string1, string2));
        System.out.println("Are there duplicates in the input array [1,2,3,1] ? "+containsDuplicate(new int[]{1,2,3,1}));
    }
    private static boolean isTheseTwoAnagrams(String string1, String string2) {
        int OneLen = string1.length(), TwoLen=string2.length();
        char[] charArr1 = string1.toCharArray();
        char[] charArr2 = string2.toCharArray();
        if(OneLen!=TwoLen) return false; // if not same length, cant be anagram
        Arrays.sort(charArr1);Arrays.sort(charArr2);
        for (int i=0;i<OneLen;i++){
            if(charArr1[i]!=charArr2[i])
                return false;
        }
        return true;
    }

    // LC 217: Duplicates in Arr
    public static boolean containsDuplicate(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len ; i++) {
            for (int j = i+1; j < len; j++) {
                if (nums[i] == nums[j]) {
                    return true;
                }
            }
        }
        return false;
    }
}
