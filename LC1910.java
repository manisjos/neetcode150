public class LC1910 {
    public static void main(String[] args) {
        String s = "daabcbaabcbc", part = "abc";
        removeOccuranceNaive(s, part);
    }

    private static void removeOccuranceNaive(String s, String part) {

        StringBuilder sb = new StringBuilder(s);
        int index;
        while ((index = sb.indexOf(part)) != -1) {
            sb.delete(index, index + part.length());
        }
        System.out.println(sb.toString());
    }
}
