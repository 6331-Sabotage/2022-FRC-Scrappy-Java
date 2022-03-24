package frc.robot.components;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;

public class Drivetrain {
    CANSparkMax m_frontLeft = new CANSparkMax(2, MotorType.kBrushless);
    CANSparkMax m_rearLeft = new CANSparkMax(8, MotorType.kBrushless);
    
    MotorControllerGroup m_left = new MotorControllerGroup(m_frontLeft, m_rearLeft);

    CANSparkMax m_frontRight = new CANSparkMax(4, MotorType.kBrushless);
    CANSparkMax m_rearRight = new CANSparkMax(3, MotorType.kBrushless);
    
    MotorControllerGroup m_right = new MotorControllerGroup(m_frontRight, m_rearRight);

    DifferentialDrive m_drive = new DifferentialDrive(m_left, m_right);

    public Drivetrain(double speedMultiplier) {
        m_left.setInverted(true);
        m_drive.setMaxOutput(speedMultiplier);
    }

    public void drive(double yAxis, double xAxis) {
        m_drive.arcadeDrive(yAxis, -xAxis);
    }
}
