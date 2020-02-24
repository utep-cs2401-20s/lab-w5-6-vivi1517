public class SnakeGame {

    private boolean[][]  game;          //attributes of SnakeGame class//
    private int[] headPosition;
    private static int exhaustiveChecks;
    private static int recursiveChecks;

    public SnakeGame(){
        boolean[][] game = new boolean[1][1];   //creates default game with board size of 1 by 1//
    }

    public SnakeGame(boolean[][] array, int x, int y){
        boolean[][] game = new boolean[array.length][array[0].length];      //creates board with given size//
        int[] headPosition = new int[2];        //creates array for head position//
        for (int i = 0; i < array.length; i++){
            for (int j = 0; j < array[i].length; j++){
                game[i][j] = array[i][j];       //copies array into game//
            }
        }
        headPosition[0] = x;        //sets head position//
        headPosition[1] = y;
    }

    public int[] findTailExhaustive(){
        resetCounters();
        int[] tail = new int[3];        //creates the array that is going to be returned//
        boolean tailFound = false;
        int length = 0;
        int liveNeighbors = 0;
        for (int i = 0; i < game.length; i++){
            for (int j = 0; j < game[i].length; j++){
                if (game[i][j] == true){        //if the cell is true it calls neighbors to check the live//
                    if (tailFound == false){    //neighbors it has and if it only has one it records that//
                        exhaustiveChecks += 1;  //position as the tail//
                    }
                    length += 1;        //increases length of snake//
                    liveNeighbors = neighbors(game, i, j);
                    if (liveNeighbors == 1 && (i != headPosition[0] || j != headPosition[1])){
                        tail[0] = i;        //if neighbors is one and its not the head position it records the
                        tail[1] = j;        //coordinates of the tail//
                        tailFound = true;
                    }
                }
                else if (game[i][j] == false && tailFound == false){
                    exhaustiveChecks += 1;      //updates exhaustive checks//
                }
            }
        }
        tail[2] = length;   //puts length of tail into array//
        return tail;
    }

    private int neighbors(boolean[][] array, int row, int col) {    //checks possible cells around the point//
        int snake = 0;                                              //anc sees if the cell is part of the snake//
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

    public int[] findTailRecursive(){
        resetCounters();
        return findTailRecursive(headPosition, headPosition);

    }

    private int[] findTailRecursive(int[] currentPosition, int[] previousPosition){
        int[] curr = new int[2];
        if (currentPosition[0] == 0 && currentPosition[1] == 0){
            if((game[0][1] == true) && ((previousPosition[0] != 0) || (previousPosition[1] != 1)) {
                recursiveChecks += 1;
                curr[0] = 0;
                curr[1] = 1;
                findTailRecursive(curr, currentPosition);
            }
        }
    }

    private void resetCounters(){
        exhaustiveChecks = 0;
        recursiveChecks = 0;

    }

    private static int getRecursiveChecks(){
        return recursiveChecks;
    }

    private static int getExhaustiveChecks(){
        return exhaustiveChecks;
    }
}
