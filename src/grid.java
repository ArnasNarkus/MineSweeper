import java.util.LinkedList;

public class grid {


    private static final char reveledUnit = '_';
    private static final char hiddenUnit = '+';
    private static final char mineUnit = '*';


    private int xLen;
    private int yLen;
    private int mineCount;
    private char[][] frontGrid;
    private int[][] backGrid;
    private boolean gameOver = false;


    public grid(int xLen, int yLen, int mineCount) {
        this.xLen = xLen;
        this.yLen = yLen;
        this.mineCount = mineCount;
        this.frontGrid = new char[xLen][yLen];
        this.backGrid = new int[xLen][yLen];
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
                this.frontGrid[i][j] = hiddenUnit;
            }
        }
    }

    private void placeMines() {
        int randX = 0;
        int randY = 0;
        int minesPlaced = 0;
        do { // not place mine on another mine
            randX = (int) (Math.random() * this.xLen);
            randY = (int) (Math.random() * this.yLen);
            if (this.backGrid[randX][randY] == 0) {
                this.backGrid[randX][randY] = -1;
                minesPlaced++;
            }
        } while (minesPlaced != getMineCount());

    }

    private void insertDangerIndexes() {

        int dangerIndex = 0;

        for (int i = 0; i < this.backGrid.length; i++) {
            for (int j = 0; j < this.backGrid[i].length; j++) {

                if (this.backGrid[i][j] != -1) { // Do i stand on the mine ?

                    if (((i - 1) >= 0) && ((i - 1) < this.backGrid[i].length))
                        if ((this.backGrid[i - 1][j] == -1))
                            dangerIndex++;  // Is there a mine above me ?

                    if (((i + 1) >= 0) && ((i + 1) < this.backGrid[i].length))
                        if ((this.backGrid[i + 1][j] == -1))
                            dangerIndex++; // Is there a mine bellow me ?

                    if (((j - 1) >= 0) && ((j - 1) < this.backGrid[i].length))
                        if ((this.backGrid[i][j - 1] == -1))
                            dangerIndex++; // Is there a mine to the left of me ?

                    if (((j + 1) >= 0) && ((j + 1) < this.backGrid[i].length))
                        if ((this.backGrid[i][j + 1] == -1))
                            dangerIndex++; // Is there a mine to rhe right of me ?

                    if (((i - 1) >= 0) && ((i - 1) < this.backGrid[i].length))
                        if (((j - 1) >= 0) && ((j - 1) < this.backGrid[i].length))
                            if ((this.backGrid[i - 1][j - 1] == -1))
                                dangerIndex++; // Is there a mine upper left corner ?

                    if (((i - 1) >= 0) && ((i - 1) < this.backGrid[i].length))
                        if (((j + 1) >= 0) && ((j + 1) < this.backGrid[i].length))
                            if ((this.backGrid[i - 1][j + 1] == -1))
                                dangerIndex++; // Is there a mine upper right corner ?

                    if (((i + 1) >= 0) && ((i + 1) < this.backGrid[i].length))
                        if (((j - 1) >= 0) && ((j - 1) < this.backGrid[i].length))
                            if ((this.backGrid[i + 1][j - 1] == -1))
                                dangerIndex++; // Is there a mine bottom left corner ?

                    if (((i + 1) >= 0) && ((i + 1) < this.backGrid[i].length))
                        if (((j + 1) >= 0) && ((j + 1) < this.backGrid[i].length))
                            if ((this.backGrid[i + 1][j + 1] == -1))
                                dangerIndex++; // Is there a mine bottom right corner ?

                    this.backGrid[i][j] = dangerIndex;
                    dangerIndex = 0;
                }
            }
        }
    }


    public void renderGrid(Coordinates pointer) {


        System.out.print("X : " + pointer.getPosX());
        System.out.print(" Y : " + pointer.getPosY());
        System.out.println();

        for (int i = 0; i < this.frontGrid.length; i++) {
            for (int j = 0; j < this.frontGrid[i].length; j++) {


                if (i == pointer.getPosX() && j == pointer.getPosY()) { // pointer location
                    System.out.print(String.format(">%1$1s", this.frontGrid[i][j]) + " ");
                } else {
                    System.out.print(String.format("%1$2s", this.frontGrid[i][j]) + " ");
                }
            }
            System.out.println();
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

            case -1:
                System.out.println("Game over");
                this.frontGrid[x][y] = mineUnit;
                gameOver();
                break;

            case 0:
                this.frontGrid[x][y] = reveledUnit;
                cascadeReveal(pointer.getPosX(), pointer.getPosY());
                revealNumbers();
                break;

            default:
                this.frontGrid[x][y] = (char) (this.backGrid[x][y] + 48);
        }


    }


    void gameOver (){
        this.gameOver = true;
        this.printBackGrid();
    }



    private void revealNumbers() {
        System.out.println("revealing");
        for (int i = 0; i < this.frontGrid.length; i++) {
            for (int j = 0; j < this.frontGrid[i].length; j++) {

                if (frontGrid[i][j] == reveledUnit) {

                    if (i > 0 && (frontGrid[i - 1][j] != reveledUnit))
                        frontGrid[i - 1][j] = (char) (backGrid[i - 1][j] + '0'); // reveal upper num


                    if ( ( (i + 1) < frontGrid[i].length) && (frontGrid[i + 1][j] != reveledUnit) )
                        frontGrid[i + 1][j] = (char) (backGrid[i + 1][j] + '0'); // reveal bottom num


                    if ( ( (j - 1) > 0 )   && (frontGrid[i][j-1] != reveledUnit))
                        frontGrid[i][j-1] = (char) (backGrid[i][j-1] + '0'); // reveal left num


                    if (  ((j + 1) < this.backGrid[i].length)  && (frontGrid[i][j+1] != reveledUnit) )
                        frontGrid[i][j+1] = (char) (backGrid[i][j+1] + '0'); // reveal right num


                    if (((i - 1) > 0)  && ((j - 1) >= 0)   && (frontGrid[i-1][j-1] != reveledUnit) )
                    frontGrid[i-1][j-1] = (char) (backGrid[i - 1][j-1] + '0'); // reveal upper left corner num



                    if (((i - 1) >0) && ((j + 1) < this.backGrid[i].length)  && (frontGrid[i-1][j+1] != reveledUnit) )
                        frontGrid[i-1][j+1] = (char) (backGrid[i - 1][j+1] + '0'); // reveal upper right corner num


                     if ( ( (i + 1) < this.backGrid[i].length) &&  ((j - 1) >= 0)  && (frontGrid[i+1][j-1] != reveledUnit))
                         frontGrid[i+1][j-1] = (char) (backGrid[i + 1][j-1] + '0'); // reveal bottom left corner num


                    if (  ((i + 1) < this.backGrid[i].length)  && ((j + 1) < this.backGrid[i].length)  && (frontGrid[i+1][j+1] != reveledUnit)  )
                        frontGrid[i+1][j+1] = (char) (backGrid[i + 1][j+1] + '0'); // reveal  bottom right corner num


                }


            }


        }
    }


    private void cascadeReveal(int i, int j) {

    //    System.out.println(i+" "+ j);

        LinkedList<Coordinates> moreReveal = new LinkedList<Coordinates>();
        Coordinates temp;


        if (  (i - 1) >0 ){
            if ((this.backGrid[i - 1][j] == 0) && this.frontGrid[i - 1][j] != reveledUnit         ) {
                this.frontGrid[i - 1][j] = reveledUnit;
                temp = new Coordinates(i - 1, j);
                moreReveal.add(temp);
            }}

        if ( (i + 1) < this.backGrid[i].length ){

            if ((this.backGrid[i + 1][j] == 0) && (this.frontGrid[i + 1][j] != reveledUnit) ) {
                this.frontGrid[i + 1][j] = reveledUnit;
                temp = new Coordinates(i + 1, j);
                moreReveal.add(temp);



            }}

        if (((j - 1) >= 0) && ((j - 1) < this.backGrid[i].length))
            if ((this.backGrid[i][j - 1] == 0) && this.frontGrid[i][j - 1] != reveledUnit) {
                this.frontGrid[i][j - 1] = reveledUnit; // Is there a mine to the left of me ?
                temp = new Coordinates(i, j - 1);
                moreReveal.add(temp);
            }

        if (((j + 1) >= 0) && ((j + 1) < this.backGrid[i].length))
            if ((this.backGrid[i][j + 1] == 0) && this.frontGrid[i][j + 1] != reveledUnit) {
                this.frontGrid[i][j + 1] = reveledUnit; // Is there a mine to rhe right of me ?
                temp = new Coordinates(i, j + 1);
                moreReveal.add(temp);
            }


        if (((i - 1) >= 0) && ((i - 1) < this.backGrid[i].length))
            if (((j - 1) >= 0) && ((j - 1) < this.backGrid[i].length))
                if ((this.backGrid[i - 1][j - 1] == 0) && this.frontGrid[i - 1][j - 1] != reveledUnit) {
                    this.frontGrid[i - 1][j - 1] = reveledUnit; // Is there a mine upper left corner ?
                    temp = new Coordinates(i - 1, j - 1);
                    moreReveal.add(temp);
                }

        if (((i - 1) >= 0) && ((i - 1) < this.backGrid[i].length))
            if (((j + 1) >= 0) && ((j + 1) < this.backGrid[i].length))
                if ((this.backGrid[i - 1][j + 1] == 0) && this.frontGrid[i - 1][j + 1] != reveledUnit) {
                    this.frontGrid[i - 1][j + 1] = reveledUnit; // Is there a mine upper right corner ?
                    temp = new Coordinates(i - 1, j + 1);
                    moreReveal.add(temp);
                }

        if (((i + 1) >= 0) && ((i + 1) < this.backGrid[i].length))
            if (((j - 1) >= 0) && ((j - 1) < this.backGrid[i].length))
                if ((this.backGrid[i + 1][j - 1] == 0) && this.frontGrid[i + 1][j - 1] != reveledUnit) {
                    this.frontGrid[i + 1][j - 1] = reveledUnit; // Is there a mine bottom left corner ?
                    temp = new Coordinates(i + 1, j - 1);
                    moreReveal.add(temp);
                }

        if (((i + 1) >= 0) && ((i + 1) < this.backGrid[i].length))
            if (((j + 1) >= 0) && ((j + 1) < this.backGrid[i].length))
                if ((this.backGrid[i + 1][j + 1] == 0) && this.frontGrid[i + 1][j + 1] != reveledUnit) {
                    this.frontGrid[i + 1][j + 1] = reveledUnit; // Is there a mine bottom right corner ?
                    temp = new Coordinates(i + 1, j + 1);
                    moreReveal.add(temp);
                }
        // read from top find first revealed and do recursion


        for (int k = 0; k < moreReveal.size(); k++) {
            cascadeReveal(moreReveal.get(k).getPosX(), moreReveal.get(k).getPosY());

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


}
