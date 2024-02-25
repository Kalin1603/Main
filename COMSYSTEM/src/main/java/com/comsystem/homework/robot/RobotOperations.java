package com.comsystem.homework.robot;


import com.comsystem.homework.model.RobotAction;
import com.comsystem.homework.model.RobotPlan;

import java.util.ArrayList;
import java.util.List;

public class RobotOperations {

    /**
     * An algorithm that converts a number of days into an action plan.
     * @param days the number of days that the robot can work
     * @return The action plan <em>must maximize</em> the number of stones that the robot will dig. In other words, this
     *         algorithm must try to achieve the highest value of {@link RobotPlan#numberOfStones} possible for the
     *         number of provided days. The value of {@link RobotPlan#numberOfDays} is equal to the input
     *         days parameter
     * @see RobotPlan
     */
    public RobotPlan excavateStonesForDays(int days) {
        if (days <= 0) {
            throw new IllegalArgumentException("The number of days must be a positive number.");
        }
        int stones = 0;
        List<RobotAction> actions = new ArrayList<>();

        for (int i = 0; i < days; i++) {
            if (i % 2 != 0) {
                actions.add(RobotAction.CLONE);
            } else {
                actions.add(RobotAction.DIG);
                stones++;
            }
        }

        return new RobotPlan(days, stones, actions);
    }

    /**
     * An algorithm that converts a number of stones into an action plan. Essentially this algorithm is the inverse of
     * {@link #excavateStonesForDays(int)}.
     * @param numberOfStones the number of stones the robot has to collect
     * @return The action plan <em>must minimize</em> the number of days necessary for the robot to dig the
     *         provided number of stones. In other words, this algorithm must try to achieve the lowest value of
     *         {@link RobotPlan#numberOfDays} possible for the number of provided stones. The value of
     *         {@link RobotPlan#numberOfStones} is equal to the numberOfStones parameter
     * @see RobotPlan
     */
    public RobotPlan daysRequiredToCollectStones(int numberOfStones) {
        if (numberOfStones <= 0) {
            throw new IllegalArgumentException("The number of stones must be a positive number.");
        }
        int days = numberOfStones * 2 - 1;
        int currentStones = 0;
        List<RobotAction> actions = new ArrayList<>();

        for (int i = 0; i < days; i++) {
            actions.add(RobotAction.DIG);
            currentStones++;

            if (currentStones >= numberOfStones) {
                break;
            }

            actions.add(RobotAction.CLONE);
        }

        return new RobotPlan(days, currentStones, actions);
    }
}
