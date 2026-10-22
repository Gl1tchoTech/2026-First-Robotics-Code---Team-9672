package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.CANFuelSubsystem;

public class runAutoShooter extends Command {
  private final CANFuelSubsystem fuelSubsystem;

  public runAutoShooter(CANFuelSubsystem fuelSubsystem) {
    this.fuelSubsystem = fuelSubsystem;
    addRequirements(fuelSubsystem);
  }

  // The Shooter for Atonomous
  @Override
  public void initialize() {
    fuelSubsystem.runAutoShooter();
  }

  @Override
  public void end(boolean interrupted) {
    fuelSubsystem.stop();
  }
}