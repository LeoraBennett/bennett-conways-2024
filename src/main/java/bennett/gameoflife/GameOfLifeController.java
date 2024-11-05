package bennett.gameoflife;

import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import javax.swing.Timer;

public class GameOfLifeController {
    private GameOfLife model;
    private GameOfLifeComponent view;
    private Timer timer;

    public GameOfLifeController(GameOfLife model, GameOfLifeComponent view) {
        this.model = model;
        this.view = view;
    }

    public void startTimer() {
        if (timer == null || !timer.isRunning()) {
            timer = new Timer(1000,
                    e -> {
                        model.nextGen();
                        view.repaint();
                    });
            timer.start();
        }
    }
    public void stopTimer() {
        if (timer != null && timer.isRunning()) {
            timer.stop();
        }
    }

    public void toggleCell(int screenX, int screenY) {
        int x = screenX / view.getCellSize();
        int y = screenY / view.getCellSize();

        if (x < model.getRows() && y < model.getCols()) {
            int currentState = model.getCell(x, y);
            model.setCell(x, y, currentState == 1 ? 0 : 1);
            view.repaint();
        }
    }

    public void pasteFromClipboard(String clipboardContent){
        try {
            if (clipboardContent.startsWith("http://") || clipboardContent.startsWith("https://")) {
                InputStream in = new URL(clipboardContent).openStream();
                String rleData = IOUtils.toString(in, StandardCharsets.UTF_8);
                model.parseRle(rleData);
            } else if (new File(clipboardContent).exists()) {
                FileInputStream fisTargetFile = new FileInputStream((new File(clipboardContent)));
                String rleData = IOUtils.toString(fisTargetFile, StandardCharsets.UTF_8);
                model.parseRle(rleData);
            } else {
                model.parseRle(clipboardContent);
            }
            view.repaint();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
