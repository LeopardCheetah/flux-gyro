// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;


import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj2.command.SubsystemBase;


public class Navx extends SubsystemBase {
  /** Creates a new Navx. */

  // why do i even name it like this
  private AHRS m_gyro = new AHRS(SPI.Port.kMXP);
  
  public Navx() {}

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }


  public void calibrateGyro(){
    // essentially reset it to 0
    m_gyro.calibrate();
  }

  public double getAltitude(){
    return m_gyro.getAltitude();
  }

  public double getTotalAngle(){
    // mod 360 if you want an "actual value"
    return m_gyro.getAngle();
  }

  public double getAngle(){
    // returns angle from 0-360
    return m_gyro.getAngle() - 360*(int)(m_gyro.getAngle()/360);
  }


  public double getPitch(){
    // higher pitch - bot is doing a wheelie
    // lower pitch - bot just landed a jump

    return m_gyro.getPitch(); 
  }

  public double getRoll(){
    // higher roll - Bot is leaning towards the right
    // lower roll - bot is leaning towards the left

    return m_gyro.getRoll();
  }

  // getYaw -- use getTotalAngle - they should be about the same

}
