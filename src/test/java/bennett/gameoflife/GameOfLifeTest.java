package bennett.gameoflife;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;


class GameOfLifeTest {

    @Test
    public void nextGen() {
        // given
        GameOfLife game = new GameOfLife(5, 5);
        game.setGrid(new int[][]{
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 1, 1, 1, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0}
        });
        // when
        game.nextGen();
        String actual = game.toString();

        // then
        String expected = "00000\n"
                + "00100\n"
                + "00100\n"
                + "00100\n"
                + "00000\n";
        assertEquals(expected, actual);
    }
}