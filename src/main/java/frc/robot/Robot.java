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
  private DutyCycleEncoder[] m_dutyCycleEncoder = new DutyCycleEncoder[4];
  public static final int  DIO_FrontLeft = 0;  //constant for DIO channel # on RoboRio (not a PWM channel)
  public static final int  DIO_FrontRight = 1;  //constant for DIO channel # on RoboRio (not a PWM channel)
  public static final int  DIO_BackLeft = 2;  //constant for DIO channel # on RoboRio (not a PWM channel)
  public static final int  DIO_BackRight = 3;  //constant for DIO channel # on RoboRio (not a PWM channel)

  @Override
  public void robotInit() {
    m_dutyCycleEncoder[DIO_FrontLeft] = new DutyCycleEncoder(DIO_FrontLeft);
    m_dutyCycleEncoder[DIO_FrontRight] = new DutyCycleEncoder(DIO_FrontRight);
    m_dutyCycleEncoder[DIO_BackLeft] = new DutyCycleEncoder(DIO_BackLeft);
    m_dutyCycleEncoder[DIO_BackRight] = new DutyCycleEncoder(DIO_BackRight);

    // Set to 0.5 units per rotation - only need this if we are measuring distance
    m_dutyCycleEncoder[DIO_FrontLeft].setDistancePerRotation(0.5);    
    m_dutyCycleEncoder[DIO_FrontRight].setDistancePerRotation(0.5);    
    m_dutyCycleEncoder[DIO_BackLeft].setDistancePerRotation(0.5);    
    m_dutyCycleEncoder[DIO_BackRight].setDistancePerRotation(0.5);    
    
    // Set duty cycle range, meaning range of pulse duration, downtime vs uptime aka Dutycycle
    // i have also seen values here as (1.0/4098.0, 4096.0/4098.0) as that might edge it touch towards the bounds
    m_dutyCycleEncoder[DIO_FrontLeft].setDutyCycleRange(1.0/4096.0, 4095.0/4096.0); //min and max pulse width from the mag encoder datasheet
    m_dutyCycleEncoder[DIO_FrontRight].setDutyCycleRange(1.0/4096.0, 4095.0/4096.0);
    m_dutyCycleEncoder[DIO_BackLeft].setDutyCycleRange(1.0/4096.0, 4095.0/4096.0);
    m_dutyCycleEncoder[DIO_BackRight].setDutyCycleRange(1.0/4096.0, 4095.0/4096.0);

  }

  @Override
  public void robotPeriodic() {
    // Connected can be checked, and uses the frequency of the encoder
   // boolean connected = m_dutyCycleEncoder[DIO_FrontLeft].isConnected();

    // Duty Cycle Frequency in Hz
    //int frequency = m_dutyCycleEncoder.getFrequency();

    // Output of encoder
    //double output = m_dutyCycleEncoder.get();

    // Output scaled by DistancePerPulse - mainly used for encoders used for turning a drive wheel
    //double distance = m_dutyCycleEncoder.getDistance();
        
    // DutyCycle ouput - mainly used for encoders used for measuring an absolute angle (not relative)
    //double angle = m_dutyCycleEncoder[DIOchannel_0].getAbsolutePosition();
    

    //SmartDashboard.putNumber("Frequency", frequency);
    //SmartDashboard.putNumber("Output", output);
    //SmartDashboard.putNumber("Distance", distance);
    SmartDashboard.putBoolean("FrontLeft Connected", m_dutyCycleEncoder[DIO_FrontLeft].isConnected());
    SmartDashboard.putNumber("FrontLeft value", m_dutyCycleEncoder[DIO_FrontLeft].getAbsolutePosition());
    SmartDashboard.putNumber("FrontLeft Radians", m_dutyCycleEncoder[DIO_FrontLeft].getAbsolutePosition()* 2.0 * Math.PI);

    SmartDashboard.putBoolean("FrontRight Connected", m_dutyCycleEncoder[DIO_FrontRight].isConnected());
    SmartDashboard.putNumber("FrontRight value", m_dutyCycleEncoder[DIO_FrontRight].getAbsolutePosition());
    SmartDashboard.putNumber("FrontRight Radians", m_dutyCycleEncoder[DIO_FrontRight].getAbsolutePosition()* 2.0 * Math.PI);

    SmartDashboard.putBoolean("BackLeft Connected", m_dutyCycleEncoder[DIO_BackLeft].isConnected());
    SmartDashboard.putNumber("BackLeft value", m_dutyCycleEncoder[DIO_BackLeft].getAbsolutePosition());
    SmartDashboard.putNumber("BackLeft Radians", m_dutyCycleEncoder[DIO_BackLeft].getAbsolutePosition()* 2.0 * Math.PI);

    SmartDashboard.putBoolean("BackRight Connected", m_dutyCycleEncoder[DIO_BackRight].isConnected());
    SmartDashboard.putNumber("BackRight value", m_dutyCycleEncoder[DIO_BackRight].getAbsolutePosition());
    SmartDashboard.putNumber("BackRight Radians", m_dutyCycleEncoder[DIO_BackRight].getAbsolutePosition()* 2.0 * Math.PI);
  }
}
