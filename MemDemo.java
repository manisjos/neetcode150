// 1. METASPACE (Method Area): 
// Class metadata, static variables, constant pool, and compiled bytecode of methods are stored here.
public class MemDemo {

    // 2. METASPACE (specifically inside the Class's static data area):
    // Primitive static variables live directly in Metaspace.
    static int staticCounter = 100;

    // 3. METASPACE (reference) + HEAP (actual object):
    // The reference 'staticMessage' is in Metaspace. 
    // The String literal "Hello" is stored in the String Pool (inside the Heap).
    static String staticMessage = "Hello";

    // 4. HEAP (as part of every MemoryDemo object instance):
    // Instance variables belong to the object, so they live on the Heap.
    int instanceId;
    String instanceName;

    // Constructor bytecode -> METASPACE
    public MemDemo(int id, String name) {
        // 'id', 'name', and 'this' parameters -> STACK (inside constructor's stack frame)
        this.instanceId = id;       // Writes value into the object on the HEAP
        this.instanceName = name;   // Copies reference to the String on the HEAP
    }

    // Method bytecode -> METASPACE
    public void processData(int multiplier) {
        // 5. STACK (inside processData's stack frame):
        // Method parameters ('multiplier') and local primitives ('localResult') live on the Stack.
        int localResult = this.instanceId * multiplier;

        // 6. STACK (reference) + HEAP (object):
        // 'tempBuilder' reference is on the Stack.
        // The 'new StringBuilder(...)' object itself is allocated on the Heap.
        StringBuilder tempBuilder = new StringBuilder(this.instanceName);
        tempBuilder.append(" - ").append(localResult);

        System.out.println(tempBuilder.toString());

        // Once processData() finishes, its Stack frame is popped and destroyed.
        // 'multiplier', 'localResult', and 'tempBuilder' reference vanish immediately.
        // The StringBuilder object on the Heap becomes eligible for Garbage Collection.
    }

    // Method bytecode -> METASPACE
    public static void main(String[] args) {
        // 'args' reference -> STACK (main's stack frame)
        // The String[] array object -> HEAP

        // 'localAge' primitive value (25) -> STACK (main's stack frame)
        int localAge = 25;

        // 'demoObj' reference -> STACK (main's stack frame)
        // 'new MemoryDemo(...)' object (and its fields instanceId, instanceName) -> HEAP
        // "Alice" String literal -> HEAP (String Constant Pool)
        MemDemo demoObj = new MemDemo(1, "Alice");

        // Pushes a new frame onto the STACK for processData()
        demoObj.processData(localAge);

        // main() finishes, its Stack frame is popped, and the JVM exits.
    }
}