package frc.robot.components;

import frc.robot.adapters.VictorSPXAdapter;

import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;

public class Shooter {
    CANSparkMax m_shooter1 = new CANSparkMax(0, MotorType.kBrushed);
    VictorSPX m_shooter2 = new VictorSPX(0);

    MotorControllerGroup m_shooter = new MotorControllerGroup(m_shooter1, new VictorSPXAdapter(m_shooter2));

    double speed;

    public Shooter(double speed) {
        this.speed = speed;
    }

    public void run(boolean go) {
        m_shooter.set(this.speed);
    }

    public void setSpeed(double newSpeed) {
        this.speed = newSpeed;
    }
}
