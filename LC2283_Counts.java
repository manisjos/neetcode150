public class LC2283_Counts {
    public static void main(String[] args) {
        System.out.println("True / False -->> " + digitCount("1210"));
    }

    public static boolean digitCount(String num) {
//        int arr[] = new int[num.length()];
//        for (int i = 0; i < num.length(); i++) {
//            arr[i] = num.charAt(i) - '0';
//        }

        int[] cnt = new int[10];
        int n = num.length();
        for (int i = 0; i < n; i++) {
            ++cnt[num.charAt(i)-'0'];
        }
        for (int i=0;i<n;++i){
            if(num.charAt(i)-'0'!=cnt[i]){
                return false;
            }
        }
        return true;
    }

}
