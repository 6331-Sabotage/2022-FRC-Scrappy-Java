package frc.robot.components;

import frc.robot.adapters.VictorMotorAdapter;

import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;

public class Shooter {
    
    VictorSPX m_shoot1 = new VictorSPX(0);
    CANSparkMax m_shoot2 = new CANSparkMax(0, MotorType.kBrushed);

    MotorControllerGroup m_shoot = new MotorControllerGroup(new VictorMotorAdapter(m_shoot1), m_shoot2);

    RelativeEncoder encoder;

    public Shooter() {
        this.encoder = this.m_shoot2.getEncoder();
    }

    public boolean setSpeed(Limelight limelight) {
        double area = limelight.getValues().area;
        // TODO : Magic
        double speed = 0 /*change later*/;
        
        if (this.encoder.getVelocity() < speed) {
            m_shoot.set(1);
        } else {
            m_shoot.set(0);
        };

        final double value = 1;
        if ((this.encoder.getVelocity() < speed - value) ||
            (this.encoder.getVelocity() > speed + value)) {
                return false;
            } else {
                return true;
            }
    }

}
