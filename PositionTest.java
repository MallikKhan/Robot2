import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Test class for RightHandRuleRobot.
 * @author Mallik Khan
 * @since 2023-11-08
 * @version 1.0
 */
class PositionTest {

    /**
     * It verifies that the right X coordinate is returned with the getX method.
     */
    @Test
    void getX() 
    {
        Position position = new Position(2,3);
        Assertions.assertEquals(2,position.getX());
    }

    /**
     * It verifies that the right Y coordinate is returned with the getY method.
     */
    @Test
    void getY() 
    {
        Position position = new Position(2,3);
        Assertions.assertEquals(3,position.getY());
    }

    /**
     * It verifies that the right southern position is returned when calling 
     * the getPosToSouth method.
     */
    @Test
    void getPosToSouth() 
    {
        Position position = new Position(2,3);
        Position posSouth = position.getPosToSouth();
        Assertions.assertEquals(2,posSouth.getX());
        Assertions.assertEquals(4,posSouth.getY());
    }

    /**
     * It verifies that the right northern position is returned when calling 
     * the getPosToNorth method.
     */
    @Test
    void getPosToNorth() 
    {
        Position position = new Position(2,3);
        Position posNorth = position.getPosToNorth();
        Assertions.assertEquals(2,posNorth.getX());
        Assertions.assertEquals(2, posNorth.getX());
    }

    /**
     * It verifies that the right western position is returned when calling 
     * the getPosToWest method.
     */
    @Test
    void getPosToWest() 
    {
        Position position = new Position(2,3);
        Position posWest = position.getPosToWest();
        Assertions.assertEquals(1,posWest.getX());
        Assertions.assertEquals(3,posWest.getY());
    }

    /**
     * It verifies that the right eastern position is returned when calling 
     * the getPosToEast method.
     */
    @Test
    void getPosToEast() 
    {
        Position position = new Position(2,3);
        Position posEast = position.getPosToEast();
        Assertions.assertEquals(3,posEast.getX());
        Assertions.assertEquals(3,posEast.getY());
    }

    /**
     * This test checks if we can differentiate between different positions.
     */
    @Test
    void testEquals() 
    {
        Position position1 = new Position(2,3);
        Position position2 = new Position(2,3);
        Position position3 = new Position(4,5);
        Assertions.assertEquals(position1, position2);
        Assertions.assertNotEquals(position1,position3);
    }

    /**
     * It verifies that the hashCode method generates the same hash code for
     * the same positions.
     */
    @Test
    void testHashCode() 
    {
        Position position1 = new Position(2,3);
        Position position2 = new Position(2,3);
        Assertions.assertEquals(position1.hashCode(), position2.hashCode());
    }
}