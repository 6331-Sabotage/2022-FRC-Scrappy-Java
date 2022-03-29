package frc.robot.components;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

public class Intake {
    CANSparkMax m_intake = new CANSparkMax(0, MotorType.kBrushless);
    double speed;

    public Intake(double speed) {
        this.speed = speed;
    }

    public void run(boolean go, boolean direction) {
        this.m_intake.set(go ? (direction ? this.speed : -this.speed) : 0);
    }
}