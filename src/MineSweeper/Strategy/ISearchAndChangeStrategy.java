package MineSweeper.Strategy;

import MineSweeper.Coordinates;

public interface ISearchAndChangeStrategy {

    public boolean searchAndChange(int x, int y);
    public void searchAndChange(int x, int y, char searchBy);
    public Coordinates floodFillSearchAndChange(int x,int y, char searchBy);

}
