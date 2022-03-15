package frc.robot.components;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.motorcontrol.Spark;

public class Drivetrain {
    Spark m_frontLeft = new Spark(0);
    Spark m_rearLeft = new Spark(0);
    MotorControllerGroup m_left = new MotorControllerGroup(m_frontLeft, m_rearLeft);

    Spark m_frontRight = new Spark(0);
    Spark m_rearRight = new Spark(0);
    MotorControllerGroup m_right = new MotorControllerGroup(m_frontRight, m_rearRight);

    DifferentialDrive m_drive = new DifferentialDrive(m_left, m_right);

    public Drivetrain(double speedMultiplier) {
        m_left.setInverted(true);
        m_drive.setMaxOutput(speedMultiplier);
    }

    public void drive(double yAxis, double xAxis) {
        m_drive.arcadeDrive(yAxis, xAxis);
    }
}
