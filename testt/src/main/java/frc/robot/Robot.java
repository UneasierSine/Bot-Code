/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.*;
/**
 * This is a demo program showing the use of the RobotDrive class, specifically
 * it contains the code necessary to operate a robot with tank drive.
 */
public class Robot extends TimedRobot {
  private PowerDistributionPanel pdp;
  private DifferentialDrive m_myRobot;
  private Joystick m_leftStick;
  private Joystick m_rightStick;
  private SpeedControllerGroup m_leftSide;
  private SpeedControllerGroup m_rightSide;

  @Override
  public void robotInit() {
    m_leftSide = new SpeedControllerGroup(new Talon(1), new Talon(2));
    m_rightSide = new SpeedControllerGroup(new Talon(3), new Talon(4));
    pdp = new PowerDistributionPanel();
    m_myRobot = new DifferentialDrive(m_leftSide, m_rightSide);
    m_leftStick = new Joystick(0);
    m_rightStick = new Joystick(1);
  }

  @Override
  public void teleopPeriodic() {
    for(int x = 0; x < 100; x++){
    pdp.clearStickyFaults();
    }
    m_myRobot.tankDrive(m_leftStick.getY(), m_rightStick.getY());
  }
}
