import java.util.Objects;

/**
 * The Position class defines what a position is in the maze. The class contains
 * the coordinates of the position and hwo to get to positions around it.
 *
 * @author Mallik Khan
 * @since 2023-05-04
 * @version 1.0
 */
public class Position
{
    /**
     * The coordinate x of the position.
     */
    private int x;
    /**
     * The coordinate y of the position.
     */
    private int y;

    /**
     * Constructs a position with the given x and y coordinates .
     *
     * @param x The x coordinate.
     * @param y The y coordinate.
     */
    public Position(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    /**
     * Gets the x coordinate of the position.
     *
     * @return int. Returns the x coordinate of the position
     */
    public int getX()
    {
        return this.x;
    }

    /**
     * Gets the y coordinate of the position.
     *
     * @return int. Returns the y coordinate of the position
     */
    public int getY()
    {
        return this.y;
    }

    /**
     * Gets the position to the south.
     *
     * @return Position. Returns the position to the south.
     */
    public Position getPosToSouth()
    {
        return  new Position(this.x , this.y + 1);
    }

    /**
     * Gets the position to the north.
     *
     * @return Position. Returns the position to the north.
     */
    public Position getPosToNorth()
    {
        return new Position(this.x , this.y - 1);
    }

    /**
     * Gets the position to the west.
     *
     * @return Position. Returns the position to the west.
     */
    public Position getPosToWest()
    {
        return new Position(this.x - 1, this.y);
    }

    /**
     * Gets the position to the east.
     *
     * @return Position. Returns the position to the east.
     */
    public Position getPosToEast()
    {
        return new Position(this.x + 1, this.y);

    }

    /**
     * Compares current Position object to another object. Two Position object
     * are considered equal if their x and y coordinates are equal.
     *
     * @param o The object to be compared with the Position object.
     * @return Boolean value. If the give object is equal to the Position object
     *         returns true, otherwise returns false.
     */
    @Override
    public boolean equals(Object o)
    {
        if(o == null)
        {
            return false;
        }
        if (o.getClass() != Position.class)
        {
            return false;
        }

        return ((Position) o).getY() == this.y && ((Position) o).getX() == this.x;
    }

    /**
     * Computes the hash code for the Position object.
     *
     * @return int. The hash value for the Position object.
     */
    @Override
    public int hashCode()
    {
        return Objects.hash(x, y);
    }

}
