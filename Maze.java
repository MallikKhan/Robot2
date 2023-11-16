import java.util.ArrayList;
import java.util.Scanner;

/**
 * The Maze class represents the maze that the RandomRobot moves in. This
 * class helps us figure out what each position is and if we can move to it.
 * It also gives us information about how the maze looks, like the size and
 * where start and goal is.
 *
 * @author Mallik Khan
 * @since 2023-05-04
 * @version 1.0
 */
public class Maze
{
    /**
     * The representation of the maze as a 1 dimensional ArrayList.
     */
    private ArrayList<String> maze;
    /**
     * The start position for the robot in the maze.
     */
    private Position startPosition;
    /**
     *  The number of the columns in the maze.
     */
    private int numColumns;
    /**
     *  The number of the rows in the maze.
     */
    private int numRows;

    /**
     * This method is used to construct the Maze by reading from a Scanner.
     * @throws Exception - when wrong maze
     * @param scanner The Scanner object.
     */
    public Maze(Scanner scanner) throws Exception {
        maze = new ArrayList<>();
        while (scanner.hasNextLine())
        {
            maze.add(scanner.nextLine());
        }

        if(!mazeValidations())
        {
            throw new Exception("Incorrect maze was used.");
        }
    }

    /**
     * Checks if you can move to the given position.
     *
     * @param position The position to be checked.
     * @return boolean. Returns a Boolean value. If you can move to the given position
     * it returns true, otherwise false.
     */
    public boolean isMovable(Position position)
    {
        int y = position.getY();
        if (y < 0 || y >= maze.size())
        {
            return false;
        }

        String row = maze.get(y);
        int x = position.getX();
        if (x < 0 || x >= row.length())
        {
            return false;
        }

        String line = maze.get(position.getY());
        char c = line.charAt(position.getX());

        return c == ' ' || c == 'G' || c == 'S';


    }

    /**
     * Checks if the given position is the goal.
     *
     * @param position The position to be checked.
     * @return boolean. Returns a Boolean value. If the given position is the goal it
     * returns true, otherwise false.
     */
    public boolean isGoal(Position position)
    {
        String line = maze.get(position.getY());
        char c = line.charAt(position.getX());

        return c == 'G';
    }

    /**
     * Searches the maze for the start position
     *
     * @return Position. Returns the start position.
     */
    public Position getStart()
    {

        for(int i = 0; i < maze.size(); i++)
        {
            String s = maze.get(i);
            for(int j = 0; j < s.length(); j++)
            {
                char c = s.charAt(j);
                if(c == 'S')
                {
                    startPosition = new Position(j,i);
                }
            }
        }

        return startPosition;

    }

    /**
     * Finds out the number of columns the maze has
     *
     * @return int. Returns the number of columns.
     */
    public int getNumColumns()
    {
        int rowSize = 0;
        int x;

        for(int i = 0; i < maze.size(); i++)
        {
            String s = maze.get(i);
            x = s.length();
            if( x >= rowSize)
            {
                rowSize = x;
            }

        }

        return rowSize;
    }

    /**
     * Finds out the number of columns the maze has
     *
     * @return int. Returns the number of columns.
     */
    public int getNumRows()
    {
        return maze.size();
    }

    private boolean mazeValidations()
    {
        boolean forS = false;
        boolean forG = false;
        for(int i = 0; i < maze.size(); i++)
        {
            String string = maze.get(i);
            for(int j = 0; j < string.length(); j++)
            {
                char s = string.charAt(j);
                if(s == 'S')
                {
                    forS = true;
                    break;
                }
            }
        }

        for(int i = 0; i < maze.size(); i++)
        {
            String string = maze.get(i);
            for(int j = 0; j < string.length(); j++)
            {
                char g = string.charAt(j);
                if(g == 'G')
                {
                    forG = true;
                    break;
                }
            }
        }

        return forS && forG;


    }

}