public class LC2596_KnightsMove {
    public static void main(String[] args) {

        int[][] grid = {
                {0, 11, 16, 5, 20},
                {17, 4, 19, 10, 15},
                {12, 1, 8, 21, 6},
                {3, 18, 23, 14, 9},
                {24, 13, 2, 7, 22}
        };

        System.out.println("If the grid is valid for knights traversal ? : " + checkValidGrid(grid));
    }

    static boolean checkValidGrid(int[][] grid) {
        int gridSize = grid.length;

        // Step 1: Map each number to its (row, col) position
        // positionMap[number] = {row,col}
        int[][] positionMap = new int[gridSize * gridSize][2];

        for (int row = 0; row < gridSize; row++) {
            for (int col = 0; col < gridSize; col++) {
                int stepNumber = grid[row][col];
                positionMap[stepNumber][0] = row;
                positionMap[stepNumber][1] = col;
            }
        }

        // Step 2: Ensure the knight starts from top-left corner 0,0
        if (positionMap[0][0] != 0 || positionMap[0][1] != 0) {
            return false;
        }

        // Step 3: Validate each move from step 0 --> step n^2 - 1
        for (int currStep = 1; currStep < gridSize * gridSize; currStep++) {

            // prev step position
            int prevRow = positionMap[currStep - 1][0];
            int prevCol = positionMap[currStep - 1][1];

            // current steo position
            int currRow = positionMap[currStep][0];
            int currCol = positionMap[currStep][1];

            // calculate row and col difference
            int rowDiff = Math.abs(prevRow - currRow);
            int colDiff = Math.abs(prevCol - currCol);

            // check if this is a valid knight move
            boolean isKnightMove =
                    (rowDiff == 2 && colDiff == 1) ||
                            (rowDiff == 1 && colDiff == 2);

            if (!isKnightMove) {
                return false;
            }
        }
        // all moves are valid
        return true;
    }

}
