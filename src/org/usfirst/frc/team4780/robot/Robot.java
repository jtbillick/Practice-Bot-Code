package org.usfirst.frc.team4780.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

import org.usfirst.frc.team4780.robot.commands.ExampleCommand;
import org.usfirst.frc.team4780.robot.subsystems.DriveTrain;
import org.usfirst.frc.team4780.robot.subsystems.Elevator;
import org.usfirst.frc.team4780.robot.subsystems.ExampleSubsystem; 

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
Victor leftVictor = new Victor(RobotMap.leftVictorPort);
Victor rightVictor = new Victor(RobotMap.rightVictorPort);
RobotDrive drive = new RobotDrive(leftVictor, rightVictor);
	public static final ExampleSubsystem exampleSubsystem = new ExampleSubsystem();
	public static DriveTrain driveTrain;
	public static Joystick joystick;
	public static Elevator elevator;
	public static OI oi;
	

    Command autonomousCommand;

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
    	
    	elevator = new Elevator();
    	oi = new OI();
    	
		
        // instantiate the command used for the autonomous period
        autonomousCommand = new ExampleCommand();
    }
	
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

    public void autonomousInit() {
        // schedule the autonomous command (example)
        if (autonomousCommand != null) autonomousCommand.start();
        while (isAutonomous() && isEnabled()) {
        	drive.setSafetyEnabled(false);
        	drive.drive(0.75, 0.0);
        	Timer.delay(0.4);
        }
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
        
    }

    public void teleopInit() {
		// This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to 
        // continue until interrupted by another command, remove
        // this line or comment it out.
        if (autonomousCommand != null) autonomousCommand.cancel();
        }
    
    /**
     * This function is called when the disabled button is hit.
     * You can use it to reset subsystems before shutting down.
     */
    public void disabledInit(){

    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
}
