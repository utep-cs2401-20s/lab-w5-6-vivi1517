import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class SnakeGameTester {
    //10 cases
    //5 for find tail exhaustive and five for recursive
    //you can test if you are counting the right amount of cells
    //you can test if you found the tail correctly
    //you can test if the length of the tail is correct

    @Test
    public void testExhaustive1(){              //I am testing if the method returns the correct length//
        boolean[][] array = new boolean[5][5];  //I chose this test to make sure it only counts the true cells as part
        int[] length = new int[3];              //of the snake
        length[0] =1;                           //This test passed//
        length[1] = 4;
        length[2] = 5;
        for (int i = 0; i < array.length; i++){
            for (int j = 0; j < array.length; j++){
                array[i][j] = false;
            }
        }
        array[2][1] = true;
        array[1][1] = true;
        array[1][2] = true;
        array[1][3] = true;
        array[1][4] = true;
        SnakeGame sg = new SnakeGame(array, 2, 1);
        assertArrayEquals(length, sg.findTailExhaustive());
    }

    @Test
    public void testExhaustive2(){                  //Check to see if the number of Exhaustive checks is correct//
        boolean[][] array = new boolean[5][5];      //I chose to do this to make sure it was going through the whole board
        int[] length = new int[3];                  //and that it would stop counting when it actually found the tail//
        length[0] =1;                               //The test passed
        length[1] = 4;
        length[2] = 5;
        for (int i = 0; i < array.length; i++){
            for (int j = 0; j < array.length; j++){
                array[i][j] = false;
            }
        }
        array[2][1] = true;
        array[1][1] = true;
        array[1][2] = true;
        array[1][3] = true;
        array[1][4] = true;
        SnakeGame sg = new SnakeGame(array, 2, 1);
        sg.findTailExhaustive();
        assertEquals(10,sg.getExhaustiveChecks());
    }

    @Test
    public void testExhaustive3(){                 //Checks to see if the tail position is correct even if its in the
        boolean[][] array = new boolean[4][4];      //first square it checks.
        int[] length = new int[3];                  //I want to make sure that the program will run correctly even if it
        length[0] =0;                               //finds the tail on the first try
        length[1] = 0;                              //The test passed
        length[2] = 4;
        for (int i = 0; i < array.length; i++){
            for (int j = 0; j < array.length; j++){
                array[i][j] = false;
            }
        }
        array[0][0] = true;
        array[1][0] = true;
        array[2][0] = true;
        array[3][0] = true;
        SnakeGame sg = new SnakeGame(array, 3, 0);
        assertArrayEquals(length, sg.findTailExhaustive());
    }

    @Test
    public void testExhaustive4(){
        boolean[][] array = new boolean[4][4];      //I wanted to make sure the check counter worked even if it
        int[] length = new int[3];                  //found the tail on the first try
        length[0] =0;                               //The test passed
        length[1] = 0;
        length[2] = 4;
        for (int i = 0; i < array.length; i++){
            for (int j = 0; j < array.length; j++){
                array[i][j] = false;
            }
        }
        array[0][0] = true;
        array[1][0] = true;
        array[2][0] = true;
        array[3][0] = true;
        SnakeGame sg = new SnakeGame(array, 3, 0);
        sg.findTailExhaustive();
        assertEquals(1, sg.getExhaustiveChecks());
    }

    @Test
    public void testExhaustive5(){
        boolean[][] array = new boolean[4][4];      //I wanted to make sure the program worked even when the head was right
        int[] length = new int[3];                  //next to the tail. I wasn't sure if that would cause problems.
        length[0] =1;                               //The test passed
        length[1] = 3;
        length[2] = 2;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                array[i][j] = false;
            }
        }
        array[1][2] = true;
        array[1][3] = true;
        SnakeGame sg = new SnakeGame(array, 1, 2);
        assertArrayEquals(length, sg.findTailExhaustive());
    }

    @Test
    public void testRecursive1(){
        boolean[][] array = new boolean[5][5];  //I chose this test to make sure it found the tail correctly but the arrays
        int[] length = new int[3];              //differ in length
        length[0] =1;                           //This test failed//
        length[1] = 4;
        length[2] = 5;
        for (int i = 0; i < array.length; i++){
            for (int j = 0; j < array.length; j++){
                array[i][j] = false;
            }
        }
        array[2][1] = true;
        array[1][1] = true;
        array[1][2] = true;
        array[1][3] = true;
        array[1][4] = true;
        SnakeGame sg = new SnakeGame(array, 2, 1);
        assertArrayEquals(length, sg.findTailRecursive());
    }

    @Test
    public void testRecursive2(){
        boolean[][] array = new boolean[5][5];      //I chose to do this to make sure it did the correct amount of checks.
        int[] length = new int[3];                  //The test failed
        length[0] =1;
        length[1] = 4;
        length[2] = 5;
        for (int i = 0; i < array.length; i++){
            for (int j = 0; j < array.length; j++){
                array[i][j] = false;
            }
        }
        array[2][1] = true;
        array[1][1] = true;
        array[1][2] = true;
        array[1][3] = true;
        array[1][4] = true;
        SnakeGame sg = new SnakeGame(array, 2, 1);
        sg.findTailExhaustive();
        assertEquals(10, sg.getRecursiveChecks());
    }

    @Test
    public void testRecursive3(){                   //Checks to see if the tail position is correct even if its in the
        boolean[][] array = new boolean[4][4];      //first square it checks.
        int[] length = new int[3];                  //I want to make sure that the program will run correctly even if it
        length[0] =0;                               //finds the tail on the first try
        length[1] = 0;                              //The test failed
        length[2] = 4;
        for (int i = 0; i < array.length; i++){
            for (int j = 0; j < array.length; j++){
                array[i][j] = false;
            }
        }
        array[0][0] = true;
        array[1][0] = true;
        array[2][0] = true;
        array[3][0] = true;
        SnakeGame sg = new SnakeGame(array, 3, 0);
        assertArrayEquals(length, sg.findTailRecursive());
    }

    @Test
    public void testRecursive4(){
        boolean[][] array = new boolean[4][4];      //I wanted to make sure the check counter worked even if it
        int[] length = new int[3];                  //found the tail on the first try
        length[0] =0;                               //The test failed
        length[1] = 0;
        length[2] = 4;
        for (int i = 0; i < array.length; i++){
            for (int j = 0; j < array.length; j++){
                array[i][j] = false;
            }
        }
        array[0][0] = true;
        array[1][0] = true;
        array[2][0] = true;
        array[3][0] = true;
        SnakeGame sg = new SnakeGame(array, 3, 0);
        sg.findTailExhaustive();
        assertEquals(1, sg.getRecursiveChecks());
    }

    @Test
    public void testRecursive5(){
        boolean[][] array = new boolean[4][4];      //I wanted to make sure the program worked even when the head was right
        int[] length = new int[3];                  //next to the tail. I wasn't sure if that would cause problems.
        length[0] =1;                               //The test failed. For some reason my method gives me a different sized
        length[1] = 3;                              //array than expected
        length[2] = 2;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                array[i][j] = false;
            }
        }
        array[1][2] = true;
        array[1][3] = true;
        SnakeGame sg = new SnakeGame(array, 1, 2);
        assertArrayEquals(length, sg.findTailRecursive());
    }




}
