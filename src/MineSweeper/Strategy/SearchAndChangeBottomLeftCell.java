package MineSweeper.Strategy;

import MineSweeper.Grid;

public class SearchAndChangeBottomLeftCell implements ISearchAndChangeStrategy {


    private Grid grid;

    public SearchAndChangeBottomLeftCell(Grid grid) {
        this.grid = grid;
    }

    @Override
    public boolean searchAndChange(int x, int y) {

        if (((x + 1) >= 0) && ((x + 1) < grid.getBackGrid()[x].length))
            if (((y - 1) >= 0) && ((y - 1) < grid.getBackGrid()[x].length))
                if ((grid.getBackGrid()[x + 1][y - 1] == -1))
                return true;  // Is there a mine above me ?

        return false;
    }

    @Override
    public void searchAndChange(int x, int y, char searchBy) {


        if (((x + 1) < this.grid.getBackGrid()[x].length) && ((y - 1) >= 0) && (grid.getFrontGrid()[x + 1][y - 1] != searchBy))
            grid.getFrontGrid()[x + 1][y - 1] = (char) (grid.getBackGrid()[x + 1][y - 1] + '0'); // reveal bottom left corner num



    }



}
