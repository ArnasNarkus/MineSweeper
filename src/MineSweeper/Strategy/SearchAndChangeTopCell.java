package MineSweeper.Strategy;

import MineSweeper.Coordinates;
import MineSweeper.MinesweeperGrid;

public class SearchAndChangeTopCell implements ISearchAndChangeStrategy {


    private MinesweeperGrid grid;

    public SearchAndChangeTopCell(MinesweeperGrid grid) {
        this.grid = grid;
    }

    @Override
    public boolean searchAndChange(int x, int y){

        if (((x - 1) >= 0) && ((x - 1) < grid.getBackGrid().length))
            if ((grid.getBackGrid()[x - 1][y] == -1))
                return true;  // Is there a mine above me ?

        return false;
    }


    @Override
    public void searchAndChange(int x, int y, char searchBy)
    {
        if (x > 0 && (grid.getFrontGrid()[x - 1][y] != searchBy))
            grid.getFrontGrid()[x - 1][y] = (char) (grid.getBackGrid()[x - 1][y] + '0'); // reveal upper num





    }


    @Override
    public Coordinates floodFillSearchAndChange(int x, int y, char searchBy) {
        if ((x + 1) < grid.getBackGrid()[x].length) {
            if ((grid.getBackGrid()[x + 1][y] == 0) && (grid.getFrontGrid()[x + 1][y] != searchBy)) {
                grid.getFrontGrid()[x + 1][y] = searchBy;
                return new Coordinates(x + 1, y);

            }
        }

        return null;
    }




}
