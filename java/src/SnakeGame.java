public class SnakeGame {

    private boolean[][]  game;          //attributes of SnakeGame class//
    private int[] headPosition;
    private static int exhaustiveChecks;
    private static int recursiveChecks;

    public SnakeGame(){
        boolean[][] game = new boolean[1][1];   //creates default game with board size of 1 by 1//
    }

    public SnakeGame(boolean[][] array, int x, int y){//creates array for head position//
        boolean[][] game = new boolean[array.length][array[0].length];
        int[] headPosition = new int[2];
        this.headPosition = headPosition;
        this.game = game;
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
        int snake = 0;                                              //and sees if the cell is part of the snake//
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

    public int[] neighborsRecursive(boolean[][] array, int[] previousPosition, int row, int col){
        int length = 0;
        int[] location = new int[2];
        if (row == 0 && col == 0){
            if (array[row][col + 1] == true && (previousPosition[0] != row || previousPosition[1] != col + 1)){
                length += 1;
                location[0] = row;
                location[1] = col + 1;
                return location;
            }
            if (array[row + 1][col] == true && (previousPosition[0] != row + 1|| previousPosition[1] != col)){
                length += 1;
                location[0] = row + 1;
                location[1] = col;
                return location;
            }
        }
        else if (row == 0 && col == array.length - 1){
            if (array[row][col - 1] == true && (previousPosition[0] != row || previousPosition[1] != col - 1)){
                length += 1;
                location[0] = row;
                location[1] = col - 1;
                return location;
            }
            if (array[row + 1][col] == true && (previousPosition[0] != row + 1|| previousPosition[1] != col)){
                length += 1;
                location[0] = row + 1;
                location[1] = col;
                return location;
            }
        }
        else if (row == 0){
            if (array[row][col - 1] == true && (previousPosition[0] != row || previousPosition[1] != col - 1)) {
                length += 1;
                location[0] = row;
                location[1] = col - 1;
                return location;
            }
            if (array[row + 1][col] == true && (previousPosition[0] != row + 1|| previousPosition[1] != col)){
                length += 1;
                location[0] = row + 1;
                location[1] = col;
                return location;
            }
            if (array[row][col + 1] == true && (previousPosition[0] != row || previousPosition[1] != col + 1)){
                length += 1;
                location[0] = row;
                location[1] = col + 1;
                return location;
            }
        }
        else if (row == array.length - 1 && col == 0){
            if (array[row - 1][col] == true && (previousPosition[0] != row - 1|| previousPosition[1] != col)){
                length += 1;
                location[0] = row - 1;
                location[1] = col;
                return location;
            }
            if (array[row][col + 1] == true && (previousPosition[0] != row || previousPosition[1] != col + 1)){
                length += 1;
                location[0] = row;
                location[1] = col + 1;
                return location;
            }
        }
        else if (row == array.length - 1 && col == array.length - 1){
            if (array[row - 1][col] == true && (previousPosition[0] != row - 1|| previousPosition[1] != col)){
                length += 1;
                location[0] = row - 1;
                location[1] = col;
                return location;
            }
            if (array[row][col - 1] == true && (previousPosition[0] != row || previousPosition[1] != col - 1)){
                length += 1;
                location[0] = row;
                location[1] = col - 1;
                return location;
            }
        }
        else if (row == array.length - 1){
            if (array[row][col - 1] == true && (previousPosition[0] != row || previousPosition[1] != col - 1)){
                length += 1;
                location[0] = row;
                location[1] = col - 1;
                return location;
            }
            if (array[row - 1][col] == true && (previousPosition[0] != row - 1|| previousPosition[1] != col)){
                length += 1;
                location[0] = row - 1;
                location[1] = col;
                return location;
            }
            if (array[row][col + 1] == true && (previousPosition[0] != row || previousPosition[1] != col + 1)){
                length += 1;
                location[0] = row;
                location[1] = col + 1;
                return location;
            }
        }
        else if (col == 0){
            if (array[row - 1][col] == true && (previousPosition[0] != row - 1|| previousPosition[1] != col)){
                length += 1;
                location[0] = row - 1;
                location[1] = col;
                return location;
            }
            if (array[row][col + 1] == true && (previousPosition[0] != row || previousPosition[1] != col + 1)){
                length += 1;
                location[0] = row;
                location[1] = col + 1;
                return location;
            }
            if (array[row + 1][col] == true && (previousPosition[0] != row + 1|| previousPosition[1] != col)){
                length += 1;
                location[0] = row + 1;
                location[1] = col;
                return location;
            }
        }
        else if (col == array.length - 1){
            if (array[row - 1][col] == true && (previousPosition[0] != row - 1|| previousPosition[1] != col)){
                length += 1;
                location[0] = row - 1;
                location[1] = col;
                return location;
             }
            if (array[row][col - 1] == true && (previousPosition[0] != row || previousPosition[1] != col - 1)){
                length += 1;
                location[0] = row;
                location[1] = col - 1;
                return location;
            }
            if (array[row + 1][col] == true && (previousPosition[0] != row + 1|| previousPosition[1] != col)){
                length += 1;
                location[0] = row + 1;
                location[1] = col;
                return location;
            }
        }
        else {
            if (array[row - 1][col] == true && (previousPosition[0] != row - 1|| previousPosition[1] != col)){
                length += 1;
                location[0] = row - 1;
                location[1] = col;
                return location;
            }
            if (array[row][col + 1] == true && (previousPosition[0] != row || previousPosition[1] != col + 1)){
                length += 1;
                location[0] = row;
                location[1] = col + 1;
                return location;
            }
            if (array[row + 1][col] == true && (previousPosition[0] != row + 1|| previousPosition[1] != col)){
                length += 1;
                location[0] = row + 1;
                location[1] = col;
                return location;
            }/////////////
            if (array[row][col - 1] == true && (previousPosition[0] != row || previousPosition[1] != col - 1)){
                length += 1;
                location[0] = row;
                location[1] = col - 1;
                return location;
            }
            else {
                location[0] = row;
                location[1] = col;
                return location;
            }
        }
        return location;
    }

    public int[] findTailRecursive(){       //starts the recursion call//
        resetCounters();
        return findTailRecursive(headPosition, headPosition);
    }

    private int[] findTailRecursive(int[] currentPosition, int[] previousPosition){     //update recursive checks in this method//
        int length = 0;
        int[] tail = new int[3];
        if (currentPosition[0] == headPosition[0] && currentPosition[1] == headPosition[1]) {
            if (game[currentPosition[0]][currentPosition[1]] && currentPosition[0] != previousPosition[0] && currentPosition[1] != currentPosition[1]){
                length += 1;
            }
            recursiveChecks += 1;
            tail[0] = currentPosition[0];
            tail[1] = currentPosition[1];
            tail[2] = length;
            return findTailRecursive(neighborsRecursive(game, previousPosition, currentPosition[0], currentPosition[1]), currentPosition);

        }
        if ((currentPosition[0] == previousPosition[0] && previousPosition[0] != headPosition[0]) && (currentPosition[1] == previousPosition[1] && previousPosition[1] != headPosition[1])){
            length += 1;
            recursiveChecks += 1;
            tail[0] = currentPosition[0];
            tail[1] = currentPosition[1];
            tail[2] = length;
            return tail;
        }
        else {
            if (game[currentPosition[0]][currentPosition[1]] && currentPosition[0] != previousPosition[0] && currentPosition[1] != previousPosition[1]){
                length += 1;
            }
            recursiveChecks += 1;
            return neighborsRecursive(game, previousPosition, currentPosition[0], currentPosition[1]);
        }

    }

    private void resetCounters(){
        exhaustiveChecks = 0;
        recursiveChecks = 0;

    }

    public static int getRecursiveChecks(){
        return recursiveChecks;
    }

    public static int getExhaustiveChecks(){
        return exhaustiveChecks;
    }
}
