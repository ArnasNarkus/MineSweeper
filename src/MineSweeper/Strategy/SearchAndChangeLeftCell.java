package MineSweeper.Strategy;

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
    public boolean searchAndChange(int x, int y, char change) {
        return false;
    }


}
