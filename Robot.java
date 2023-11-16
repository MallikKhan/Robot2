/**
 * The Robot interface is the interface for the Randomrobot, MemoryRobot and the
 * RightHandRuleRobot and contains the minimum necessary methods for the robots.
 *
 * @author Mallik Khan
 * @since 2023-11-08
 * @version 1.0
 */

public interface Robot
{
    /**
     * This is the method that makes the robot move.
     */
    public void move();

    /**
     * This method returns the current position of the robot.
     * @return Returns the current position
     */
    public Position getPosition();

    /**
     * Returns true if robot has reached the goal, otherwise false. 
     * @return The boolean value that gets returned
     */
    public boolean hasReachedGoal();
}
