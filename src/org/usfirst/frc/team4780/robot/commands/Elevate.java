package org.usfirst.frc.team4780.robot.commands;

import org.usfirst.frc.team4780.robot.Robot;

import org.usfirst.frc.team4780.robot.subsystems.Elevator;

import edu.wpi.first.wpilibj.command.Command;


/**
 *
 */
public class Elevate extends Command {
	protected Elevator elevator;
	public Elevate() {
		requires(elevator);
	}

	protected double speed;
	
    // Called just before this Command runs the first time
    protected void initialize() {
    }
    
    protected Elevate(Elevator elevator, double speed) {
    	setInterruptible(true);
    	this.elevator = elevator;
    	requires(elevator);
    	
    	this.speed = speed;
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	elevator.setSpeed(speed);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
