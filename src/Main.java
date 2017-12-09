public class Main {


    public static void main(String[] args) {

        Grid grid = new Grid(10, 10, 10);
        Player player = new Player();

        grid.renderGrid(player.getPointer());

        while (!grid.isGameOver()) {
            System.out.println();
            player.move(grid);
            grid.renderGrid(player.getPointer());
        }
    }
}


