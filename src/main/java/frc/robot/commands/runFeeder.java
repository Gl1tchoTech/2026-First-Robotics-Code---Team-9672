package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.CANFuelSubsystem;

public class runFeeder extends Command {
  private final CANFuelSubsystem fuelSubsystem;

  public runFeeder(CANFuelSubsystem fuelSubsystem) {
    this.fuelSubsystem = fuelSubsystem;
    addRequirements(fuelSubsystem);
  }

  // Initilizes the Intake
  @Override
  public void initialize() {
    fuelSubsystem.runIntake();
  }

  // Ends the Intake Command
  @Override
  public void end(boolean interrupted) {
    fuelSubsystem.stop();
  }
}