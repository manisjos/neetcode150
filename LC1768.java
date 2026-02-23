public class LC1768 {
    public static void main(String[] args) {
        String word1 = "ab";
        String word2 = "pqrs";
        System.out.println(mergeAlternatively(word1, word2));
    }

    private static String mergeAlternatively(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        int min = Math.min(len1,len2);
        String longestStr = "";
        if(min==len1){
            longestStr = word2;
        }
        if (min==len2) {
            longestStr = word1;
        }
        char chars1[] = word1.toCharArray();
        char chars2[] = word2.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i=0;i<min;i++){
            sb.append(chars1[i]);
            sb.append(chars2[i]);
        }
        sb.append(longestStr.substring(min));
        return sb.toString();

    }
}
