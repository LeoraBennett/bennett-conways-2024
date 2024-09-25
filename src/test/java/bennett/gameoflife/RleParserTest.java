package bennett.gameoflife;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RleParserTest {
    @Test
    public void rleParser() {
        // given
        String rleData = """
                   #C This is a glider.
                   x = 3, y = 3
                   bo$2bo$3o!
                """;

        RleParser parser = new RleParser();

        // when
        int[][] parsedGrid = parser.parseRle(rleData);
        GameOfLife game = new GameOfLife(3, 3);
        game.setGrid(parsedGrid);

        // then
        int[][] expectedGrid = {
                {0, 1, 0},
                {0, 0, 1},
                {1, 1, 1}
        };

        assertArrayEquals(expectedGrid, game.getGrid(),
                "The grid should match the expected parsed glider pattern.");
    }
}