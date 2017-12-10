package MineSweeper;

public class MinesweeperRenderer  {

    private char[][] renderGrid;


    public MinesweeperRenderer(MinesweeperGrid grid) {
        this.renderGrid = grid.getFrontGrid();
    }



    public void renderGrid(Coordinates pointer) {
        System.out.print("X : " + pointer.getPosX());
        System.out.print(" Y : " + pointer.getPosY());
        System.out.println();

        for (int i = 0; i < renderGrid.length; i++) {
            for (int j = 0; j < renderGrid[i].length; j++) {


                if (i == pointer.getPosX() && j == pointer.getPosY()) { // pointer location
                    System.out.print(String.format(">%1$1s", renderGrid[i][j]) + " ");
                } else {
                    System.out.print(String.format("%1$2s", renderGrid[i][j]) + " ");
                }
            }
            System.out.println();
        }
    }

}
