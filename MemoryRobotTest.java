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
class MemoryRobotTest 
{
    private Maze maze;
    
    private MemoryRobot robot;

    /**
     * Creates a maze and a MemoryRobot.
     * @throws Exception - Not needed here because no file is being used.
     */
    @BeforeEach
    void setup() throws Exception
    {
        // Create a maze object
        String mazeFile = "*S***\n* ***\n*  G*\n*****";
        Scanner scanner = new Scanner(mazeFile);
        this.maze = new Maze(scanner);
        
        // Create a MemoryRobot object with the created maze object
        robot = new MemoryRobot(maze);
    }

    /**
     * Moves one step and the position shouldn't be the same anymore.
     */
    @Test
    void move() 
    {
        robot.move();
        assertNotEquals(maze.getStart(),robot.getPosition());
    }

    /**
     * Create the same position of the robot and the method should return the
     * current position of the robot.
     */
    @Test
    void getPosition() 
    {
        Position wantedPos = new Position(1,0);
        
        Position currentPos = robot.getPosition();
        assertEquals(wantedPos,currentPos);
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