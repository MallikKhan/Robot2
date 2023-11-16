import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Scanner;

/**
 * Test class for RightHandRuleRobot.
 * @author Mallik Khan
 * @since 2023-11-08
 * @version 1.0
 */
public class MazeTest 
{
    private Maze maze;
    
    private Position position1;
    
    private Position position2;

    /**
     * Creates a maze.
     * @throws Exception - Not needed here because no file is being used.
     */
    @BeforeEach
    void setup() throws Exception
    {
        String mazeFile = "*****\n*S*G*\n*   *\n*****";
        Scanner scanner = new Scanner(mazeFile);
        this.maze = new Maze(scanner);
    }

    /**
     * Checks if a position that you shouldn't be able to move to is movable,
     * and if a movable position is movable.
     */
    @Test
    void isMovable() 
    {
        position1 = new Position(1,1);
        assertTrue(maze.isMovable(position1));
        
        position2 = new Position(0,0);
        assertFalse(maze.isMovable(position2));
    }

    /**
     * Checks if a position that should be goal is goal and if a position that
     * isn't goal is goal.
     */
    @Test
    void isGoal() 
    {
        position1 = new Position(3,1);
        assertTrue(maze.isGoal(position1));
        
        position2 = new Position(1,1);
        assertFalse(maze.isGoal(position2));
    }

    /**
     * Checks if the start position is start.
     */
    @Test
    void getStart() 
    {
        position1 = new Position(1,1);
        assertEquals(position1, maze.getStart());
    }

    /**
     * Checks if we can get the right amount of columns.
     */
    @Test
    void getNumColumns()
    {
        assertEquals(4,maze.getNumRows());
    }

    /**
     * Checks if we can get the right amount of rows.
     */
    @Test
    void getNumRows() 
    {
        assertEquals(5,maze.getNumColumns());
    }
    
}
