package MineSweeper.Strategy;

import MineSweeper.Coordinates;
import MineSweeper.MinesweeperGrid;

public class SearchAndChangeBottomCell implements ISearchAndChangeStrategy {


    private MinesweeperGrid grid;

    public SearchAndChangeBottomCell(MinesweeperGrid grid) {
        this.grid = grid;
    }

    @Override
    public boolean searchAndChange(int x, int y) {

        if (((x + 1) >= 0) && ((x + 1) < grid.getBackGrid()[x].length))
            if ((grid.getBackGrid()[x + 1][y] == -1))
                return true;


        return false;
    }

    @Override
    public void searchAndChange(int x, int y, char searchBy) {

        if (((x + 1) < grid.getFrontGrid()[x].length) && (grid.getFrontGrid()[x + 1][y] != searchBy))
            grid.getFrontGrid()[x + 1][y] = (char) (grid.getBackGrid()[x + 1][y] + '0');

    }

    @Override
    public Coordinates floodFillSearchAndChange(int x, int y, char searchBy) {
        if ((x - 1) > 0) {
            if ((grid.getBackGrid()[x - 1][y] == 0) && grid.getFrontGrid()[x - 1][y] != searchBy) {
                grid.getFrontGrid()[x - 1][y] = searchBy;
                return new Coordinates(x - 1, y);

            }
        }
        return null;
    }
}
