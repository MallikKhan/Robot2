import java.util.ArrayList;
import java.util.Random;

/**
 * The RandomRobot class represents the robot that moves around in the maze.
 * This class uses both the Maze and Position class to move around.
 *
 * @author Mallik Khan
 * @since 2023-05-04
 * @version 1.0
 */
public class RandomRobot implements Robot {
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
     * This method is used to construct a random robot with the given maze.
     *
     * @param maze The maze that the robot will navigate through.
     */
    public RandomRobot(Maze maze)
    {
        this.maze = maze;
        this.position = maze.getStart();
        this.previousPosition = maze.getStart();
    }

    /**
     * This method is used to make the robot move randomly to north, south, east or west.
     * If no directions are available, the robot moves back to the previous position.
     */
    public void move()
    {
        Random rand = new Random();
        ArrayList<Position> movablePositions = new ArrayList<>();

        Position posSouth = this.position.getPosToSouth();
        if(maze.isMovable(posSouth) && !this.previousPosition.equals(posSouth))
        {
            movablePositions.add(posSouth);
        }

        Position posNorth = this.position.getPosToNorth();
        if(maze.isMovable(posNorth) && !this.previousPosition.equals(posNorth))
        {
            movablePositions.add(posNorth);
        }

        Position posWest = this.position.getPosToWest();
        if(maze.isMovable(posWest) && !this.previousPosition.equals(posWest))
        {
            movablePositions.add(posWest);
        }

        Position posEast = this.position.getPosToEast();
        if(maze.isMovable(posEast) && !this.previousPosition.equals(posEast))
        {
            movablePositions.add(posEast);
        }

        int n;

        if(movablePositions.isEmpty())
        {
            setPosition(previousPosition);
        }
        else
        {
            n = rand.nextInt(movablePositions.size());
            setPosition(movablePositions.get(n));
        }



    }

    /**
     * Gets the current position of the robot in the maze.
     *
     * @return Position object. The position of the robot.
     */
    public Position getPosition()
    {
        return this.position;
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

    /**
     * Checks if the robot has reached the goal position in the maze.
     *
     *
     * @return Boolean value. If the robot has reached the goal position return true,
     *         otherwise return false.
     */
    public boolean hasReachedGoal()
    {
        return maze.isGoal(this.position);
    }



}
