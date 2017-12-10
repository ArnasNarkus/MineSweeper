package MineSweeper;

public class Main {


    public static void main(String[] args) {

        MinesweeperGrid grid = new MinesweeperGrid(10, 10, 10);
        Player player = new Player();
        MinesweeperRenderer renderer = new MinesweeperRenderer(grid);

        renderer.renderGrid(player.getPointer());

        while (!grid.isGameOver()) {
            System.out.println();
            player.move(grid);
            renderer.renderGrid(player.getPointer());
        }
    }
}


