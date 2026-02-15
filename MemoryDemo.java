public class MemoryDemo {
    // 1. STATIC FIELD: Stored in METASPACE (Class Metadata)
    // Shared by ALL instances of MemoryDemo.
    private static String appName = "InventorySystem";

    // 2. INSTANCE FIELD: Stored on HEAP
    // Each 'new MemoryDemo()' gets its own copy.
    private int id;

    // 3. STATIC METHOD: Stored in METASPACE
    // The code for the method is loaded once.
    public static void printAppName() {
        // Can only access static fields directly
        System.out.println(appName);
    }

    public void processData(int input) {
        // 4. LOCAL VARIABLE: Stored on STACK
        int result = input * 2;

        // 5. STATIC ACCESS: Points to METASPACE
        System.out.println("Running in: " + appName);
    }
}