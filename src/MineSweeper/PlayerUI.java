package MineSweeper;

import java.util.Scanner;

public class PlayerUI {

    private Coordinates pointer = new Coordinates();

    public PlayerUI() {
    }


    public void move(MinesweeperGrid grid) {

        Scanner keyboard = new Scanner(System.in);
        String direction = keyboard.next();

        switch (direction) {

            case "a":
            case "A":
                if ((pointer.getPosY() - 1 >= 0) && (pointer.getPosY() - 1 < grid.getYLen()))
                    pointer.goLeft();
                break;

            case "d":
            case "D":
                if ((pointer.getPosY() + 1 >= 0) && (pointer.getPosY() + 1 < grid.getYLen()))
                    pointer.goRight();
                break;

            case "w":
            case "W":
                if ((pointer.getPosX() - 1 >= 0) && (pointer.getPosX() - 1 < grid.getXLen()))
                    pointer.goUp();
                break;

            case "s":
            case "S":
                if ((pointer.getPosX() + 1 >= 0) && (pointer.getPosX() + 1 < grid.getXLen()))
                    pointer.goDown();
                break;

            case "e":
            case "E":
                grid.reveal(pointer);
                break;

            case "q":
            case "Q":
                getGameInstructions();
                break;
        }
    }


    public void getGameInstructions() {
        System.out.println("Welcome to MineSweeper 2017 console edition.");
        System.out.println("Controls:");
        System.out.println("W - to move pointer up.");
        System.out.println("A - to move pointer left.");
        System.out.println("D - to move pointer right.");
        System.out.println("S - to move pointer down.");
        System.out.println("E - to reveal cell.");
        System.out.println("Q - to repeat instructions.");

    }





    public Coordinates getPointer() {
        return pointer;
    }

}
