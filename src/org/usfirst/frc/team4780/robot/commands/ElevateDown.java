package org.usfirst.frc.team4780.robot.commands;

import org.usfirst.frc.team4780.robot.subsystems.Elevator;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ElevateDown extends Elevate {

    public ElevateDown(Elevator elevator) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
		super(elevator, -.65);
		setInterruptible(false);
    }

  

    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
