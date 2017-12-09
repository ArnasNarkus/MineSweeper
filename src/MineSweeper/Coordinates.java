package MineSweeper;

public class Coordinates {

 private    int posX=0;
 private    int posY=0;

    public Coordinates() {

    }

    public Coordinates(int posX, int posY) {
        this.posX = posX;
        this.posY = posY;
    }

    public void goUp (){
        posX--;
    }

    public void goDown (){
        posX++;
    }


    public void goLeft (){
        posY--;
    }

    public void goRight (){
        posY++ ;
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }
}
