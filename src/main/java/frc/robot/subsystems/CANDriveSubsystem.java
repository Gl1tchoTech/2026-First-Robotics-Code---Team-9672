package frc.robot.subsystems;

import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.config.SparkMaxConfig;
import com.revrobotics.spark.SparkBase.PersistMode;
import com.revrobotics.spark.SparkBase.ResetMode;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.DriveConstants;
import java.util.function.DoubleSupplier;

public class CANDriveSubsystem extends SubsystemBase {
  private final SparkMax leftLeader = new SparkMax(DriveConstants.LEFT_LEADER_ID, MotorType.kBrushless);
  private final SparkMax leftFollower = new SparkMax(DriveConstants.LEFT_FOLLOWER_ID, MotorType.kBrushless);
  private final SparkMax rightLeader = new SparkMax(DriveConstants.RIGHT_LEADER_ID, MotorType.kBrushless);
  private final SparkMax rightFollower = new SparkMax(DriveConstants.RIGHT_FOLLOWER_ID, MotorType.kBrushless);
  

  private final DifferentialDrive m_drive = new DifferentialDrive(leftLeader, rightLeader);

  @SuppressWarnings("removal")
  public CANDriveSubsystem() {
    SparkMaxConfig config = new SparkMaxConfig();
    config.smartCurrentLimit(DriveConstants.DRIVE_MOTOR_CURRENT_LIMIT);

    leftFollower.configure(config.follow(leftLeader), ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
    leftLeader.configure(config.disableFollowerMode().inverted(false), ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);

    rightFollower.configure(config.follow(rightLeader), ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
    rightLeader.configure(config.disableFollowerMode().inverted(true), ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
  }

  public Command driveArcade(DoubleSupplier xSpeed, DoubleSupplier zRotation) {
    return run(() -> m_drive.arcadeDrive(xSpeed.getAsDouble(), zRotation.getAsDouble()));
  }
}