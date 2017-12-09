package MineSweeper.Strategy;

import MineSweeper.Grid;

public class SearchAndChangeTopRightCell implements ISearchAndChangeStrategy {


    private Grid grid;

    public SearchAndChangeTopRightCell(Grid grid) {
        this.grid = grid;
    }

    @Override
    public boolean searchAndChange(int x, int y) {

        if (((x - 1) >= 0) && ((x - 1) < grid.getBackGrid().length))
            if (((y + 1) >= 0) && ((y + 1) < grid.getBackGrid().length))
                if ((grid.getBackGrid()[x - 1][y + 1] == -1))
                return true;


        return false;
    }


    @Override
    public boolean searchAndChange(int x, int y, char change) {
        return false;
    }


}
