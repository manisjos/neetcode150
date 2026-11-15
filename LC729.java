import java.util.HashSet;

class LC729{
    public static void main(String[] args) {
        HashSet<String> set = new HashSet<>();
        set.add("Java");
        set.add("Python");
        set.add(null);
        set.add(null);
        set.add("Java"); // duplicate ignored
        System.out.println(set);
    }
}