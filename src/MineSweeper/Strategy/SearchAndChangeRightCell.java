package MineSweeper.Strategy;

import MineSweeper.Coordinates;
import MineSweeper.MinesweeperGrid;

public class SearchAndChangeRightCell implements ISearchAndChangeStrategy {


    private MinesweeperGrid grid;

    public SearchAndChangeRightCell(MinesweeperGrid grid) {
        this.grid = grid;
    }

    @Override
    public boolean searchAndChange(int x, int y) {

        if (((y + 1) >= 0) && ((y + 1) < grid.getBackGrid()[x].length))
            if ((grid.getBackGrid()[x][y + 1] == -1))
                return true;  // Is there a mine above me ?


        return false;
    }

    @Override
    public void searchAndChange(int x, int y, char searchBy) {


        if (((y + 1) < grid.getBackGrid()[x].length) && (grid.getFrontGrid()[x][y + 1] != searchBy))
            grid.getFrontGrid()[x][y + 1] = (char) (grid.getBackGrid()[x][y + 1] + '0'); // reveal right num


    }

    @Override
    public Coordinates floodFillSearchAndChange(int x, int y, char searchBy) {

        if (((y + 1) >= 0) && ((y + 1) < grid.getBackGrid()[x].length))
            if ((grid.getBackGrid()[x][y + 1] == 0) && grid.getFrontGrid()[x][y + 1] != searchBy) {
                grid.getFrontGrid()[x][y + 1] = searchBy; // Is there a mine to rhe right of me ?
                return new Coordinates(x, y + 1);

            }
return null;

    }
}
