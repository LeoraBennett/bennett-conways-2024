package bennett.gameoflife;

import javax.swing.*;
import java.awt.*;

public class GameOfLifeComponent extends JComponent {
    private final GameOfLife gameOfLife;

    public GameOfLifeComponent(GameOfLife gameOfLife) {
        this.gameOfLife = gameOfLife;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int cellSize = 15;

        g.setColor(Color.WHITE);
        g.fillRect(0, 0, getWidth(), getHeight());

        g.setColor(Color.YELLOW);
        for (int row = 0; row < gameOfLife.getRows(); row++) {
            for (int col = 0; col < gameOfLife.getCols(); col++) {
                if (gameOfLife.getCell(row, col) == 1) {
                    g.fillRect(col * cellSize, row * cellSize, cellSize, cellSize);
                }
            }
        }

        g.setColor(Color.BLACK);
        int width = gameOfLife.getCols() * cellSize;
        int height = gameOfLife.getRows() * cellSize;

        for (int col = 0; col <= gameOfLife.getCols(); col++) {
            int x = col * cellSize;
            g.drawLine(x, 0, x, height);
        }

        for (int row = 0; row <= gameOfLife.getRows(); row++) {
            int y = row * cellSize;
            g.drawLine(0, y, width, y);
        }

    }
}
