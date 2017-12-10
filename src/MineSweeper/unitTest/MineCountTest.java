package MineSweeper.unitTest;

import MineSweeper.MinesweeperGrid;

public class MineCountTest {

    private MinesweeperGrid grid;

    public MineCountTest(MinesweeperGrid grid) {
        this.grid = grid;
    }


    public void MineCountUnitTest() {

        int actualMineCount = 0;

        for (int i = 0; i < grid.getBackGrid().length; i++) {
            for (int j = 0; j < grid.getBackGrid().length; j++) {

                if (grid.getBackGrid()[i][j] == -1)
                    actualMineCount++;
            }
        }

        if(actualMineCount == this.grid.getMineCount()){
            System.out.println("Mine generated successfully");
        }else {
            System.out.println("Mine count is not what was expected :");
            System.out.println("Expected = "+ this.grid.getMineCount() + " Actual =" + actualMineCount);
        }

    }


}
