package frc.robot.components;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;

public class Limelight {
    NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");
    NetworkTableEntry tx = table.getEntry("tx");
    NetworkTableEntry ty = table.getEntry("ty");
    NetworkTableEntry ta = table.getEntry("ta");

    Values currentValues = new Values(
        tx.getDouble(0.0),
        ty.getDouble(0.0),
        ta.getDouble(0.0)
    );

    public class Values {
        public double x, y, area;

        public Values(double x, double y, double area) {
            this.x = x;
            this.y = y;
            this.area = area;
        }

        @Override
        public String toString() {
            return x + ", " + y + ", " + area;
        }
    }

    public void updateValues() {
        this.currentValues = new Values(
            tx.getDouble(0.0),
            ty.getDouble(0.0),
            ta.getDouble(0.0)
        );
    }

    /** Returns the important values of the limelight. */
    public Values getValues() {
        this.updateValues();
        return this.currentValues;
    }

    /** Post Limelight values to the dashboard. */
    public void post() {
        Values values = this.currentValues;
        SmartDashboard.putNumber("Limelight: X", values.x);
        SmartDashboard.putNumber("Limelight: Y", values.y);
        SmartDashboard.putNumber("Limelight: Area", values.area);
    }
}