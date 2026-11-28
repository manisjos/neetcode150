public class LC200_viaDFs {
    public static void main(String[] args) {
        char[][] grid = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };
        char[][] grid2 = {
                {'1','1','0','0','1'},
                {'1','0','0','1','1'},
                {'0','0','1','0','0'},
                {'1','0','0','1','1'}
        };


        System.out.println(numIslands(grid));
        System.out.println(numIslands(grid2));
    }

    static int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int n = grid.length;
        int m = grid[0].length;

        boolean[][] visited = new boolean[n][m];
        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    count++;
                    dfs(i, j, visited, grid, n, m);
                }
            }
        }
        return count;
    }

    static void dfs(int i, int j, boolean[][] vis, char[][] grid, int n, int m) {
        if (i < 0 || j < 0 ||
                i >= n || j >= m ||
                vis[i][j] ||
                grid[i][j] == '0'
        )
            return;

        vis[i][j] = true;

        // explore all four directions
        dfs(i - 1, j, vis, grid, n, m); // Top
        dfs(i, j + 1, vis, grid, n, m); // Right
        dfs(i + 1, j, vis, grid, n, m); // Bottom
        dfs(i, j - 1, vis, grid, n, m); // Left

    }
}
