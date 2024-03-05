// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.interfaces.Gyro;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;

public class SpeakerAlign extends CommandBase {
  /** Creates a new SpeakerAlign. */
  Drivetrain m_romi;
  double absolutePos = 0;
  boolean done = false;
  public SpeakerAlign(Drivetrain romi) {
    m_romi = romi;
    addRequirements(m_romi);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_romi.arcadeDrive(0, 0.4);
    while(absolutePos > -90 || absolutePos < 90){
      m_romi.resetGyro();
      System.out.println(absolutePos);
      if(absolutePos > 90 || absolutePos < -90){
        break;
      }
      m_romi.arcadeDrive(0, 0.4);
      absolutePos += m_romi.getGyroAngleZ();
    }
      m_romi.arcadeDrive(0, 0);
      absolutePos = 0;
      done = true;
    
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return done;
  }
}
