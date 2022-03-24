package frc.robot.components;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

public class Intake {
    double speed;
    
    CANSparkMax m_intake = new CANSparkMax(5, MotorType.kBrushed);
    
    public Intake(double speed) {
        this.speed = speed;
    }

    public void in(boolean go) {
        this.m_intake.set(go ? this.speed : 0);
    }
}