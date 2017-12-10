package MineSweeper.gamefactory;


import MineSweeper.MinesweeperGrid;
import MineSweeper.MinesweeperRenderer;
import MineSweeper.Player;

public class ConsoleGame implements Game {


    public void run() throws Exception {

        MinesweeperGrid grid = new MinesweeperGrid(10, 10, 10);
        Player player = new Player();
        MinesweeperRenderer renderer = new MinesweeperRenderer(grid);

        renderer.renderGrid(player.getPointer());

        while (!grid.isGameOver()) {
            System.out.println();
            player.move(grid);
            renderer.renderGrid(player.getPointer());
        }
    }
    }

