package org.usfirst.frc.team4780.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.Victor;

import org.usfirst.frc.team4780.robot.RobotMap;
import org.usfirst.frc.team4780.robot.commands.DriveWithJoystick;

/**
 *
 */
public class DriveTrain extends Subsystem {
	
	private Victor rightVictor;
	private Victor leftVictor;
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	public DriveTrain(){
		rightVictor = new Victor(RobotMap.rightVictorPort);
		leftVictor = new Victor(RobotMap.leftVictorPort);
	}
	
	public void drive(Joystick stick){
		double x = stick.getX();
		double y = stick.getY();
		leftVictor.set(x-y);
		rightVictor.set(x+y);
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new DriveWithJoystick());
    }

}


