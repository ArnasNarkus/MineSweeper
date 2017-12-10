package MineSweeper;

import java.util.Scanner;

public class Player {

    private Coordinates pointer = new Coordinates();

    public Player() {
    }


    public void move(MinesweeperGrid grid) {

        Scanner keyboard = new Scanner(System.in);
        String direction = keyboard.next();

        switch (direction) {

            case "a":
            case "A":
                if( (pointer.getPosY()-1>=0)  && (pointer.getPosY()-1 <grid.getYLen()) )
                pointer.goLeft();
                break;

            case "d":
            case "D":
                if( (pointer.getPosY()+1 >=0)  && (pointer.getPosY()+1 <grid.getYLen()) )
                pointer.goRight();
                break;

            case "w":
            case "W":
                if( (pointer.getPosX()-1>=0) && (pointer.getPosX()-1 <grid.getXLen()) )
                pointer.goUp();
                break;

            case "s":
            case "S":
                if( (pointer.getPosX()+1 >=0) && (pointer.getPosX()+1 <grid.getXLen()) )
                pointer.goDown();
                break;

            case "e":
            case "E":
                grid.reveal(pointer);
                break;

        }


    }

    public Coordinates getPointer() {
        return pointer;
    }


}
