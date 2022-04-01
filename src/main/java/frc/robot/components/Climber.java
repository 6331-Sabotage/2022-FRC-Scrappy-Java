package frc.robot.components;

import com.ctre.phoenix.motorcontrol.VictorSPXControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.motorcontrol.VictorSP;

public class Climber {
    VictorSPX m_climbLeft = new VictorSPX(6);
    //CANSparkMax m_climbLeft = new CANSparkMax(0, MotorType.kBrushless);
    // CANSparkMax m_climbRight = new CANSparkMax(0, MotorType.kBrushless);

    // MotorControllerGroup m_climb = new MotorControllerGroup(m_climbLeft, m_climbRight);

    double speed;

    public Climber(double speed) {
        this.speed = speed;
    }

    public void run(boolean go, boolean direction) {
        this.m_climbLeft.set(VictorSPXControlMode.PercentOutput, go ? (direction ? this.speed : -this.speed) : 0);
    }
}
