import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;

/**
 * The MemoryRobot class represents the robot that moves around in the maze, and
 * it memorizes its path. This class uses both the Maze and Position class to
 * move around.
 *
 * @author Mallik Khan
 * @since 2023-11-08
 * @version 1.0
 */

public class MemoryRobot implements Robot {

    /**
     * The current position of the robot.
     */
    private Position position;
    /**
     * the previous position of the robot.
     */
    private Position previousPosition;
    /**
     * The maze that the robot will move through.
     */
    private Maze maze;
    /**
     * A stack that represents the path of the robot.
     */
    private Stack<Position> path;
    /**
     * A list that represents the visited positions.
     */
    private ArrayList<Position> visitedPositions;

    /**
     * This method is used to construct a memory robot with the given maze.
     *
     * @param maze The maze that the robot will navigate through.
     */
    public MemoryRobot(Maze maze)
    {
        this.maze = maze;
        this.position = maze.getStart();
        this.previousPosition = maze.getStart();
        this.path = new Stack<>();
        this.visitedPositions = new ArrayList<>();
    }

    /**
     * This method is used to make the robot move by gathering all positions
     * that are possible to move to and randomly picks one to go to. It won't
     * go there if it already has been there. If there is no place to go it willI
     * go back to it's last position.
     */
    @Override
    public void move() 
    {
        Random rand = new Random();
        ArrayList<Position> movablePositions = getMovablePositions();

        int n;

        if(movablePositions.isEmpty())
        {
            setPosition(this.path.get(this.path.size() - 1));
            this.path.pop();
        }
        else
        {
            n = rand.nextInt(movablePositions.size());
            setPosition(movablePositions.get(n));
            this.path.push(previousPosition);
            this.visitedPositions.add(previousPosition);
        }
        
        
    }

    /**
     * This method gathers all positions that are possible to move to and returns
     * them in a ArrayList. Its last position and all the positions that have been
     * visited can't be added to the ArrayList.
     * 
     * @return ArrayList. Returns all movable positions in a ArrayList.
     */
    private ArrayList<Position> getMovablePositions() {
        ArrayList<Position> movablePositions = new ArrayList<>();

        Position posSouth = this.position.getPosToSouth();
        if(maze.isMovable(posSouth) && !this.previousPosition.equals(posSouth) && !this.visitedPositions.contains(posSouth))
        {
            movablePositions.add(posSouth);
        }

        Position posNorth = this.position.getPosToNorth();
        if(maze.isMovable(posNorth) && !this.previousPosition.equals(posNorth) && !this.visitedPositions.contains(posNorth))
        {
            movablePositions.add(posNorth);
        }

        Position posWest = this.position.getPosToWest();
        if(maze.isMovable(posWest) && !this.previousPosition.equals(posWest)  && !this.visitedPositions.contains(posWest))
        {
            movablePositions.add(posWest);
        }

        Position posEast = this.position.getPosToEast();
        if(maze.isMovable(posEast) && !this.previousPosition.equals(posEast)  && !this.visitedPositions.contains(posEast))
        {
            movablePositions.add(posEast);
        }
        return movablePositions;
    }
    

    /**
     * Sets the current position to previousPosition and then
     * sets the current position of the robot to the given position.
     *
     * @param position The new position for the robot.
     */
    private void setPosition(Position position)
    {
        this.previousPosition = this.position;
        this.position = position;
    }

    @Override
    /**
     * Gets the current position of the robot in the maze.
     *
     * @return Position object. The position of the robot.
     */
    public Position getPosition()
    {
        return this.position;
    }

    @Override
    /**
     * Checks if the robot has reached the goal position in the maze.
     *
     * @implNote Undefined behaviour can occur, if there is no goal position in the maze.
     *
     * @return Boolean value. If the robot has reached the goal position return true,
     *         otherwise return false.
     */
    public boolean hasReachedGoal()
    {
        return maze.isGoal(this.position);
    }
}
