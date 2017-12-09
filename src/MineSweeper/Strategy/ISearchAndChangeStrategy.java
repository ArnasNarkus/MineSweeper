package MineSweeper.Strategy;

public interface ISearchAndChangeStrategy {

    public boolean searchAndChange(int x, int y);
    public void searchAndChange(int x, int y, char searchBy);

}
