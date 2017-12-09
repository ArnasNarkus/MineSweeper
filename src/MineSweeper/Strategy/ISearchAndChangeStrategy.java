package MineSweeper.Strategy;

public interface ISearchAndChangeStrategy {

    public boolean searchAndChange(int x, int y);
    public boolean searchAndChange(int x, int y, char change);

}
