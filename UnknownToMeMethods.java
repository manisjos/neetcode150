import java.util.HashMap;
import java.util.Map;

public class UnknownToMeMethods {
    public static void main(String[] args) {

        Map<String, Integer> fridge = new HashMap<>();
        fridge.put("Milk", 1); // 1 bottle
        fridge.put("Eggs", 12); // 12 eggs

        System.out.println("Initial fridge: " + fridge);

        // 1️⃣ computeIfAbsent → Add only if missing
        fridge.computeIfAbsent("Butter", k -> 2); // Add 2 packs of butter
        fridge.computeIfAbsent("Milk", k -> 99); // Does nothing (Milk already exists)
        System.out.println("After computeIfAbsent: " + fridge);

        // 2️⃣ computeIfPresent → Update only if present
        fridge.computeIfPresent("Eggs", (k, v) -> v + 6); // Add 6 eggs to existing eggs
        fridge.computeIfPresent("Juice", (k, v) -> v + 1); // Does nothing (Juice not there)
        System.out.println("After computeIfPresent: " + fridge);

        // 3️⃣ compute → Always check and decide
        fridge.compute("Milk", (k, v) -> (v == null) ? 3 : v - 1); // Drink 1 milk
        fridge.compute("Juice", (k, v) -> (v == null) ? null : v + 1); // Add juice if missing
        fridge.compute("Butter", (k, v) -> null); // Returning null removes butter
        System.out.println("After compute: " + fridge);

        fridge.compute("Milk", (k, v) -> (v == 0) ? v + 3 : v - 1);
        fridge.compute("Juice", (k, v) -> (v == 0) ? 10 : v+100);


        System.out.println("After compute: Check " + fridge);
    }
}

