package MineSweeper.Strategy;

import MineSweeper.Grid;

public class SearchAndChangeTopCell implements ISearchAndChangeStrategy {


    private Grid grid;

    public SearchAndChangeTopCell(Grid grid) {
        this.grid = grid;
    }

    @Override
    public boolean searchAndChange(int x, int y) {

        if (((x - 1) >= 0) && ((x - 1) < grid.getBackGrid().length))
            if ((grid.getBackGrid()[x - 1][y] == -1))
                return true;  // Is there a mine above me ?


        return false;
    }
}
/*
1 2 3
4 5 6
7 X 9
*/