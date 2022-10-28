/**
 * Island is the class that represent an island of 1s. 
 * It stores a LinkedList with the positions of the 1 in the matrix
 * and provides the accesors methods to the list.
 */
import java.util.LinkedList;
import java.util.List;

public class Island {
    /**
     * A linkedlist for storing the positions of the 1s in the matrix.
     */
    private List <Position> positions = new LinkedList<>();

    /**
     * The default constructor
     */
    public Island() {
        super();
    }

    
    /** 
     * Getter for the list of positions.
     * @return List<Position> a linkedlist with all the positions stored.
     */
    public List<Position> getPositions() {
        return positions;
    }

    
    /** 
     * Setter for adding a position to the list of positions.
     * @param p the position to add to the list.
     */
    public void addPosition(Position p)
    {
        positions.add(p);
    }

    
    /**
     * Getter for the size of the island
     * @return int returns the size of the list, that is also the size of the island.
     */
    public int getSize ()
    {
        return positions.size();
    }
}
