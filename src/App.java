/**
 * App is the main class for the Matrix Islands of 1s problem.
 * It contains all the methods to process the matrix, count the
 * islands and calculate the biggest island.
 * 
 * It also contains the main method of the project.
 */

import java.util.LinkedList;
import java.util.List;

public class App {
    
    /** 
     * Method to process the matrix, find the islands on it, and
     * calculate the biggest island
     * 
     * @param matrix a matrix of type Position, wich stores the elements of the matrix
     * @return int the size of the biggest island
     */
    public static int calculateBiggestIsland(Position[][] matrix) {
        List<Island> islands = new LinkedList<>();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                Position p = matrix[i][j];
                int value = p.getValue();
                boolean counted = p.isCounted();

                if (value == 1 && !counted)
                {
                    Island island = new Island();
                    islands.add(island);
                    addPosition(island, p, matrix);
                }
            }
        }

        int biggestIsland = 0;

        for (Island island : islands) {
            if (island.getSize()>=biggestIsland)
                biggestIsland = island.getSize();
        }

        return biggestIsland;
    }

    
    
    /** 
     * Adds a position to the islands, after checking all the neighbours.
     * It checks if the value of the element is 1 and if was not yet counted, 
     * and check the neighbours of the element calling itself recursively.
     * 
     * @param island an Island object
     * @param p the starting position of the island
     * @param matrix the complete matrix for checking the edges
     */
    private static void addPosition (Island island, Position p, Position[][] matrix){
        int value = p.getValue();
        boolean counted = p.isCounted();

        if (value == 1 && !counted) {
            p.setCounted(true);
            island.addPosition(p);

            int i = p.getI();
            int j = p.getJ();

            if(i-1 >= 0) addPosition(island, matrix[i-1][j], matrix); 
            if(j-1 >= 0) addPosition(island, matrix[i][j-1], matrix); 
            if(i+1 < matrix.length) addPosition(island, matrix[i+1][j], matrix);
            if(j+1 < matrix.length) addPosition(island, matrix[i][j+1], matrix);
        }
    }

    
    /** 
     * Generates a matrix of random 1s and 0s, given the size of the rows and columns
     * 
     * @param rows the rows
     * @param columns the columns
     * @return Position[][] a matrix of type position, with size i,j
     */
    private static Position[][] generateMatrix(int rows, int columns) {
        Position[][] matrix = new Position[rows][columns];

        /* manually created matrix
        int[][] matrix2 = {{0,0,1,0,0,0,0,1,0,0,0,0,0},
                            {0,0,0,0,0,0,0,1,1,1,0,0,0},
                            {0,1,1,0,1,0,0,0,0,0,0,0,0},
                            {0,1,0,0,1,1,0,0,1,0,1,0,0},
                            {0,1,0,0,1,1,0,0,1,1,1,0,0},
                            {0,0,0,0,0,0,0,0,0,0,1,0,0},
                            {0,0,0,0,0,0,0,1,1,1,0,0,0},
                            {0,0,0,0,0,0,0,1,1,0,0,0,0}};
        */

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                int value = (int) Math.round(Math.random());
                Position p = new Position(i, j, value);
                // Position p2 = new Position(i, j, matrix2[i][j]); converting the manually created matrix to a matrix of type Position.
                matrix[i][j]=p;
            }
        }
        return matrix;
    }

    
    /** 
     * The main method for executing the app.
     */
    public static void main(String[] args) throws Exception {
        Position[][] matrix = generateMatrix(5,5);

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j].getValue() + "\t");
            }
            System.out.print("\n");
        }

        System.out.println("The biggest island is " + calculateBiggestIsland(matrix));
    }


}
