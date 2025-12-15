public class Singleton {
    private static Singleton single_instance = null;
    public String s;

    private Singleton() {
        s = "String from Singleton class";
    }

    public static Singleton singleton() {
        if (single_instance == null) {
            single_instance = new Singleton();
        }
        return single_instance;
    }
}
