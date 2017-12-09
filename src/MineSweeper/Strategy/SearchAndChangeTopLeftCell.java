package MineSweeper.Strategy;

import MineSweeper.Grid;

public class SearchAndChangeTopLeftCell implements ISearchAndChangeStrategy {


    private Grid grid;

    public SearchAndChangeTopLeftCell(Grid grid) {
        this.grid = grid;
    }

    @Override
    public boolean searchAndChange(int x, int y) {

        if (((x - 1) >= 0) && ((x - 1) < grid.getBackGrid()[x].length))
            if (((y - 1) >= 0) && ((y - 1) < grid.getBackGrid()[x].length))
                if ((grid.getBackGrid()[x - 1][y - 1] == -1))
                return true;


        return false;
    }
}
