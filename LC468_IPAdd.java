public class LC468_IPAdd {
    public static void main(String[] args) {
//        String queryIP = "123.12.144.19";
//        String queryIP = "256.256.256.256";
        String queryIP = "255.255.255.255";
        System.out.println(validIPAddress(queryIP));
    }

    public static String validIPAddress(String s) {
        if (isIPv6(s)) {
            return "IPv6";
        }
        if (isIpv4(s)) {
            return "IPv4";
        }
        return "Neither";
    }

    private static boolean isIpv4(String s) {
        if (s.endsWith(".")) {
            return false;
        }
        String[] ss = s.split("\\.");
        if (ss.length != 4) {
            return false;
        }
        for (String t : ss) {
            if (t.length() == 0 || t.length() > 1 && t.charAt(0) == '0') {
                return false;
            }
            int x = convert(t);
            if (x < 0 || x > 255) {
                return false;
            }
        }
        return true;
    }

    private static int convert(String s) {
        int x = 0;
        for (char c : s.toCharArray()) {
            if (!Character.isDigit(c)) {
                return -1;
            }
            x = x * 10 + (c - '0');
            if (x > 255) {
                return x;
            }
        }
        return x;
    }

    private static boolean isIPv6(String s) {

        if (s.endsWith(":")) {
            return false;
        }
        String[] ss = s.split(":");
        if (ss.length != 8) {
            return false;
        }
        for (String t : ss) {
            if (t.length() < 1 || t.length() > 4) {
                return false;
            }
            for (char c : t.toCharArray()) {
                if (!Character.isDigit(c)
                        && !"0123456789abcdefABCDEF".contains(String.valueOf(c))) {
                    return false;
                }
            }
        }
        return true;
    }
}
