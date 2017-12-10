package MineSweeper;

import MineSweeper.Strategy.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MinesweeperGrid {

    private static final char REVELED_UNIT = '_';
    private static final char HIDDEN_UNIT = '+';
    private static final char MINE_UNIT = '*';
    private static final int MINE_NUM = -1;
    private static final int EMPTY_CELL_NUM = 0;


    private List<ISearchAndChangeStrategy> searchAndChangeStrategies = new ArrayList<>();
    private int xLen;
    private int yLen;
    private int mineCount;
    private char[][] frontGrid;
    private int[][] backGrid;
    private boolean gameOver = false;


    public MinesweeperGrid(int xLen, int yLen, int mineCount) {
        this.xLen = xLen;
        this.yLen = yLen;
        this.mineCount = mineCount;
        this.frontGrid = new char[xLen][yLen];
        this.backGrid = new int[xLen][yLen];


        this.searchAndChangeStrategies.add(new SearchAndChangeTopCell(this));
        this.searchAndChangeStrategies.add(new SearchAndChangeBottomCell(this));
        this.searchAndChangeStrategies.add(new SearchAndChangeLeftCell(this));
        this.searchAndChangeStrategies.add(new SearchAndChangeRightCell(this));
        this.searchAndChangeStrategies.add(new SearchAndChangeTopLeftCell(this));
        this.searchAndChangeStrategies.add(new SearchAndChangeTopRightCell(this));
        this.searchAndChangeStrategies.add(new SearchAndChangeBottomLeftCell(this));
        this.searchAndChangeStrategies.add(new SearchAndChangeBottomRightCell(this));

        createGrid();
    }

    private void createGrid() {
        createFrontGrid();
        placeMines();
        insertDangerIndexes();
    }

    private void createFrontGrid() {
        for (int i = 0; i < this.frontGrid.length; i++) {
            for (int j = 0; j < this.frontGrid[i].length; j++) {
                this.frontGrid[i][j] = HIDDEN_UNIT;
            }
        }
    }

    private void placeMines() {
        int randX;
        int randY;
        int minesPlaced = 0;
        do { // not place mine on top of another mine
            randX = (int) (Math.random() * this.xLen);
            randY = (int) (Math.random() * this.yLen);
            if (this.backGrid[randX][randY] == EMPTY_CELL_NUM) {
                this.backGrid[randX][randY] = MINE_NUM;
                minesPlaced++;
            }
        } while (minesPlaced != getMineCount());
    }

    private void insertDangerIndexes() {

        int dangerIndex = 0;

        for (int x = 0; x < this.backGrid.length; x++) {
            for (int y = 0; y < this.backGrid[x].length; y++) {

                if (this.backGrid[x][y] != MINE_NUM) { // Do i stand on the mine ?

                    for (ISearchAndChangeStrategy strategy : searchAndChangeStrategies) {
                        if (strategy.searchAndChange(x, y)) {
                            dangerIndex++;
                        }
                    }

                    this.backGrid[x][y] = dangerIndex;
                    dangerIndex = 0;
                }
            }
        }
    }





    public void printBackGrid() {

        for (int i = 0; i < this.backGrid.length; i++) {
            for (int j = 0; j < this.backGrid[i].length; j++) {
                System.out.print(String.format("%1$2s", this.backGrid[i][j]) + " ");
            }
            System.out.println();
        }
    }



    public boolean isGameOver() {
        return gameOver;
    }

    public void reveal(Coordinates pointer) {
        int x = pointer.getPosX();
        int y = pointer.getPosY();

        switch (this.backGrid[x][y]) {

            case MINE_NUM:
                System.out.println("IGame over");
                this.frontGrid[x][y] = MINE_UNIT;
                gameOver();
                break;

            case EMPTY_CELL_NUM:
                this.frontGrid[x][y] = REVELED_UNIT;
                cascadeReveal(new Coordinates(pointer.getPosX(), pointer.getPosY()) );
                revealNumbers();
                break;

            default:
                this.frontGrid[x][y] = (char) (this.backGrid[x][y] + 48);
        }


    }


    void gameOver() {
        this.gameOver = true;
        this.printBackGrid();
    }


    private void revealNumbers() {

        for (int i = 0; i < this.frontGrid.length; i++) {
            for (int j = 0; j < this.frontGrid[i].length; j++) {

                if (frontGrid[i][j] == REVELED_UNIT) {

                    for (ISearchAndChangeStrategy strategy : searchAndChangeStrategies) {
                        strategy.searchAndChange(i, j, REVELED_UNIT);
                    }
                }
            }
        }
    }


    private void cascadeReveal(Coordinates initCord) {
        LinkedList<Coordinates> floodFillReveal = new LinkedList<>();

        for (ISearchAndChangeStrategy strategy : searchAndChangeStrategies) {
            floodFillReveal.add( strategy.floodFillSearchAndChange(initCord.getPosX(),initCord.getPosY(), REVELED_UNIT));
        }

        for (Coordinates aFloodFillReveal : floodFillReveal) {
            if (aFloodFillReveal != null) { cascadeReveal(aFloodFillReveal); }
        }
    }


    public int getXLen() {
        return xLen;
    }

    public int getYLen() {
        return yLen;
    }

    public int getMineCount() {
        return mineCount;
    }

    public int[][] getBackGrid() {
        return backGrid;
    }

    public char[][] getFrontGrid() {return frontGrid; }
}
