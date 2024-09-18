package bennett.gameoflife;

import javax.swing.*;
import java.awt.*;

public class GameOfLifeFrame extends JFrame {
    private final GameOfLife gameOfLife = new GameOfLife(40, 40);
    private Timer timer;

    public GameOfLifeFrame() {
        setSize(800, 600);
        setTitle("Game Of Life");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        GameOfLifeComponent gameComponent = new GameOfLifeComponent(gameOfLife);
        add(gameComponent, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        add(buttonPanel, BorderLayout.SOUTH);

        JButton startButton = new JButton("Start");
        JButton stopButton = new JButton("Stop");

        buttonPanel.add(startButton);
        buttonPanel.add(stopButton);

        timer = new Timer(1000, e -> {
            gameOfLife.nextGen();
            gameComponent.repaint();
        });

        startButton.addActionListener(e -> timer.start());
        stopButton.addActionListener(e -> timer.stop());

        gliderPattern();
        gameComponent.repaint();
    }

    private void gliderPattern() {
        gameOfLife.setCell(1, 0, 1);
        gameOfLife.setCell(2, 1, 1);
        gameOfLife.setCell(0, 2, 1);
        gameOfLife.setCell(1, 2, 1);
        gameOfLife.setCell(2, 2, 1);
    }
}
