public class Main {




    public static void main(String[] args) {

        grid grid = new grid(10,10,10);
        player player = new player();


 //a       grid.printBackGrid();
        grid.renderGrid(player.getPointer());


while (!grid.isGameOver()) {
    System.out.println();
    player.move(grid);
    grid.renderGrid(player.getPointer());


 //   grid.printBackGrid();
    // check if game over

}







    }












}


