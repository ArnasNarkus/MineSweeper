package MineSweeper.gamefactory;


import MineSweeper.MinesweeperGrid;
import MineSweeper.MinesweeperRenderer;
import MineSweeper.PlayerUI;
import MineSweeper.unitTest.DangerIndexBounds;
import MineSweeper.unitTest.MineCountTest;

public class ConsoleGame implements Game {


    public void run() throws Exception {

        MinesweeperGrid grid = new MinesweeperGrid(10, 10, 10);
        PlayerUI player = new PlayerUI();
        MinesweeperRenderer renderer = new MinesweeperRenderer(grid);

        player.getGameInstructions();
        renderer.renderGrid(player.getPointer());

        // Test block
        testing(grid);

        while (!grid.isGameOver()) {
            System.out.println();
            player.move(grid);
            renderer.renderGrid(player.getPointer());
        }
    }

    public void testing (MinesweeperGrid grid){
        System.out.println("Tests called :");
        MineCountTest test = new MineCountTest(grid);
        test.MineCountUnitTest();

        DangerIndexBounds test1 = new DangerIndexBounds(grid);
        test1.DangerIndexBoundsUnitTest();

    }


}

