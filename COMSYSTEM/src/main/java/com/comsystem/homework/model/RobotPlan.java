package com.comsystem.homework.model;

import java.util.List;

/**
 * A POJO representing the action plan of a robot
 * @param numberOfDays number of days required by the robot to execute the plan
 * @param numberOfStones number of stones that the robot will dig
 * @param robotActions the chronological ordering of a robot's actions. For example, [DIG, CLONE, DIG] means that
 *                     the robot dug, cloned himself and dug again
 */
public record RobotPlan(int numberOfDays,
                        int numberOfStones,
                        List<RobotAction> robotActions) {
}
