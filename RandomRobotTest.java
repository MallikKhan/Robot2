import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for RightHandRuleRobot.
 * @author Mallik Khan
 * @since 2023-11-08
 * @version 1.0
 */
class RandomRobotTest 
{
    
    private Maze maze;
    
    private RandomRobot robot;

    /**
     * Creates a maze and a RandomRobot.
     * @throws Exception - Not needed here because no file is being used.
     */
    @BeforeEach
    void setup() throws  Exception
    {
        // Create a maze object
        String mazeFile = "********\n*S    G*\n********";
        Scanner scanner = new Scanner(mazeFile);
        this.maze = new Maze(scanner);

        // Create a RandomRobot object with the created maze object
        robot=new RandomRobot(maze);
    }

    /**
     * The robot should only move forward, not backwards. Moves to new positions.
     * With the current maze it finishes the maze in 5 moves.
     */
    @Test
    void move() 
    {
        int i = 0;
        while (!robot.hasReachedGoal())
        {
            robot.move();
            i++;
        }
        assertEquals(5,i);
        robot.move();
        assertNotEquals(maze.getStart(), robot.getPosition());
    }

    /**
     * Create the same position of the robot and the method should return the
     * current position of the robot.
     */
    @Test
    void getPosition() 
    {
        Position wantedPosition = new Position(1,1);
        
        
        Position currentPosition = robot.getPosition();
        assertEquals(wantedPosition, currentPosition);
    }

    /**
     * Tries the method hasReachedGoal on a non-goal position, then tries it 
     * again on actual goal position once it has reached goal.
     */
    @Test
    void hasReachedGoal() 
    {
        assertFalse(robot.hasReachedGoal());
        while (!robot.hasReachedGoal())
        {
            robot.move();
        }
        assertTrue(robot.hasReachedGoal());
    }
}