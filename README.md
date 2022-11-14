# DutyCycleEncoderJava

Test repo for DutyCycleEncoder encoder type which is native to FRC Robotics WPIlib and used for Swerve drive steering because it allows Absolute angle to be read.  It is also helpful for other things like arm angle measurement.

This code now prints out 4 encoder values and angles in radians. This will help calibrate for swerve drive.

DutyCycleEncoder is an encoder type native to FRC Robotics WPIlib
DutyCycleEncoder reads an encoders absolute position in angle 0 to 360.
it's output is a float value from 0.0 to 1.0 and so you multiply it by 2.0 * Math.PI to convert to Angle in Radians.
Or you could multiply by 360.0 to convert to a degrees angle.


Another built in is Encoder type is the FRC type Encoder which is better suited 
for measuring speed and change rate as it uses the quadrature outputs from the encoder.


Purpose of this was to prove that our early swerve drive could read absolute wheel direction angle.
Encoder used here was the CTRE SRX Magnetic encoder, as we have many of those, and when
the project started, CANCoders were not available. 

You could plug in more encoders and print them all out to the SmartDashboard.

This project could be created from scratch using the WPI plugins to VScode , and choosing the Create New Project option, Example, Java then choosing Duty Cycle Encoder. Note some optional variables and functions were added to the Robot.java code herein to give better absolute angle info.




