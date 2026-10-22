package frc.robot;

public final class Constants {
  public static final class DriveConstants {
    // The ID's of the Motors in Rev Hardware Client
    public static final int LEFT_LEADER_ID = 4;
    public static final int LEFT_FOLLOWER_ID = 2;
    public static final int RIGHT_LEADER_ID = 9;
    public static final int RIGHT_FOLLOWER_ID = 8;
    
    // The Driver Motor Current Limit is not Linked, So this can be Ignored
    public static final int DRIVE_MOTOR_CURRENT_LIMIT = 75;
  }

  public static final class FuelConstants {
    // The Intake And Feeder Motor ID's in Rev Hardware Client
    public static final int FEEDER_MOTOR_ID = 6;
    public static final int INTAKE_LAUNCHER_MOTOR_ID = 12;

    public static final int FEEDER_MOTOR_CURRENT_LIMIT = 75;
    public static final int LAUNCHER_MOTOR_CURRENT_LIMIT = 75;
    /* 
    The Intake/Feeder Voltage Controls the speed of the Front Spinning Intake 
    and the Back Spinning Feeder, INTAKING_INTAKE_VOLTAGE: Back Spinning Shooter, Left Motor
    INTAKING_FEEDER_VOLTAGE: Front Spinning Intake, Right Motor
    */
    public static final double INTAKING_FEEDER_VOLTAGE = -12;
    public static final double INTAKING_INTAKE_VOLTAGE = 12;

    //Launching Feeder, Launcher and Spin Up Voltage/Seconds are Unused, So these can be Ignored.
    public static final double LAUNCHING_FEEDER_VOLTAGE = 9;
    public static final double LAUNCHING_LAUNCHER_VOLTAGE = 10.6;
    public static final double SPIN_UP_FEEDER_VOLTAGE = -6;
    public static final double SPIN_UP_SECONDS = 1;
  }

  public static final class OperatorConstants {
    // Driver controller Port is the number of the port in Driver Station,
    public static final int DRIVER_CONTROLLER_PORT = 0;

    // Drive Scaling and Rotation Scaling Control the speed of the robot
    // going Forward/Backward and The Turning Speed
    public static final double DRIVE_SCALING = .7;
    public static final double ROTATION_SCALING = .7;
  }
}