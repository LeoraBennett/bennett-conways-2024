package bennett.gameoflife;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.ActionEvent;
import java.io.IOException;


public class GameOfLifeFrame extends JFrame {
    GameOfLife gameOfLife = new GameOfLife(1000, 1000);
    GameOfLifeComponent gameOfLifeComponent = new GameOfLifeComponent(gameOfLife);
    GameOfLifeController gameOfLifeController = new GameOfLifeController(gameOfLife, gameOfLifeComponent);

    gameOfLifeComponent.add

    public GameOfLifeFrame() {
        setSize(1000, 1000);
        setTitle("Game Of Life");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        add(gameOfLifeComponent, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        add(buttonPanel, BorderLayout.SOUTH);

        JButton startButton = new JButton("Start");
        JButton stopButton = new JButton("Stop");
        JButton pasteButton = new JButton("Paste");

        buttonPanel.add(startButton);
        buttonPanel.add(stopButton);
        buttonPanel.add(pasteButton);

        startButton.addActionListener((ActionEvent e) -> {
            gameOfLifeController.startTimer();
        });

        stopButton.addActionListener((ActionEvent e) -> {
        gameOfLifeController.stopTimer();
        });

        pasteButton.addActionListener((ActionEvent e) -> {
            try {
                String clipboardContent = (String) Toolkit.getDefaultToolkit()
                        .getSystemClipboard()
                        .getData(DataFlavor.stringFlavor);
                gameOfLifeController.pasteFromClipboard(clipboardContent);
            } catch (UnsupportedFlavorException ex) {
                throw new RuntimeException(ex);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
        buttonPanel.add(pasteButton);
    }
}

