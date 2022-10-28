import java.util.LinkedList;
import java.util.List;

public class App {
    public int biggestIsland(Position[][] matrix) {
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

    
    private void addPosition (Island island, Position p, Position[][] matrix){
        int value = p.getValue();
        boolean counted = p.isCounted();

        if (value == 1 && !counted) {
            p.setCounted(true);
            island.addPosition(p);

            int i = p.getX();
            int j = p.getY();

            if(i-1 >= 0) addPosition(island, matrix[i-1][j], matrix); 
            if(j-1 >= 0) addPosition(island, matrix[i][j-1], matrix); 
            if(i+1 < matrix.length) addPosition(island, matrix[i+1][j], matrix);
            if(j+1 < matrix.length) addPosition(island, matrix[i][j+1], matrix);
        }
    }

    private Position[][] generateMatrix(int x, int y) {
        Position[][] matrix = new Position[x][y];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                int value = (int) Math.round(Math.random());
                Position p = new Position(i, j, value);
                matrix[i][j]=p;
            }
        }
        return matrix;
    }

    public static void main(String[] args) throws Exception {
        App app = new App();

        Position[][] matrix = app.generateMatrix(5,5);

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j].getValue() + "\t");
            }
            System.out.print("\n");
        }

        System.out.println("The biggest island is " + app.biggestIsland(matrix));
    }


}
