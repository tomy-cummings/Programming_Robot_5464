/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


public class Robot extends IterativeRobot {
	Joystick stick = new Joystick(0);
	
	WPI_TalonSRX LeftMotor = new WPI_TalonSRX(1);
	WPI_TalonSRX RightMotor = new WPI_TalonSRX(2);
	WPI_TalonSRX LiftMotor = new WPI_TalonSRX(0);
	WPI_TalonSRX AngleMotor = new WPI_TalonSRX(3);
	Encoder LeftEncoder = new Encoder(8,9);
	Encoder RightEncoder = new Encoder(7,6);
	Encoder LiftEncoder = new Encoder(4,5);
	Encoder AngleEncoder = new Encoder(2,3);
	
	Servo AngleServo = new Servo(0);
	Servo LiftServo = new Servo(1);

	
	DifferentialDrive drive = new DifferentialDrive(LeftMotor, RightMotor);


	@Override
	public void robotInit() {

	}


	@Override
	public void autonomousInit() {

	}


	@Override
	public void autonomousPeriodic() {

	}


	@Override
	public void teleopPeriodic() {
		drive.arcadeDrive(-stick.getRawAxis(1), stick.getRawAxis(0));
		
		if(stick.getPOV() == 0) {
			LiftMotor.set(1);
		}else if(stick.getPOV() == 180) {
			LiftMotor.set(-1);
		}else if(stick.getPOV() == -1) {
      LiftMotor.set(0);
		}
		
		if(stick.getRawButton(4)) {
			AngleMotor.set(0.25);
		}else if(stick.getRawButton(1)) {
			AngleMotor.set(-0.25);
		}else {
			AngleMotor.set(0);
		}
		
		if(stick.getRawButton(2)) {
			AngleServo.set(0);
		}else if(stick.getRawButton(3)) {
			AngleServo.set(1);
		}
		
		if(stick.getPOV() == 90) {
			LiftServo.set(0);
		}else if(stick.getPOV() == 270) {
			LiftServo.set(1);
		}
		
		// SmartDashboard.putNumber("Encoder Left", LeftEncoder.get());
		// SmartDashboard.putNumber("Encoder Right", RightEncoder.get());
		// SmartDashboard.putNumber("Encoder Lift", LiftEncoder.get());
		// SmartDashboard.putNumber("Encoder Angle", AngleEncoder.get());
		
	}

	@Override
	public void testPeriodic() {
	}
}