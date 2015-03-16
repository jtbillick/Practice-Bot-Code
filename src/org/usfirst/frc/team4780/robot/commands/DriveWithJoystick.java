package org.usfirst.frc.team4780.robot.commands;

import org.usfirst.frc.team4780.robot.Robot;
import org.usfirst.frc.team4780.robot.subsystems.DriveTrain;



import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveWithJoystick extends Command {
	protected DriveTrain driveTrain = Robot.driveTrain;
	private RobotDrive drive;

    public DriveWithJoystick() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.driveTrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {

    	//double twist;
    	
    }

    protected void drive(double x, double y, double speed) {
		// TODO Auto-generated method stub
    	x = Robot.oi.getXValue();
    	y = Robot.oi.getYValue();
    	drive(x, y, 0.75);
    	driveTrain.arcadeDrive(x, y);
    	Timer.delay(0.1);
		
	}

	// Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }

}
