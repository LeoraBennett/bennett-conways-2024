package bennett.gameoflife;

import java.util.Scanner;

public class RleParser {
    public int[][] parseRle(String rleData) {
        Scanner scanner = new Scanner(rleData);
        int rows = 0;
        int cols = 0;
        StringBuilder pattern = new StringBuilder();

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine().trim();
            if (line.startsWith("#")) {
                continue;
            }
            if (line.startsWith("x")) {
                String[] dimensions = line.split(",");
                cols = Integer.parseInt(dimensions[0].split("=")[1].trim());
                rows = Integer.parseInt(dimensions[1].split("=")[1].trim());
            } else {
                pattern.append(line);
            }
        }

        int[][] grid = new int[100][100];

        int currentRow = 0;
        int currentCol = 0;
        int count = 0;

        for (int i = 0; i < pattern.length(); i++) {
            char ch = pattern.charAt(i);
            if (Character.isDigit(ch)) {
                count = count * 10 + Character.getNumericValue(ch);
            } else {
                if (count == 0) {
                    count = 1;
                }
                switch (ch) {
                    case 'b':
                        currentCol += count;
                        break;
                    case 'o':
                        for (int j = 0; j < count; j++) {
                            grid[currentRow][currentCol++] = 1;
                        }
                        break;
                    case '$':
                        currentRow++;
                        currentCol = 0;
                        break;
                    case '!':
                        break;
                    default:
                        System.out.println("Unexpected character: " + ch);
                        break;
                }
                count = 0;
            }
        }

        int rowOffset = (100 - rows) / 2;
        int colOffset = (100 - cols) / 2;

        int[][] centeredGrid = new int[100][100];
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                centeredGrid[row + rowOffset][col + colOffset] = grid[row][col];
            }
        }

        return centeredGrid;
    }
}
