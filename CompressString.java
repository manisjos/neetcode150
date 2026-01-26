public class CompressString {
    public static void main(String[] args) {

        System.out.println(compressString("aabbcdd"));
    }

    private static String compressString(String s) {
        if (s == null || s.length() == 0)
            return s;

        StringBuilder result = new StringBuilder();
        int count = 1;
        for (int i = 1; i < s.length(); i++) {
            if(s.charAt(i)==s.charAt(i-1)){
                count++;
            } else {
                result.append(s.charAt(i-1));
                result.append(count);
                count=1;
            }
        }
        result.append(s.charAt(s.length()-1));
        result.append(count);
        return result.toString();
    }
}

