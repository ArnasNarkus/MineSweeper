package MineSweeper.Strategy;

import MineSweeper.Grid;

public class SearchAndChangeRightCell implements ISearchAndChangeStrategy {


    private Grid grid;

    public SearchAndChangeRightCell(Grid grid) {
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
    public boolean searchAndChange(int x, int y, char change) {
        return false;
    }


}
