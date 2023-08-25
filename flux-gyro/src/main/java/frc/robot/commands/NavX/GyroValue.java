// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.NavX;

import frc.robot.subsystems.Navx;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class GyroValue extends CommandBase {
  /** Creates a new GyroValue. */


  private Navx m_navx;

  public GyroValue(Navx navx) {
    m_navx = navx;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_navx.calibrateGyro();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    SmartDashboard.putNumber("Altitude", m_navx.getAltitude());
    SmartDashboard.putNumber("Gyro Pitch", m_navx.getPitch());
    SmartDashboard.putNumber("Gyro Yaw", m_navx.getAngle());
    SmartDashboard.putNumber("Cumulative Yaw", m_navx.getTotalAngle());
    SmartDashboard.putNumber("Gyro Roll", m_navx.getRoll());
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
