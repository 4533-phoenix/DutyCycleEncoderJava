// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

// Note purpose of this code is for testing the CTRE SRX Magnetic encoder
// but other encoders could be used.  

package frc.robot;

import edu.wpi.first.wpilibj.DutyCycleEncoder;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

@SuppressWarnings("PMD.SingularField")
public class Robot extends TimedRobot {
  private DutyCycleEncoder m_dutyCycleEncoder;
  public static final int  DIOchannel_0 = 0;  //constant for DIO channel # on RoboRio (not a PWM channel)

  @Override
  public void robotInit() {
    m_dutyCycleEncoder = new DutyCycleEncoder(DIOchannel_0);

    // Set to 0.5 units per rotation - only need this if we are measuring distance
    m_dutyCycleEncoder.setDistancePerRotation(0.5);    
    
    // Set duty cycle range, meaning range of pulse duration, downtime vs uptime aka Dutycycle
    // i have also seen values here as (1.0/4098.0, 4096.0/4098.0) as that might edge it touch towards the bounds
    m_dutyCycleEncoder.setDutyCycleRange(1.0/4096.0, 4095.0/4096.0); //min and max pulse width from the mag encoder datasheet
    
  }

  @Override
  public void robotPeriodic() {
    // Connected can be checked, and uses the frequency of the encoder
    boolean connected = m_dutyCycleEncoder.isConnected();

    // Duty Cycle Frequency in Hz
    int frequency = m_dutyCycleEncoder.getFrequency();

    // Output of encoder
    double output = m_dutyCycleEncoder.get();

    // Output scaled by DistancePerPulse - mainly used for encoders used for turning a drive wheel
    double distance = m_dutyCycleEncoder.getDistance();
        
    // DutyCycle ouput - mainly used for encoders used for measuring an absolute angle (not relative)
    double angle = m_dutyCycleEncoder.getAbsolutePosition();
    

    SmartDashboard.putBoolean("Connected", connected);
    SmartDashboard.putNumber("Frequency", frequency);
    SmartDashboard.putNumber("Output", output);
    SmartDashboard.putNumber("Distance", distance);
    SmartDashboard.putNumber("Angle", angle);
  }
}
