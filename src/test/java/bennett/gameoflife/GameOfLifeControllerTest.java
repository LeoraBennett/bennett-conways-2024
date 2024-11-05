package bennett.gameoflife;

import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class GameOfLifeControllerTest {

    private static final String GLIDER_RLE = """
                #N Glider
                #O Richard K. Guy
                #C The smallest, most common, and first discovered spaceship. Diagonal, has period 4 and speed c/4.
                #C www.conwaylife.com/wiki/index.php?title=Glider
                x = 3, y = 3, rule = B3/S23
                bob$2bo$3o!
            """.trim().replace("\n", "\r\n") + "\r\n";

    @Test
    void toggleCellOn() {
        // given
        GameOfLife model = mock();
        GameOfLifeComponent view = mock();
        GameOfLifeController controller = new GameOfLifeController(model, view);
        doReturn(10).when(view).getCellSize();
        doReturn(100).when(model).getRows();
        doReturn(100).when(model).getCols();
        doReturn(0).when(model).getCell(5, 10);

        // when
        controller.toggleCell(50, 100);

        // then
        verify(model).setCell(5, 10, 1);
        verify(view).repaint();

    }

    @Test
    void toggleCellOff() {
        // given
        GameOfLife model = mock();
        GameOfLifeComponent view = mock();
        GameOfLifeController controller = new GameOfLifeController(model, view);
        doReturn(10).when(view).getCellSize();
        doReturn(100).when(model).getRows();
        doReturn(100).when(model).getCols();
        doReturn(1).when(model).getCell(5, 10);

        // when
        controller.toggleCell(50, 100);

        // then
        verify(model).setCell(5, 10, 0);
        verify(view).repaint();
    }

    @Test
    void pasteFromRle() {
        // given
        GameOfLife model = mock();
        GameOfLifeComponent view = mock();
        GameOfLifeController controller = new GameOfLifeController(model, view);
        String rle = "";

        // when
        controller.pasteFromClipboard(rle);

        // then
        verify(model).parseRle("");
        verify(view).repaint();
    }
}