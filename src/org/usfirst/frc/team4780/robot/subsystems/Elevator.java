package org.usfirst.frc.team4780.robot.subsystems;

import org.usfirst.frc.team4780.robot.Robot;
import org.usfirst.frc.team4780.robot.RobotMap;
import org.usfirst.frc.team4780.robot.commands.ElevateStop;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Elevator extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	private Talon elevatorTalon;
	
	
	public Elevator() {
		elevatorTalon = new Talon(RobotMap.elevatorTalonPort);
	}
		public void setSpeed(double elevatorSpeed){
			elevatorTalon.set(elevatorSpeed);
		}
	

    public void initDefaultCommand() {
    	
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new ElevateStop(this));
    }
}

