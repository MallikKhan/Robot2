/**
 * The RightHandRuleRobot class represents the robot that moves around in a maze, and
 * is doing so by always trying to go right. This class uses both the Maze and Position
 * class to move around.
 *
 * @author Mallik Khan
 * @since 2023-11-08
 * @version 1.0
 */

public class RightHandRuleRobot implements Robot{

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
     * The current direction of the Robot.
     */
    private Direction direction;

    /**
     * This method is used to construct a right hand rule robot with the given maze.
     *
     * @param maze The maze that the robot will navigate through.
     */
    public RightHandRuleRobot(Maze maze)
    {
        this.maze = maze;
        this.position = maze.getStart();
        this.previousPosition = maze.getStart();
        this.direction = Direction.SOUTH;

    }

    /**
     * This enum represents the different directions a right hand rule robot
     * can have to determine where to move depending on which direction it has
     */
    enum Direction {
        SOUTH,
        NORTH,
        WEST,
        EAST
    }

    /**
     * This method is used to make the robot move as if it's always trying to
     *  go right. Depending on which direction it has it will try to move to a
     *  certain direction which equals to robot moving right. If it can't go
     *  right it will try to find another direction that is possible to move
     *  towards.
     */
    @Override
    public void move()
    {
        Direction direction = this.direction;
        
        switch (direction)
        {
            case NORTH -> {
                moveNorth();
                break;
            }
            case EAST -> {
                moveEast();
                break;
            }
            case SOUTH -> {
                moveSouth();
                break;
            }
            case WEST -> {
                moveWest();
                break;
            }
        }
        
        
    }

    /**
     * This method represents how the robot will act if it's facing north.
     * It will try to go right and if that's not possible it will try to find
     * the closest direction to right counterclockwise
     */
    private void moveNorth()
    {
        
            Position posNorth = this.position.getPosToNorth();
            Position posSouth = this.position.getPosToSouth();
            Position posEast = this.position.getPosToEast();
            Position posWest = this.position.getPosToWest();
            if(this.direction == Direction.NORTH && maze.isMovable(posEast))
            {
                setPosition(this.position.getPosToEast());
                this.direction = Direction.EAST;
            }
            else if (this.direction == Direction.NORTH && maze.isMovable(posNorth))
            {
                setPosition(this.position.getPosToNorth());
            }
            else if (this.direction == Direction.NORTH && maze.isMovable(posWest))
            {
                setPosition(this.position.getPosToWest());
                this.direction = Direction.WEST;
            }
            else if (this.direction == Direction.NORTH && maze.isMovable(posSouth))
            {
                setPosition(this.position.getPosToSouth());
                this.direction = Direction.SOUTH;
            }
        
    }

    /**
     * This method represents how the robot will act if it's facing south.
     * It will try to go right and if that's not possible it will try to find
     * the closest direction to right counterclockwise
     */
    private void moveSouth()
    {
        
            Position posNorth = this.position.getPosToNorth();
            Position posSouth = this.position.getPosToSouth();
            Position posEast = this.position.getPosToEast();
            Position posWest = this.position.getPosToWest();
            if(this.direction == Direction.SOUTH && maze.isMovable(posWest))
            {
                setPosition(this.position.getPosToWest());
                this.direction = Direction.WEST;
            }
            else if (this.direction == Direction.SOUTH && maze.isMovable(posSouth))
            {
                setPosition(this.position.getPosToSouth());
            }
            else if (this.direction == Direction.SOUTH && maze.isMovable(posEast))
            {
                setPosition(this.position.getPosToEast());
                this.direction = Direction.EAST;
            }
            else if (this.direction == Direction.SOUTH && maze.isMovable(posNorth))
            {
                setPosition(this.position.getPosToNorth());
                this.direction = Direction.NORTH;
            }
        

    }

    /**
     * This method represents how the robot will act if it's facing west.
     * It will try to go right and if that's not possible it will try to find
     * the closest direction to right counterclockwise
     */
    private void moveWest()
    {
        
            Position posNorth = this.position.getPosToNorth();
            Position posSouth = this.position.getPosToSouth();
            Position posEast = this.position.getPosToEast();
            Position posWest = this.position.getPosToWest();
            if(this.direction == Direction.WEST && maze.isMovable(posNorth))
            {
                setPosition(this.position.getPosToNorth());
                this.direction = Direction.NORTH;
            }
            else if (this.direction == Direction.WEST && maze.isMovable(posWest))
            {
                setPosition(this.position.getPosToWest());
            }
            else if (this.direction == Direction.WEST && maze.isMovable(posSouth))
            {
                setPosition(this.position.getPosToSouth());
                this.direction = Direction.SOUTH;
            }
            else if (this.direction == Direction.WEST && maze.isMovable(posEast))
            {
                setPosition(this.position.getPosToEast());
                this.direction = Direction.EAST;
            }
        
    }

    /**
     * This method represents how the robot will act if it's facing east.
     * It will try to go right and if that's not possible it will try to find
     * the closest direction to right counterclockwise
     */
    private void moveEast()
    {
        
            Position posNorth = this.position.getPosToNorth();
            Position posSouth = this.position.getPosToSouth();
            Position posEast = this.position.getPosToEast();
            Position posWest = this.position.getPosToWest();
            if(this.direction == Direction.EAST && maze.isMovable(posSouth))
            {
                setPosition(this.position.getPosToSouth());
                this.direction = Direction.SOUTH;
            }
            else if (this.direction == Direction.EAST && maze.isMovable(posEast))
            {
                setPosition(this.position.getPosToEast());
            }
            else if (this.direction == Direction.EAST && maze.isMovable(posNorth))
            {
                setPosition(this.position.getPosToNorth());
                this.direction = Direction.NORTH;
            }
            else if (this.direction == Direction.EAST && maze.isMovable(posWest))
            {
                setPosition(this.position.getPosToWest());
                this.direction = Direction.WEST;
            }
        
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
