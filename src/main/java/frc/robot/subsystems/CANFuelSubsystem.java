package frc.robot.subsystems;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.config.SparkMaxConfig;
import com.revrobotics.spark.SparkBase.PersistMode;
import com.revrobotics.spark.SparkBase.ResetMode;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.Constants.FuelConstants;

public class CANFuelSubsystem extends SubsystemBase {
  /* 
  Check if your physical motors are Brushed (2 wires) or Brushless (3 wires + encoder cable)
  Ensure this is set Correctly or Else the Motors will not Function
  */
  public final SparkMax feederMotor = new SparkMax(FuelConstants.FEEDER_MOTOR_ID, MotorType.kBrushed);
  public final SparkMax launcherMotor = new SparkMax(FuelConstants.INTAKE_LAUNCHER_MOTOR_ID, MotorType.kBrushed);

  @SuppressWarnings("removal")
public CANFuelSubsystem() {
    SparkMaxConfig config = new SparkMaxConfig();
    config.smartCurrentLimit(FuelConstants.FEEDER_MOTOR_CURRENT_LIMIT);
    
    feederMotor.configure(config, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
    launcherMotor.configure(config, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
  }

  // The Command for the Intake, Can bind to Any Button
  public void runIntake() {
    launcherMotor.setVoltage(-12);
    feederMotor.setVoltage(-12);
  } 
  
  // The Command for the Shooter, Can bind to Any Button
  public void runShooter() {
    launcherMotor.setVoltage(FuelConstants.INTAKING_INTAKE_VOLTAGE);
    feederMotor.setVoltage(-12);
  }   

   public void runFeeder() {
    feederMotor.setVoltage(-12);
   }

   // The Command for the Autonomous Shooter
  public void runAutoShooter() {
    launcherMotor.setVoltage(FuelConstants.INTAKING_INTAKE_VOLTAGE);
    feederMotor.setVoltage(-12);
  }

  //The Command to Eject a Ball, Can bind to Any Button
  public void runEject() {
    feederMotor.setVoltage(10);
    launcherMotor.setVoltage(12);
  }

  // Stops Both Intake and Shooter Motors after Button is Released
  public void stop() {
    feederMotor.setVoltage(0);
    launcherMotor.setVoltage(0);
  }
}