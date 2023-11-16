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
class RightHandRuleRobotTest 
{
    
    private Maze maze;
    private RightHandRuleRobot robot;

    /**
     * Creates a maze and a RightHandRobot.
     * @throws Exception - Not needed here because no file is being used.
     */
    @BeforeEach
    void setup() throws Exception
    {
        
        String walls = "*S**\n*  G\n** *\n*  *\n****";
        Scanner scanner = new Scanner(walls);
        this.maze = new Maze(scanner);
        this.robot = new RightHandRuleRobot((maze));
    }
    
    /**
     * RightHandRobot moves the same every time and for the specific maze this
     * test has it only has one valid step count which is 9 steps.
     */
    @Test
    void move() {
        int i = 0;
        while(!(this.robot.hasReachedGoal())){
            this.robot.move();
            i++;}
        assertEquals(i,9);
    }
    
    /**
     * The robot takes one step and there can only be one option, this position
     * should always be the same.
     */
    @Test
    void getPosition() 
    {
        robot.move();
        assertEquals(robot.getPosition(), new Position(1,1));
    }

    /**
     * Tries the method hasReachedGoal on a non-goal position, then tries it 
     * again on actual goal position once it has reached goal.
     */
    @Test
    void hasReachedGoal() throws Exception {
        String mazeFile = "*S**\n*  G\n** *\n*  *\n*****";
        Scanner scanner2 =new Scanner(mazeFile);
        this.maze = new Maze(scanner2);
        assertFalse(robot.hasReachedGoal());
        int i=0;
        while (!robot.hasReachedGoal()) {
            robot.move();
            i++;
        }
        assertTrue(robot.hasReachedGoal());
        assertEquals(9,i);
    }
}