/**
 * Position is the class that stores the values of an element in the matrix.
 * It stores the coordenates i and j, the value of that element, and a boolean "counted"
 * that indicates if that element is already a member of an island
 */

public class Position {
    private int i;
    private int j;
    private int value;
    private boolean counted;

    /**
     * The main constructor of the class
     * @param i the row index of the element
     * @param j the columnt index of the element
     * @param value the value of the element
     */
    public Position (int i, int j, int value) {
        this.i = i;
        this.j = j;
        this.counted = false;
        this.value = value;
    }

    
    /** 
     * Getter for the row index of the element
     * @return int the row index
     */
    public int getI() {
        return i;
    }

    
    /** 
     * Getter for the column index of the element
     * @return int the column index
     */
    public int getJ() {
        return j;
    }

    
    /** 
     * Getter for the value of the element
     * @return int the value
     */
    public int getValue() {
        return value;
    }

    
    /** 
     * Setter for the value of the element
     * @param value the value
     */
    public void setValue(int value) {
        this.value = value;
    }


    /** 
     * Getter to check if the element was already counted
     * @return boolean the checker
     */
    public boolean isCounted() {
        return counted;
    }

    
    /** 
     * Setter for marking an element as counted/not counted
     * @param counted the checker
     */
    public void setCounted(boolean counted) {
        this.counted = counted;
    }

    
    /** 
     * Setter for the row index of the element
     * @param x the row index
     */
    public void setX (int x) {
        this.i = x;
    }

    
    /** 
     * Setter for the column index of the element
     * @param y the column index
     */
    public void setY (int y) {
        this.j = y;
    }
}
