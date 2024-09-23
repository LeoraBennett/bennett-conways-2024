package bennett.gameoflife;

import java.util.Scanner;

public class RleParser {

    public GameOfLife parseRle(String rleData) {
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

        GameOfLife game = new GameOfLife(rows, cols);

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
                            game.setCell(currentRow, currentCol, 1);
                            currentCol++;
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

        return game;
    }
}