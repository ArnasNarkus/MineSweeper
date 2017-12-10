package MineSweeper.unitTest;

import MineSweeper.MinesweeperGrid;

public class DangerIndexBounds {



    private MinesweeperGrid grid;

    public DangerIndexBounds(MinesweeperGrid grid) {
        this.grid = grid;
    }


    public void DangerIndexBoundsUnitTest() {

       boolean mistake = false;

        for (int i = 0; i < grid.getBackGrid().length; i++) {
            for (int j = 0; j < grid.getBackGrid().length; j++) {

                if( (grid.getBackGrid()[i][j] < -1 || grid.getBackGrid()[i][j] > 8  ) ){
                    System.out.println("Out of bounds danger index found :");
                    System.out.println("Located at : X = "+i+ " Y = "+j);
                    mistake = true;
                }



            }
        }

        if(!mistake){
            System.out.println("Danger indexes are in correct bounds.");
        }else {
            System.out.println("Out of bounds danger index found printing back grid.");
            grid.printBackGrid();
        }


    }
}
