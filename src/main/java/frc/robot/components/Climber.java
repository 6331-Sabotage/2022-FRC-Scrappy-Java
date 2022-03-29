package frc.robot.components;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;

public class Climber {
    CANSparkMax m_climbLeft = new CANSparkMax(0, MotorType.kBrushless);
    CANSparkMax m_climbRight = new CANSparkMax(0, MotorType.kBrushless);

    MotorControllerGroup m_climb = new MotorControllerGroup(m_climbLeft, m_climbRight);

    double speed;

    public Climber(double speed) {
        this.speed = speed;
    }

    public void run(boolean go, boolean direction) {
        this.m_climb.set(go ? (direction ? this.speed : -this.speed) : 0);
    }
}
