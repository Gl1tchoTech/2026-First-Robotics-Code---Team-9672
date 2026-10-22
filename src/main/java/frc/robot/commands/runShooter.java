package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.CANFuelSubsystem;

public class runShooter extends Command {
  private final CANFuelSubsystem fuelSubsystem;

  public runShooter(CANFuelSubsystem fuelSubsystem) {
    this.fuelSubsystem = fuelSubsystem;
    addRequirements(fuelSubsystem);
  }

  // Runs the Shooter
  @Override
  public void initialize() {
    fuelSubsystem.runShooter();
  }

  @Override
  public void end(boolean interrupted) {
    fuelSubsystem.stop();
  }
}