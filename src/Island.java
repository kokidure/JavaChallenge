import java.util.LinkedList;
import java.util.List;

public class Island {
    private List <Position> positions = new LinkedList<>();

    public Island() {
        super();
    }

    public List<Position> getPositions() {
        return positions;
    }

    public void addPosition(Position p)
    {
        positions.add(p);
    }

    public int getSize ()
    {
        return positions.size();
    }
}
