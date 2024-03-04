// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;
public class Romii extends CommandBase {
  private final Drivetrain m_drivetrain;
  private int passo;
  private boolean var = false;
  /** Creates a new Romi. */
  public Romii(Drivetrain drivetrain, int passy) {
    m_drivetrain = drivetrain;
    passo = passy;
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
      m_drivetrain.arcadeDrive(0.5, 0);
      System.out.println(m_drivetrain.getLeftDistanceInch());
      System.out.println(m_drivetrain.getRightDistanceInch());
      if (m_drivetrain.getLeftDistanceInch() >= passo){
        var = true;
      }
      if (m_drivetrain.getRightDistanceInch() >= passo){
        var= true; 
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

