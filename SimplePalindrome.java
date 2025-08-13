public class SimplePalindrome {
    public static void main(String[] args) {
        int n = 12321;
        if (isPalindrome(n)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }

        // app 2 - bruteforce
        if (isPalindromeApp2(n)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }

    public static boolean isPalindrome(int n) {
        if(n<0)
            return false;
        // comparing from mid and start
        String s = Integer.toString(Math.abs(n));
        int len = s.length();
        for (int i = 0; i < len / 2; i++) {
            if (s.charAt(i) != s.charAt(len - i - 1))
                return false;
        }
        return true;
    }

    public static boolean isPalindromeApp2(int n) {
        // reverese input and compare
        int reverse = 0;
        int temp = Math.abs(n);
        while (temp != 0) {
            reverse = (reverse * 10) + (temp % 10);
            temp = temp / 10;
        }
        return (reverse==Math.abs(n));
    }

}
