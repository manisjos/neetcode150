import java.util.Arrays;
import java.util.List;

public class TopKScenarioBased {
    public static void main(String[] args) {

        LogProcessor processor = new LogProcessor();
        List<String> logs = Arrays.asList(
                "100:userA:LOGIN", "101:userB:LOGIN", "102:userA:LOGIN",
                "103:userC:LOGIN", "104:userB:LOGIN", "105:userA:LOGOUT"
        );

        System.out.println(processor.getTopKUsers(logs, "LOGIN", 2));
        // Expected Output: [userA, userB]
    }
}
