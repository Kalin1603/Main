package com.comsystem.homework.robot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RobotOperationsTest {

    @Test
    public void excavateStonesForDaysTest(){
        var operations = new RobotOperations();
        var robotPlan = operations.excavateStonesForDays(5);

        assertEquals(5, robotPlan.numberOfDays());
        assertEquals(3, robotPlan.numberOfStones());
        assertEquals(5, robotPlan.robotActions().size());
    }

    @Test
    public void daysRequiredToCollectStonesTest(){
        var operations = new RobotOperations();
        var robotPlan = operations.daysRequiredToCollectStones(7);

        assertEquals(13, robotPlan.numberOfDays());
        assertEquals(7, robotPlan.numberOfStones());
        assertEquals(13, robotPlan.robotActions().size());
    }
}