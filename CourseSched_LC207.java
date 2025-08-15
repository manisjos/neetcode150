import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class CourseSched_LC207 {
    public static void main(String[] args) {
        int numCourses = 2;
        int preReq[][] = {{1, 0}};
        System.out.println("Course I can take ? " + canFinish(numCourses, preReq));
    }

    public static boolean canFinish(int numCourses, int[][] preReq) {
        // Step 1: Build adjacency list for the graph
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] pre : preReq) {
            graph.get(pre[1]).add(pre[0]);
        }

        // 0 = not visited, 1 = visiting, 2 = visited
        int[] visited = new int[numCourses];

        // Step 2: DFS to detect cycles
        for (int i = 0; i < numCourses; i++) {
            if (dfs(graph, visited, i)) {
                return false;
            }
        }
        return true;
    }

    private static boolean dfs(List<List<Integer>> graph, int[] visited, int course) {
        if (visited[course] == 1) return true;
        if (visited[course] == 2) return false;
        visited[course] = 1;
        for (int nextCourse : graph.get(course)) {
            if (dfs(graph, visited, nextCourse)) return true;
        }
        visited[course] = 2;
        return false;
    }
}
