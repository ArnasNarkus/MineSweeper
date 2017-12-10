package MineSweeper.Strategy;

import MineSweeper.Coordinates;
import MineSweeper.MinesweeperGrid;

public class SearchAndChangeBottomRightCell implements ISearchAndChangeStrategy {


    private MinesweeperGrid grid;

    public SearchAndChangeBottomRightCell(MinesweeperGrid grid) {
        this.grid = grid;
    }

    @Override
    public boolean searchAndChange(int x, int y) {

        if (((x + 1) >= 0) && ((x + 1) < grid.getBackGrid().length))
            if (((y + 1) >= 0) && ((y + 1) < grid.getBackGrid().length))
                if ((grid.getBackGrid()[x + 1][y + 1] == -1))
                    return true;  // Is there a mine above me ?


        return false;
    }

    @Override
    public void searchAndChange(int x, int y, char searchBy) {


        if (((x + 1) < grid.getBackGrid()[x].length) && ((y + 1) < grid.getBackGrid()[x].length) && (grid.getFrontGrid()[x + 1][y + 1] != searchBy))
            grid.getFrontGrid()[x + 1][y + 1] = (char) (grid.getBackGrid()[x + 1][y + 1] + '0'); // reveal  bottom right corner num


    }

    @Override
    public Coordinates floodFillSearchAndChange(int x, int y, char searchBy) {
                if (((x - 1) >= 0) && ((x - 1) < grid.getBackGrid()[x].length))
            if (((y + 1) >= 0) && ((y + 1) < grid.getBackGrid()[x].length))
                if ((grid.getBackGrid()[x - 1][y + 1] == 0) &&  grid.getFrontGrid()[x - 1][y + 1] != searchBy) {
                    grid.getFrontGrid()[x - 1][y + 1] = searchBy; // Is there a mine upper right corner ?
                    return new Coordinates(x - 1, y + 1);
                }

                return null;
    }

}
