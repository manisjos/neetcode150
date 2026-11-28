import java.util.*;

public class DFSEx {

    static void dfs(Map<Integer, List<Integer>> graph,
                    int curr,
                    Set<Integer> visited) {
        visited.add(curr);
        System.out.println(curr + " ");
        for (int neighbour : graph.getOrDefault(curr,
                Collections.emptyList())) {
            if (!visited.contains(neighbour)) {
                dfs(graph, neighbour, visited);
            }
        }
    }

    public static void main(String[] args) {
        Map<Integer, List<Integer>> graph =
                new HashMap<>();
        graph.put(1, Arrays.asList(2, 3));
        graph.put(2, Arrays.asList(4, 5));
        graph.put(3, Arrays.asList(6, 7));

        graph.put(4, Collections.emptyList());
        graph.put(5, Collections.emptyList());
        graph.put(6, Collections.emptyList());
        graph.put(7, Collections.emptyList());

        dfs(graph, 1, new HashSet<>());
    }
}
