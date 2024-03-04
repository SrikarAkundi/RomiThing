// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;
public class romiturny extends CommandBase {
  private final Drivetrain m_drivetrain;
  private double varre;
  private boolean var = false;
  /** Creates a new Romi. */
  public romiturny(Drivetrain drivetrain) {
    m_drivetrain = drivetrain;
    addRequirements(drivetrain);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    System.out.println("hello");
  }

  // Called every time the cheduler runs while the command is scheduled.
  @Override
  public void execute() {
    varre = m_drivetrain.getGyroAngleY()-m_drivetrain.getAccelY();
    System.out.println(varre);
      if (m_drivetrain.getGyroAngleY()<varre){
        m_drivetrain.arcadeDrive(varre/100, 0);
      }
      if (m_drivetrain.getGyroAngleY()>varre){
        m_drivetrain.arcadeDrive(varre/100, 0);
      }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    System.out.println("bye");
  }


  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return var;
  }
}


