package MineSweeper.Strategy;

import MineSweeper.Coordinates;
import MineSweeper.Grid;

public class SearchAndChangeLeftCell implements ISearchAndChangeStrategy {


    private Grid grid;

    public SearchAndChangeLeftCell(Grid grid) {
        this.grid = grid;
    }

    @Override
    public boolean searchAndChange(int x, int y) {

        if (((y - 1) >= 0) && ((y - 1) < grid.getBackGrid().length))
            if ((grid.getBackGrid()[x][y - 1] == -1))
                return true;  // left of me


        return false;
    }

    @Override
    public void searchAndChange(int x, int y, char searchBy) {

        if (((y - 1) > 0) && (grid.getFrontGrid()[x][y - 1] != searchBy))
            grid.getFrontGrid()[x][y - 1] = (char) (grid.getBackGrid()[x][y - 1] + '0'); // reveal left num


    }

    @Override
    public Coordinates floodFillSearchAndChange(int x, int y, char searchBy) {

        if (((y - 1) >= 0) && ((y - 1) < grid.getBackGrid()[x].length))
            if ((grid.getBackGrid()[x][y - 1] == 0) && grid.getFrontGrid()[x][y - 1] != searchBy) {
                grid.getFrontGrid()[x][y - 1] = searchBy; // Is there a mine to the left of me ?
               return  new Coordinates(x, y - 1);

            }
        return null;
    }



}
