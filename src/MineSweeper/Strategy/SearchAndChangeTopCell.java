package MineSweeper.Strategy;

import MineSweeper.Grid;

public class SearchAndChangeTopCell implements ISearchAndChangeStrategy {


    private Grid grid;

    public SearchAndChangeTopCell(Grid grid) {
        this.grid = grid;
    }

    @Override
    public boolean searchAndChange(int x, int y){

        if (((x - 1) >= 0) && ((x - 1) < grid.getBackGrid().length))
            if ((grid.getBackGrid()[x - 1][y] == -1))
                return true;  // Is there a mine above me ?

        return false;
    }


    @Override
    public boolean searchAndChange(int x, int y, char change) {
        return false;
    }





}
