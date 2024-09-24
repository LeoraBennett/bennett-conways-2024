package bennett.gameoflife;

public class GameOfLife {

    private int rows;
    private int cols;
    private int[][] grid;

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }

    public int[][] getGrid() {
        return grid;
    }

    public GameOfLife(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.grid = new int[rows][cols];
    }

    public int getCell(int x, int y) {
        return grid[x][y];
    }
    public void setCell(int row, int col, int value) {
        grid[row][col] = value;
    }

    public void setGrid(int[][] newGrid) {
        this.grid = newGrid;
        this.rows = newGrid.length;
        this.cols = newGrid[0].length;
    }

    public void nextGen() {
        int[][] newGrid = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                int aliveNeighbors = countAliveNeighbors(row, col);

                if (grid[row][col] == 1) {
                    newGrid[row][col] = (aliveNeighbors == 2 || aliveNeighbors == 3) ? 1 : 0;
                } else {
                    newGrid[row][col] = (aliveNeighbors == 3) ? 1 : 0;
                }
            }
        }

        grid = newGrid;
    }

    private int countAliveNeighbors(int row, int col) {
        int count = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                int newRow = row + i;
                int newCol = col + j;

                if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols) {
                    count += grid[newRow][newCol];
                }
            }
        }
        return count;
    }

    public void initFromRle(String rleData) {
        RleParser parser = new RleParser();
        int[][] gridFromRle = parser.parseRle(rleData);
        this.setGrid(gridFromRle);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                builder.append(grid[row][col]);
            }
            builder.append("\n");
        }
        return builder.toString();
    }
}
