import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LogProcessor {
    List<String> getTopKUsers(List<String> logs, String targetAction, int k) {


        return logs.stream()

                .filter(log->log.split(":")[2].equals(targetAction))
        .map(log->log.split(":")[1])

                .collect(Collectors.groupingBy(u->u,Collectors.counting()))
                .entrySet().stream()
                .sorted((e1, e2) -> {
                    int freqCompare = e2.getValue().compareTo(e1.getValue()); // Descending frequency
                    if (freqCompare == 0) {
                        return e1.getKey().compareTo(e2.getKey()); // Ascending ID on tie
                    }
                    return freqCompare;
                })

                // 4. Limit to k and collect the keys
                .limit(k)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

}
