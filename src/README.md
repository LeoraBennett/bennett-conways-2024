# Conway's Game of Life
Conway's Game of Life is a cellular automaton
devised by the British mathematician John Horton Conway in 1970.
The game consists of a grid of cells, where each cell can be either
"alive" or "dead." The game evolves over time based on a set of
simple rules, leading to various patterns and behaviors.

This project is a graphical implementation of Conway's Game of Life in Java.
The game allows users to simulate the evolution of cells over multiple generations.

## Rules of Conway's Game of Life
The evolution of the grid follows these rules:

1. Any live cell with fewer than two live neighbors dies (underpopulation).
2. Any live cell with two or three live neighbors lives on to the next generation.
3. Any live cell with more than three live neighbors dies (overpopulation).
4. Any dead cell with exactly three live neighbors becomes a live cell (reproduction).

## Features
* Interactive Controls: Start and stop the simulation.
* Cellular Automaton Rules: Cells are updated according to Conway's
  Game of Life rules.
* Graphical Display: The grid is drawn on the screen with live and
  dead cells visualized.

![Conways_Image Frame](img_1.png)