package frc.robot;
 
import edu.wpi.first.math.MathUtil;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.Constants.OperatorConstants;
import frc.robot.commands.runAutoShooter;
import frc.robot.commands.runShooter;
import frc.robot.subsystems.CANDriveSubsystem;
import frc.robot.subsystems.CANFuelSubsystem;

  // This Imports the Neccisary Commands from "CANDriveSubsystem"and "CANFuelSubsystem"
public class RobotContainer {
  private final CANDriveSubsystem m_driveSubsystem = new CANDriveSubsystem();
  private final CANFuelSubsystem m_ballSubsystem = new CANFuelSubsystem();

  // Creates a New Controller on the Specified Port "0"
  private final CommandXboxController m_driverController = 
      new CommandXboxController(OperatorConstants.DRIVER_CONTROLLER_PORT);

  public RobotContainer() {
    configureBindings();

   // The Joystick Logic, This is for Deadzone and changing the Moving/Turning Speed, Edit in "Constants.java"
    m_driveSubsystem.setDefaultCommand(
        m_driveSubsystem.driveArcade(
            () -> MathUtil.applyDeadband(-m_driverController.getLeftY(), 0.1) * OperatorConstants.DRIVE_SCALING,
            () -> MathUtil.applyDeadband(m_driverController.getRightX(), 0.1) * OperatorConstants.ROTATION_SCALING));
  }

  private void configureBindings()
  // Right Trigger is the Shooter
  {m_driverController.rightTrigger().whileTrue(
    m_ballSubsystem.runOnce(() -> m_ballSubsystem.feederMotor.setVoltage(-11))
        .andThen(Commands.waitSeconds(1))
        .andThen(new runShooter(m_ballSubsystem))
        .finallyDo(m_ballSubsystem::stop)
);

    // Left Trigger is The Intake for Balls
    m_driverController.leftTrigger().whileTrue(
         m_ballSubsystem.run(m_ballSubsystem::runIntake)
            .finallyDo(m_ballSubsystem::stop));
  }

  // The A Button is Binded to Eject the ball Through the Intake
  {m_driverController.a().whileTrue(
        m_ballSubsystem.run(m_ballSubsystem::runEject)
            .finallyDo(m_ballSubsystem::stop));}

public Command getAutonomousCommand() {
  return m_driveSubsystem.driveArcade(() -> 0.3, () -> 0.0)
      .withTimeout(2.0)
      .andThen(
          Commands.sequence(
              m_ballSubsystem.runOnce(m_ballSubsystem::runFeeder),
              Commands.waitSeconds(1.0),
              new runAutoShooter(m_ballSubsystem)
          )
      ) // This closes the sequence
      .withTimeout(13.0); // This closes the andThen
} // This closes the method
 }