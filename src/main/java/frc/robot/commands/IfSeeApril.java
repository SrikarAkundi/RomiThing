// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.interfaces.Gyro;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.photonvisi;

public class IfSeeApril extends CommandBase {
  /** Creates a new SpeakerAlign. */
  Drivetrain m_romi;
  double absolutePos = 0;
  boolean done = false;
  photonvisi m_poto;
  public IfSeeApril(Drivetrain romi, photonvisi poto) {
    m_romi = romi;
    m_poto = poto;
    addRequirements(m_poto);
    // Use addRequirements() here to declare subsystem dependencies.
  }


  //If see april
  
  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    System.out.println(m_poto.turnAmount());
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
