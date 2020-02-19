public class SnakeGame {

    private boolean[][]  game;
    private int[] headPosition;
    private static int exhaustiveChecks;
    private static int recursiveChecks;

    public SnakeGame(){
        boolean[][] game = new boolean[1][1];
    }

    public SnakeGame(boolean[][] array, int x, int y){
        boolean[][] game = new boolean[array.length][array[0].length];
        int[] headPosition = new int[2];
        for (int i = 0; i < array.length; i++){
            for (int j = 0; j < array[i].length; j++){
                game[i][j] = array[i][j];
            }
        }
        headPosition[0] = x;
        headPosition[1] = y;
    }

    public int[] findTailExhaustive(){
        int[] tail = new int[3];
        boolean tailFound = false;
        exhaustiveChecks = 0;
        int length = 0;
        int liveNeighbors = 0;
        for (int i = 0; i < game.length; i++){
            for (int j = 0; j < game[i].length; j++){
                if (game[i][j] == true){
                    if (tailFound == false){
                        exhaustiveChecks += 1;
                    }
                    length += 1;
                    liveNeighbors = neighbors(game, i, j);
                    if (liveNeighbors == 1 && (i != headPosition[0] || j != headPosition[1])){
                        tail[0] = i;
                        tail[1] = j;
                        tailFound = true;
                    }
                }
                else if (game[i][j] == false && tailFound == false){
                    exhaustiveChecks += 1;
                }
            }
        }
        tail[2] = length;
        return tail;
    }

    private int neighbors(boolean[][] array, int row, int col) {
        int snake = 0;
        if (row == 0 && col == 0) {
            if (array[row][col + 1] == true) {
                snake += 1;
            }
            if (array[row + 1][col] == true){
                snake += 1;
            }
        }
        else if (row == 0 && col == array.length - 1){
            if (array[row][col - 1] == true) {
                snake += 1;
            }
            if (array[row + 1][col] == true){
                snake += 1;
            }
        }
        else if (row == 0){
            if (array[row][col - 1] == true) {
                snake += 1;
            }
            if (array[row + 1][col] == true){
                snake += 1;
            }
            if (array[row][col + 1] == true){
                snake += 1;
            }
        }
        else if (row == array.length - 1 && col == 0){
            if (array[row - 1][col] == true){
                snake += 1;
            }
            if (array[row][col + 1] == true){
                snake += 1;
            }
        }
        else if (row == array.length - 1 && col == array.length - 1){
            if (array[row - 1][col] == true){
                snake += 1;
            }
            if (array[row][col - 1] == true){
                snake += 1;
            }
        }
        else if (row == array.length - 1){
            if (array[row][col - 1] == true){
                snake += 1;
            }
            if (array[row - 1][col] == true){
                snake += 1;
            }
            if (array[row][col + 1] == true){
                snake += 1;
            }
        }
        else if (col == 0){
            if (array[row - 1][col] == true){
                snake += 1;
            }
            if (array[row][col + 1] == true){
                snake += 1;
            }
            if (array[row + 1][col] == true){
                snake += 1;
            }
        }
        else if (col == array.length - 1){
            if (array[row - 1][col] == true){
                snake += 1;
            }
            if (array[row][col - 1] == true){
                snake += 1;
            }
            if (array[row + 1][col] == true){
                snake += 1;
            }
        }
        else {
            if (array[row - 1][col] == true){
                snake += 1;
            }
            if (array[row][col + 1] == true){
                snake += 1;
            }
            if (array[row + 1][col] == true){
                snake += 1;
            }
            if (array[row][col - 1] == true){
                snake += 1;
            }
        }
        return snake;


    }

    //public int[] findTailRecursive(){

    //}
}
